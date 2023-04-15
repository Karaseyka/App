package com.example.myapplication.feature.project.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.repository.ProjectRepository;
import com.example.myapplication.domain.model.Projects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectViewModel extends ViewModel {
    private final MutableLiveData<ProjectStatus> _status = new MutableLiveData<>();
    public LiveData<ProjectStatus> status = _status;

    private final MutableLiveData<Projects> _user = new MutableLiveData<>();
    public LiveData<Projects> user = _user;

    public void load(long id) {
        _status.setValue(ProjectStatus.LOADING);
        ProjectRepository.getProject(id).enqueue(new Callback<Projects>() {
            @Override
            public void onResponse(Call<Projects> call, @NonNull Response<Projects> response) {
                _status.setValue(ProjectStatus.LOADED);
                _user.setValue(response.body());

            }

            @Override
            public void onFailure(Call<Projects> call, Throwable t) {
                _status.setValue(ProjectStatus.FALURE);
                t.printStackTrace();

            }
        });
    }

    public void delete(long id){
        _status.setValue(ProjectStatus.LOADING);
        ProjectRepository.deleteProject(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                _status.setValue(ProjectStatus.DELETE);

            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                _status.setValue(ProjectStatus.FALURE);

            }
        });

    }


}
