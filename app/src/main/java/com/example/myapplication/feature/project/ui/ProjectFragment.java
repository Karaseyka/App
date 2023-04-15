package com.example.myapplication.feature.project.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentOpenedAdvertistmentBinding;
import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.feature.project.presentation.ProjectViewModel;

public class ProjectFragment extends Fragment {
    private ProjectViewModel viewModel;
    private ProjectFragmentArgs args;
    private FragmentOpenedAdvertistmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(ProjectViewModel.class);
        args = ProjectFragmentArgs.fromBundle(requireArguments());
        binding = FragmentOpenedAdvertistmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.user.observe(getViewLifecycleOwner(), this::renderUser);
        if (savedInstanceState == null) viewModel.load(args.getId());


    }


    private void renderUser(Projects user){
        binding.nameOfProject.setText(user.getName());
        binding.description.setText(user.getDescription());


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
