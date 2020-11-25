package com.example.samplemvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private EditText et_search;
    private RecyclerView rv_repoList;

    private RepoListAdapter adapter = new RepoListAdapter();
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        et_search = findViewById(R.id.et_search);
        rv_repoList = findViewById(R.id.rv_repoList);
        Button btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search = et_search.getText().toString();

                if(search.length() > 0){
                    presenter.getRepoList(search);
                }
            }
        });

        rv_repoList.setAdapter(adapter);
    }

    @Override
    public void setRepoList(List<GithubRepo> githubRepoList) {
        adapter.setGithubRepoList(githubRepoList);
    }
}