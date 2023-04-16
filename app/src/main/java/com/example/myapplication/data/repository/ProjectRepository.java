package com.example.myapplication.data.repository;

import com.example.myapplication.data.api.projects.ProjectApiService;
import com.example.myapplication.data.api.users.UserApiService;
import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.domain.model.User;

import java.util.List;

import retrofit2.Call;

public class ProjectRepository {

    public static Call<Projects> addProject(String name, String description, String user_nick, String foto_id){
        return ProjectApiService.getInstance().insertUser(name, description, user_nick, foto_id);

    }
    public static Call<List<Projects>> getProjects(){
        return ProjectApiService.getInstance().getProjects();

    }
    public static Call<Projects> getProject(long id){
        return ProjectApiService.getInstance().getProject(id);

    }
    public static Call<Void> deleteProject(long id){
        return ProjectApiService.getInstance().deleteProject(id);

    }
}
