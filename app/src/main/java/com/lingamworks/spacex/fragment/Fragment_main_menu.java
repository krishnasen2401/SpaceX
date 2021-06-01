package com.lingamworks.spacex.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.lingamworks.spacex.Activity.Mainscreen;
import com.lingamworks.spacex.R;
import com.lingamworks.spacex.databinding.FragmentMainMenuBinding;

public class Fragment_main_menu extends Fragment {

    private FragmentMainMenuBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMainMenuBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Fragment_main_menu.this)
                        .navigate(R.id.action_First2Fragment_to_Second2Fragment);
            }
        });
        binding.refresh.setOnClickListener(v -> ((Mainscreen)getActivity()).crewsync());
        binding.delete.setOnClickListener(v -> ((Mainscreen)getActivity()).crewDelete());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}