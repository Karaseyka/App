package com.example.myapplication.feature.dashboard.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.repository.ProjectRepository;
import com.example.myapplication.data.repository.UserRepository;
import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.domain.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardViewModel extends ViewModel {
    private final MutableLiveData<DashboardStatus> _status = new MutableLiveData<>();
    public LiveData<DashboardStatus> status = _status;

    private final MutableLiveData<List<Projects>> _project = new MutableLiveData<>();
    public LiveData<List<Projects>> project = _project;

    public void load(){
        _status.setValue(DashboardStatus.LOADING);
        ProjectRepository.getProjects().enqueue(new Callback<List<Projects>>() {
            @Override
            public void onResponse(Call<List<Projects>> call, Response<List<Projects>> response) {
                _status.setValue(DashboardStatus.LOADED);
                _project.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Projects>> call, Throwable t) {
                _status.setValue(DashboardStatus.FALURE);
                t.printStackTrace();

            }
        });

    }

}
