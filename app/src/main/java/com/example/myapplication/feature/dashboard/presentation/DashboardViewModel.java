package com.example.myapplication.feature.dashboard.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.repository.UserRepository;
import com.example.myapplication.domain.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardViewModel extends ViewModel {
    private final MutableLiveData<DashboardStatus> _status = new MutableLiveData<>();
    public LiveData<DashboardStatus> status = _status;

    private final MutableLiveData<List<User>> _users = new MutableLiveData<>();
    public LiveData<List<User>> users = _users;

    public void load(){
        _status.setValue(DashboardStatus.LOADING);
        UserRepository.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                _status.setValue(DashboardStatus.LOADED);
                _users.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                _status.setValue(DashboardStatus.FALURE);
                t.printStackTrace();

            }
        });

    }

}
