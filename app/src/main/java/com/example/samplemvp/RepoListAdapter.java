package com.example.samplemvp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.ViewHolder> {

    private List<GithubRepo> githubRepoList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_repo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_repoName.setText(githubRepoList.get(position).getName());
        holder.tv_repoCreatedDate.setText(githubRepoList.get(position).getCreated_at());
    }

    @Override
    public int getItemCount() {
        return githubRepoList.size();
    }

    public void setGithubRepoList(List<GithubRepo> githubRepoList){
        this.githubRepoList = githubRepoList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_repoName;
        TextView tv_repoCreatedDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_repoName = itemView.findViewById(R.id.tv_repoName);
            tv_repoCreatedDate = itemView.findViewById(R.id.tv_repoCreatedDate);
        }
    }
}
