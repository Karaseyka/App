package com.example.myapplication.data.api.users;

import com.example.myapplication.data.api.RetrofitService;
import com.example.myapplication.data.api.users.UserApi;

public class UserApiService {


    private static UserApi userApi;

    private static UserApi create() {
        return RetrofitService.getInstance().create(UserApi.class);
    }

    public static UserApi getInstance() {
        if (userApi == null) userApi = create();

        return userApi;

    }
}
