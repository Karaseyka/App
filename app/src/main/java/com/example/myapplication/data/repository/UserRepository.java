package com.example.myapplication.data.repository;

import com.example.myapplication.data.api.users.UserApiService;
import com.example.myapplication.domain.model.User;

import java.util.List;

import retrofit2.Call;

public class UserRepository {

    public static Call<List<User>> getUsers(){
        return UserApiService.getInstance().getUsers();

    }
    public static Call<User> getUser(long id){
        return UserApiService.getInstance().getUser(id);

    }
    public static Call<Void> deleteUser(long id){
        return UserApiService.getInstance().deleteUser(id);

    }
}
