package com.example.myapplication.feature.main.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;
import com.example.myapplication.data.api.projects.ProjectApiService;
import com.example.myapplication.data.api.users.UserApiService;
import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.domain.model.User;
import com.example.myapplication.feature.dashboard.ui.DashboardFragment;
import com.example.myapplication.feature.liked.LikedFragment;
import com.example.myapplication.feature.profile.Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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
        BottomNavigationView bottomNavigationView = findViewById(R.id.getter_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.getterAdvrsF:
                        replace(new DashboardFragment());
                        break;
                    case R.id.getterNotifyF:
                        replace(new LikedFragment());
                        break;
                    case R.id.marketsMapF:
                        replace(new Profile());
                        break;
                }
                return true;
            }
        });

    }
    public void replace(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.nav_host_getter_fragment, fragment);
        ft.commit();

    }
}