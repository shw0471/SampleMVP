package com.example.samplemvp;

import java.util.List;

public class MainContract {
    public interface View {
        void setRepoList(List<GithubRepo> githubRepoList);
    }

    public interface Presenter {
        void getRepoList(String ID);
    }
}
