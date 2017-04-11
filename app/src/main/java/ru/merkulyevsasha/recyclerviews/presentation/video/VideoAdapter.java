package ru.merkulyevsasha.recyclerviews.presentation.video;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.merkulyevsasha.myapplication.R;
import ru.merkulyevsasha.recyclerviews.pojo.Video;
import ru.merkulyevsasha.recyclerviews.pojo.VideoItem;

/**
 * Created by sasha_merkulev on 11.04.2017.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private static final String TAG = VideoAdapter.class.getSimpleName();
    private Context mContext;
    private List<Video> mList;
    private VideoItemAdapter.OnItemClickListener mListener;

    public VideoAdapter(Context context, List<Video> list, VideoItemAdapter.OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mList = list;
        this.mListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.video_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Video item = mList.get(position);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        holder.recyclerView.setLayoutManager(layoutManager);
        VideoItemAdapter adapter = new VideoItemAdapter(mContext, item.getItems(), new VideoItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(VideoItem item) {
                mListener.onItemClick(item);
            }
        });
        holder.recyclerView.setAdapter(adapter);


        holder.title.setText(item.getVideoName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final RecyclerView recyclerView;


        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.textview_name);
            recyclerView = (RecyclerView)itemView.findViewById(R.id.recycler_horizontal);
        }
    }

}