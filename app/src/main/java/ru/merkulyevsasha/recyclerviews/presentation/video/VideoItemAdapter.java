package ru.merkulyevsasha.recyclerviews.presentation.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import ru.merkulyevsasha.myapplication.R;
import ru.merkulyevsasha.recyclerviews.pojo.VideoItem;

/**
 * Created by sasha_merkulev on 11.04.2017.
 */
public class VideoItemAdapter extends RecyclerView.Adapter<VideoItemAdapter.ViewHolder> {

    private static final String TAG = VideoItemAdapter.class.getSimpleName();
    private Context mContext;
    private List<VideoItem> mList;
    private OnItemClickListener mListener;

    public VideoItemAdapter(Context context, List<VideoItem> list, OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mList = list;
        this.mListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.video_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final VideoItem item = mList.get(position);

        holder.title.setText(item.getTitle());
        holder.year.setText(item.getYear());

        try {
            Random rand = new Random();
            int n = rand.nextInt(7)+1;
            if (n > 7){
                n = 1;
            }
//            Picasso.with(mContext).load(mContext.getResources().getIdentifier("poster"+n, "raw", mContext.getPackageName()))
//                    .into(holder.poster);

            Glide.with(mContext)
                    .load(mContext.getResources().getIdentifier("poster"+n, "raw", mContext.getPackageName()))
                    .fitCenter()
                    .into(holder.poster);

        } catch (Exception e) {
            e.printStackTrace();
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(VideoItem item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView year;
        private final ImageView poster;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.textview_title);
            year = (TextView)itemView.findViewById(R.id.textview_year);
            poster = (ImageView)itemView.findViewById(R.id.imageview_poster);

        }
    }
}