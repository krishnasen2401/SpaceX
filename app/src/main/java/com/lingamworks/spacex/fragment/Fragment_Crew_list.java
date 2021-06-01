package com.lingamworks.spacex.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.room.Room;

import com.lingamworks.spacex.Activity.Mainscreen;
import com.lingamworks.spacex.Adapter.CrewLevel1;
import com.lingamworks.spacex.DAO.database;
import com.lingamworks.spacex.Data.Crew;
import com.lingamworks.spacex.databinding.FragmentCrewListBinding;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Crew_list extends Fragment {

    private FragmentCrewListBinding binding;
    CrewLevel1 myRecyclerViewAdapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentCrewListBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        ((SimpleItemAnimator) binding.rvCrewList.getItemAnimator()).setSupportsChangeAnimations(false);
        binding.rvCrewList.setLayoutManager(mLayoutManager);
        Thread thread=new Thread(){
            @Override
            public void run(){
                List<Crew> mlist=new ArrayList<>(Room.databaseBuilder((Mainscreen)getActivity(),
                        database.class, "spacex").build().crewDAO().getcrew());

                ((Mainscreen)getActivity()).runOnUiThread(new Runnable(){
                    public void run() {
                        myRecyclerViewAdapter = new CrewLevel1(mlist,(Mainscreen)getActivity(),binding.rvCrewList);
                        binding.rvCrewList.setAdapter(myRecyclerViewAdapter);
                        }
                });
                }
        };
        thread.start();

//        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(Second2Fragment.this)
//                        .navigate(R.id.action_Second2Fragment_to_First2Fragment);
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}