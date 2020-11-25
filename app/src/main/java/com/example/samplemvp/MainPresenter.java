package com.example.samplemvp;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    GithubRepoModel githubRepoModel;

    public MainPresenter(final MainContract.View view) {
        githubRepoModel = new GithubRepoModel(new GithubRepoListener() {
            @Override
            public void loadRepo(List<GithubRepo> githubRepoList) {
                view.setRepoList(githubRepoList);
            }
        });
    }

    @Override
    public void getRepoList(String ID) {
        githubRepoModel.getGithubRepo(ID);
    }
}
