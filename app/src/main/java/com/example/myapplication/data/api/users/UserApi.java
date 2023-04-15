package com.example.myapplication.data.api.users;

import com.example.myapplication.domain.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {
    @GET("/user")
    Call<List<User>> getUsers();

    @GET("user/{id}")
    Call<User> getUser(
        @Path("id")
        long id

    );
    @DELETE("user/{id}")
    Call<Void> deleteUser(
            @Path("id")
            long id

    );



}
