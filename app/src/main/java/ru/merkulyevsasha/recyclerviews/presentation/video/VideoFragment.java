package ru.merkulyevsasha.recyclerviews.presentation.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import ru.merkulyevsasha.myapplication.R;
import ru.merkulyevsasha.recyclerviews.pojo.Obj;
import ru.merkulyevsasha.recyclerviews.pojo.VideoItem;

/**
 * Created by sasha_merkulev on 11.04.2017.
 */

public class VideoFragment extends Fragment {

    private static final String KEY_VIDEO = "KEY_VIDEO";

    private VideoAdapter adapter;

    public static VideoFragment getInstance(Obj obj){
        VideoFragment fragment = new VideoFragment();

        Bundle args = new Bundle();
        args.putSerializable(KEY_VIDEO, obj);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video, container, false);

        Bundle args = getArguments();
        Obj obj = (Obj)args.getSerializable(KEY_VIDEO);

        RecyclerView video = (RecyclerView)view.findViewById(R.id.recycler_vertical);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        video.setLayoutManager(layoutManager);
        adapter = new VideoAdapter(getActivity(), obj.getVideos(), new VideoItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(VideoItem item) {
                if (getActivity() instanceof VideoItemAdapter.OnItemClickListener){
                    ((VideoItemAdapter.OnItemClickListener)getActivity()).onItemClick(item);
                }
            }
        });
        video.setAdapter(adapter);

        return view;

    }
}
