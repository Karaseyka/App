package com.example.myapplication.data.api.projects;

import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.domain.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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
    @FormUrlEncoded
    Call<Projects> insertUser(
            @Field("name") String name,
            @Field("description") String username,
            @Field("user_nick") String password,
            @Field("foto_id") String email);


    @DELETE("project/{id}")
    Call<Void> deleteProject(
            @Path("id")
            long id

    );



}
