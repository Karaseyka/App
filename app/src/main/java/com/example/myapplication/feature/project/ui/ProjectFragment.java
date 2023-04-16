package com.example.myapplication.feature.project.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.myapplication.databinding.FragmentOpenedAdvertistmentBinding;
import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.feature.profile.Profile;
import com.example.myapplication.feature.project.presentation.ProjectViewModel;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ProjectFragment extends Fragment {
    private ProjectViewModel viewModel;
    private SharedPreferences sp;
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
        sp = requireActivity().getSharedPreferences("User_info", Context.MODE_PRIVATE);
        binding.ssylkaProfileContackt.setText(sp.getString(Profile.TM, ":("));
        binding.nameOfProject.setText(user.getName());
        binding.description.setText(user.getDescription());
        binding.nameOfProject.setText(user.getName());
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        storageReference.child(user.getFoto_id() + ".jpeg");
        Glide.with(binding.getRoot()).load("https://firebasestorage.googleapis.com/v0/b/myapplication5-50c5d.appspot.com/o/images%2F"+user.getFoto_id()+"?alt=media&token=a05a10b5-5f6c-4a79-a075-d13932945427")
                .into(binding.advertismentImageview);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
