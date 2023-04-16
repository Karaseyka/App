package com.example.myapplication.feature.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentOpenedAdvertistmentBinding;
import com.example.myapplication.databinding.FragmentProfileBinding;
import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.feature.project.presentation.ProjectViewModel;


import java.util.Objects;

public class Profile extends Fragment {
    private ProjectViewModel viewModel;
    private SharedPreferences sp;
    private final String NAME = "name";
    public static final String NICK = "nick";
    public static final String TM = "telegram";
    private FragmentProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            sp = requireActivity().getSharedPreferences("User_info", Context.MODE_PRIVATE);
            binding.surname.setText(sp.getString(NAME, "11"));
            binding.nickname.setText(sp.getString(NICK, "344"));
            binding.contacty.setText(sp.getString(TM, "67"));
        }catch (Exception ignored){}
        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = requireActivity().getSharedPreferences("User_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString(NAME, binding.surname.getText().toString());
                ed.putString(NICK, binding.nickname.getText().toString());
                ed.putString(TM, binding.contacty.getText().toString());
                ed.apply();
                Toast.makeText(getContext(), "Успешно", Toast.LENGTH_SHORT).show();



            }
        });



    }



}
