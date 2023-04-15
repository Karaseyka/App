package com.example.myapplication.data.api.projects;

import com.example.myapplication.data.api.RetrofitService;
import com.example.myapplication.data.api.users.UserApi;

public class ProjectApiService {


    private static ProjectApi projectApi;

    private static ProjectApi create() {
        return RetrofitService.getInstance().create(ProjectApi.class);
    }

    public static ProjectApi getInstance() {
        if (projectApi == null) projectApi = create();

        return projectApi;

    }
}
