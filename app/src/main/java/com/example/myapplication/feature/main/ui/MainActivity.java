package com.example.myapplication.feature.main.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.data.api.projects.ProjectApiService;
import com.example.myapplication.data.api.users.UserApiService;
import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.domain.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ProjectApiService.getInstance().getProjects().enqueue(new Callback<List<Projects>>() {
            @Override
            public void onResponse(@NonNull Call<List<Projects>> call, @NonNull Response<List<Projects>> response) {
                Log.d("kffffffffff", response.body().toString());
            }

            @Override
            public void onFailure(@NonNull Call<List<Projects>> call, @NonNull Throwable t) {
                Log.d("kffffffffff", "kflhsdj;sb.lnjflsj;p;");
                t.printStackTrace();

            }
        });
    }
}