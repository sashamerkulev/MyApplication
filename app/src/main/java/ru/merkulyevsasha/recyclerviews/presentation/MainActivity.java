package ru.merkulyevsasha.recyclerviews.presentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import ru.merkulyevsasha.myapplication.R;
import ru.merkulyevsasha.recyclerviews.domain.VideoInteractor;
import ru.merkulyevsasha.recyclerviews.pojo.Obj;
import ru.merkulyevsasha.recyclerviews.pojo.VideoItem;
import ru.merkulyevsasha.recyclerviews.presentation.personal.PersonalFragment;
import ru.merkulyevsasha.recyclerviews.presentation.settings.SettingsFragment;
import ru.merkulyevsasha.recyclerviews.presentation.subscriptions.SubscriptionsFragment;
import ru.merkulyevsasha.recyclerviews.presentation.tv.TvFragment;
import ru.merkulyevsasha.recyclerviews.presentation.video.VideoFragment;
import ru.merkulyevsasha.recyclerviews.presentation.video.VideoItemAdapter;

public class MainActivity extends AppCompatActivity
            implements VideoItemAdapter.OnItemClickListener {

    private View container;
    private TextView mTitle;
    private Presenter pres;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_personal:
                    pres.onNavigationPersonal();
                    return true;

                case R.id.navigation_settings:
                    pres.onNavigationSettings();
                    return true;

                case R.id.navigation_subscriptions:
                    pres.onNavigationSubscriptions();
                    return true;

                case R.id.navigation_tv:
                    pres.onNavigationTv();
                    return true;

                case R.id.navigation_video:
                    pres.onNavigationVideo();
                    return true;
            }

            return false;
        }

    };

    private void showSelectedFragmnet(Fragment fragment, int title){
        mTitle.setText(title);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = (TextView) findViewById(R.id.textview_title);
        container = findViewById(R.id.container);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        pres = Presenter.getInstance(new VideoInteractor());

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        pres.onStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        pres.onStop();
    }

    public void showMessage(String message){
        Snackbar.make(container, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(VideoItem item) {
        showMessage(item.getTitle());
    }

    public void showPersonalFragment(){
        showSelectedFragmnet(PersonalFragment.getInstance(), R.string.title_personal);
    }

    public void showSettingsFragment(){
        showSelectedFragmnet(SettingsFragment.getInstance(), R.string.title_settings);
    }

    public void showSubscriptionsFragment(){
        showSelectedFragmnet(SubscriptionsFragment.getInstance(), R.string.title_subscriptions);
    }

    public void showTvFragment(){
        showSelectedFragmnet(TvFragment.getInstance(), R.string.title_tv);
    }

    public void showVideoFragment(Obj obj){
        showSelectedFragmnet(VideoFragment.getInstance(obj), R.string.title_video);
    }


}
