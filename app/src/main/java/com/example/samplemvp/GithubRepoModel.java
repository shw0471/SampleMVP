package com.example.samplemvp;

import androidx.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubRepoModel {

    GithubRepoListener callback;
    GithubService githubService;

    public GithubRepoModel(GithubRepoListener callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        githubService = retrofit.create(GithubService.class);
        this.callback = callback;
    }

    public void getGithubRepo(String ID){
        Call<List<GithubRepo>> call = githubService.getGithubRepo(ID);
        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(@NonNull Call<List<GithubRepo>> call, @NonNull Response<List<GithubRepo>> response) {
                if(response.isSuccessful()){
                    List<GithubRepo> githubRepoList = response.body();

                    assert githubRepoList != null;
                    if(!githubRepoList.isEmpty()) callback.loadRepo(githubRepoList);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<GithubRepo>> call, @NonNull Throwable t) {

            }
        });
    }
}
