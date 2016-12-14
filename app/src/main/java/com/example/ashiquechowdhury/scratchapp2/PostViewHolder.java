package com.example.ashiquechowdhury.scratchapp2;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ashiquechowdhury.scratchapp2.model.Post;

/**
 * Created by ashiquechowdhury on 12/6/16.
 */

public class PostViewHolder extends RecyclerView.ViewHolder{
    TextView id;
    TextView title;
    TextView excerpt;
    TextView date;

    public PostViewHolder(View itemView) {
        super(itemView);

        id = (TextView) itemView.findViewById(R.id.post_id_view);
        title = (TextView) itemView.findViewById(R.id.post_title_view);
        excerpt = (TextView) itemView.findViewById(R.id.post_excerpt_view);
        date = (TextView) itemView.findViewById(R.id.post_date_view);
    }

    public void bind(final Post post) {
        id.setText(String.valueOf(post.getId()));
        title.setText(post.getTitle());
        excerpt.setText(post.getExcerpt());
        date.setText(post.getDate());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PostActivity.class);
                intent.putExtra("ID", String.valueOf(post.getId()));
                intent.putExtra("TITLE", post.getTitle());
                intent.putExtra("CONTENT", post.getContent());
                intent.putExtra("DATE", post.getDate());

                view.getContext().startActivity(intent);
            }
        });
    }
}
