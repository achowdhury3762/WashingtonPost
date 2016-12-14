package com.example.ashiquechowdhury.scratchapp2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ashiquechowdhury on 12/6/16.
 */

public class PostFragment extends Fragment {
    TextView idView;
    TextView titleView;
    TextView contentView;
    TextView dateView;

    String myId;
    String title;
    String date;
    String content;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        Bundle args = getArguments();
        myId = args.getString("ID");
        title = args.getString("TITLE");
        date = args.getString("DATE");
        content = args.getString("CONTENT");

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        idView = (TextView) getActivity().findViewById(R.id.frag_id_view);
        titleView = (TextView) getActivity().findViewById(R.id.frag_title_view);
        contentView = (TextView) getActivity().findViewById(R.id.frag_content_view);
        dateView = (TextView) getActivity().findViewById(R.id.frag_date_view);

        idView.setText(myId);
        titleView.setText(title);
        dateView.setText(date);
        contentView.setText(content);

    }
}
