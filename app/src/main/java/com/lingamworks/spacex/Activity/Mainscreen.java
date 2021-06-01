package com.lingamworks.spacex.Activity;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import com.lingamworks.spacex.DAO.CrewDAO;
import com.lingamworks.spacex.DAO.database;
import com.lingamworks.spacex.Interface.Crew;
import com.lingamworks.spacex.R;
import com.lingamworks.spacex.Util.constants;
import com.lingamworks.spacex.databinding.ActivityMainscreen2Binding;
import com.lingamworks.spacex.databinding.FragmentMainMenuBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Mainscreen extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainscreen2Binding binding;
    database db;
    CrewDAO crewDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainscreen2Binding.inflate(getLayoutInflater());
        setSupportActionBar(binding.toolbar);
        setContentView(binding.getRoot());
        crewsync();
        binding.getRoot().findViewById(R.id.llMainMenu).setVisibility(View.GONE);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_mainscreen2);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_mainscreen2);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void crewsync(){
        Snackbar snackbar=Snackbar.make(binding.getRoot(), "Sync Started", 3000)
                .setAction("Action", null);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(new constants().Baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Crew.getAllCrew service=retrofit.create(Crew.getAllCrew.class);
        Call<List<com.lingamworks.spacex.Data.Crew>> call=service.getallcrewjson();
        call.enqueue(new Callback<List<com.lingamworks.spacex.Data.Crew>>() {
            @Override
            public void onResponse(Call<List<com.lingamworks.spacex.Data.Crew>> call, Response<List<com.lingamworks.spacex.Data.Crew>> response) {
                snackbar.show();
                List<com.lingamworks.spacex.Data.Crew> list=new ArrayList<>(response.body());
                snackbar.dismiss();
                Snackbar.make(binding.getRoot(), "Sync Completed Fetched Total Records Of "+list.size(), 3000)
                        .setAction("Action", null).show();
                binding.getRoot().findViewById(R.id.llMainMenu).setVisibility(View.VISIBLE);
                binding.getRoot().findViewById(R.id.tvSyncStatus).setVisibility(View.GONE);
               Thread thread=new Thread(){
                 @Override
                 public void run(){

                     db= Room.databaseBuilder(getApplicationContext(),
                             database.class, "spacex").build();
                     crewDAO = db.crewDAO();
                     crewDAO.clearCrew();
                     for(com.lingamworks.spacex.Data.Crew value : list)
                         crewDAO.insertAll(value);
                 }
               };
               thread.start();

            }

            @Override
            public void onFailure(Call<List<com.lingamworks.spacex.Data.Crew>> call, Throwable t) {
                Snackbar.make(binding.getRoot(), "It Seems your offline or server is unreachable using last know data ", 3000)
                        .setAction("Action", null).show();
                binding.getRoot().findViewById(R.id.llMainMenu).setVisibility(View.VISIBLE);
                binding.getRoot().findViewById(R.id.tvSyncStatus).setVisibility(View.GONE);
            }
        });
    }
    public void crewDelete(){
        Thread thread=new Thread(){
            @Override
            public void run(){

                db= Room.databaseBuilder(getApplicationContext(),
                        database.class, "spacex").build();
                crewDAO = db.crewDAO();
                crewDAO.clearCrew();
                Snackbar.make(binding.getRoot(), "Crew Deleted", 3000)
                        .setAction("Action", null).show();
            }
        };
        thread.start();
    }

}