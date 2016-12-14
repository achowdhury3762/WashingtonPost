package com.example.ashiquechowdhury.scratchapp2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ashiquechowdhury.scratchapp2.model.Post;

import java.util.List;

/**
 * Created by ashiquechowdhury on 12/6/16.
 */

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    List<Post> myPosts;

    public PostAdapter(List<Post> myPosts) {
        this.myPosts = myPosts;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View childView = inflater.inflate(R.layout.post_row, parent, false);
        return new PostViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bind(myPosts.get(position));
    }

    @Override
    public int getItemCount() {
        return myPosts.size();
    }
}
