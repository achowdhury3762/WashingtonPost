package com.example.ashiquechowdhury.scratchapp2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ashiquechowdhury.scratchapp2.model.Post;
import com.example.ashiquechowdhury.scratchapp2.model.PostPOJO;
import com.example.ashiquechowdhury.scratchapp2.model.WashingtonPostAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ashiquechowdhury on 12/8/16.
 */
public class WashingtonFragment extends Fragment {
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRecyclerView  = (RecyclerView) getActivity().findViewById(R.id.posts_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        callRetrofit();
        return inflater.inflate(R.layout.fragment_rview, container, false);
    }


    private void callRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.washingtonpost.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WashingtonPostAPI myApi = retrofit.create(WashingtonPostAPI.class);

        Call<PostPOJO> response = myApi.getAPIresponse();
        response.enqueue(new Callback<PostPOJO>() {
            @Override
            public void onResponse(Call<PostPOJO> call, Response<PostPOJO> response) {
                PostPOJO generalPOJO = response.body();
                List<Post> myPosts = generalPOJO.getPosts();
                Toast.makeText(getContext(), String.valueOf(myPosts.size()), Toast.LENGTH_LONG).show();
                mRecyclerView.setAdapter(new PostAdapter(myPosts));
            }

            @Override
            public void onFailure(Call<PostPOJO> call, Throwable t) {

            }
        });
    }
}
