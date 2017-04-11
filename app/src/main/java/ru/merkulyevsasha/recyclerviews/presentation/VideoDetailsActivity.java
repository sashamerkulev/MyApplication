package ru.merkulyevsasha.recyclerviews.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import ru.merkulyevsasha.myapplication.R;
import ru.merkulyevsasha.recyclerviews.pojo.VideoItem;

public class VideoDetailsActivity extends AppCompatActivity {

    public static final String KEY_ITEM = "ITEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        VideoItem item = (VideoItem)intent.getSerializableExtra(KEY_ITEM);

        TextView title = (TextView)findViewById(R.id.textview_title);
        title.setText(item.getTitle());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
