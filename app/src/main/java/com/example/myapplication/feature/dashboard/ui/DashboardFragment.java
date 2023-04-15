package com.example.myapplication.feature.dashboard.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.myapplication.databinding.FragmentDashboardBinding;
import com.example.myapplication.domain.model.User;
import com.example.myapplication.feature.dashboard.presentation.DashboardStatus;
import com.example.myapplication.feature.dashboard.presentation.DashboardViewModel;
import com.example.myapplication.feature.dashboard.ui.recycler.UserAdapter;
import com.example.myapplication.feature.dashboard.ui.recycler.UserClickListener;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
    private DashboardViewModel viewModel;
    private FragmentDashboardBinding binding;
    private UserAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        binding = FragmentDashboardBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new UserAdapter(id -> Navigation.findNavController(binding.getRoot()).navigate(DashboardFragmentDirections.actionDashboardToProfile(id)));
        binding.recycler.setAdapter(adapter);
        List<User> users = new ArrayList<>();
        viewModel.status.observe(getViewLifecycleOwner(), this::renderStatus);
        viewModel.users.observe(getViewLifecycleOwner(), this::renderUser);
        if (savedInstanceState == null) viewModel.load();

    }
    private void renderStatus(DashboardStatus status){
        switch (status){
            case LOADING:
                binding.recycler.setVisibility(View.INVISIBLE);
                binding.empty.setVisibility(View.INVISIBLE);
                binding.error.setVisibility(View.INVISIBLE);
                binding.progress.setVisibility(View.VISIBLE);
                break;
            case LOADED:
                binding.recycler.setVisibility(View.VISIBLE);
                binding.error.setVisibility(View.INVISIBLE);
                binding.progress.setVisibility(View.INVISIBLE);


                break;
            case FALURE:
                binding.recycler.setVisibility(View.INVISIBLE);
                binding.empty.setVisibility(View.INVISIBLE);
                binding.error.setVisibility(View.VISIBLE);
                binding.progress.setVisibility(View.INVISIBLE);
                break;
        }
    }

    private void renderUser(List<User> users){
        binding.empty.setVisibility(users.isEmpty() ? View.VISIBLE : View.INVISIBLE);
        adapter.setItems(users);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
