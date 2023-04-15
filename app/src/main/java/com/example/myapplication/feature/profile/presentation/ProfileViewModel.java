package com.example.myapplication.feature.profile.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.repository.ProjectRepository;
import com.example.myapplication.data.repository.UserRepository;
import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.domain.model.User;
import com.example.myapplication.feature.dashboard.presentation.DashboardStatus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileViewModel extends ViewModel {
    private final MutableLiveData<ProfileStatus> _status = new MutableLiveData<>();
    public LiveData<ProfileStatus> status = _status;

    private final MutableLiveData<Projects> _user = new MutableLiveData<>();
    public LiveData<Projects> user = _user;

    public void load(long id) {
        _status.setValue(ProfileStatus.LOADING);
        ProjectRepository.getProject(id).enqueue(new Callback<Projects>() {
            @Override
            public void onResponse(Call<Projects> call, @NonNull Response<Projects> response) {
                _status.setValue(ProfileStatus.LOADED);
                _user.setValue(response.body());

            }

            @Override
            public void onFailure(Call<Projects> call, Throwable t) {
                _status.setValue(ProfileStatus.FALURE);
                t.printStackTrace();

            }
        });
    }

    public void delete(long id){
        _status.setValue(ProfileStatus.LOADING);
        ProjectRepository.deleteProject(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                _status.setValue(ProfileStatus.DELETE);

            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                _status.setValue(ProfileStatus.FALURE);

            }
        });

    }


}
