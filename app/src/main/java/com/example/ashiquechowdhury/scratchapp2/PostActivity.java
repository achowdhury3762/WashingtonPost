package com.example.ashiquechowdhury.scratchapp2;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ashiquechowdhury on 12/6/16.
 */

public class PostActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Intent intent = getIntent();
        String id = intent.getStringExtra("ID");
        String title = intent.getStringExtra("TITLE");
        String content = intent.getStringExtra("CONTENT");
        String date = intent.getStringExtra("DATE");

        Bundle args = new Bundle();
        args.putString("ID", id);
        args.putString("TITLE", title);
        args.putString("CONTENT", content);
        args.putString("DATE", date);

        Fragment postFrag = new PostFragment();
        postFrag.setArguments(args);
        getFragmentManager().beginTransaction().add(R.id.container_view, postFrag).commit();
    }
}
