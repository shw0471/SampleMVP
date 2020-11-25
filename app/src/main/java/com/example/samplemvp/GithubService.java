package com.example.samplemvp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    @GET("/users/{user}/repos")
    Call<List<GithubRepo>> getGithubRepo(@Path("user") String userID);
}
