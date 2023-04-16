package com.example.myapplication.data.api.projects;

import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.domain.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProjectApi {
    @GET("project")
    Call<List<Projects>> getProjects();

    @GET("project/{id}")
    Call<Projects> getProject(
        @Path("id")
        long id

    );
    @POST("project")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Call<Projects> insertUser(@Body Map<String, String> fields);


    @DELETE("project/{id}")
    Call<Void> deleteProject(
            @Path("id")
            long id

    );



}
