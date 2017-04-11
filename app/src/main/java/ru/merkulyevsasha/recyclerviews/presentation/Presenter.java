package ru.merkulyevsasha.recyclerviews.presentation;

import ru.merkulyevsasha.myapplication.R;
import ru.merkulyevsasha.recyclerviews.domain.VideoInteractor;

/**
 * Created by sasha_merkulev on 11.04.2017.
 */

class Presenter {

    int selectedFragment;
    VideoInteractor inter;

    MainActivity view;

    private static volatile Presenter instance;

    private Presenter(VideoInteractor inter) {
        selectedFragment = R.id.navigation_tv;
        this.inter = inter;
    }

    static Presenter getInstance(VideoInteractor inter) {
        if (instance == null) {
            synchronized (Presenter.class) {
                if (instance == null) {
                    instance = new Presenter(inter);
                }
            }
        }
        return instance;
    }


    void onStart(MainActivity view) {
        this.view = view;

        switch (selectedFragment) {
            case R.id.navigation_personal:
                view.showPersonalFragment();
                break;

            case R.id.navigation_settings:
                view.showSettingsFragment();
                break;

            case R.id.navigation_subscriptions:
                view.showSubscriptionsFragment();
                break;

            case R.id.navigation_tv:
                view.showTvFragment();
                break;

            case R.id.navigation_video:
                view.showVideoFragment(inter.getVideos());
                break;
        }

    }

    void onStop() {
        view = null;
    }

    void onNavigationPersonal() {
        selectedFragment = R.id.navigation_personal;

        if (view == null)
            return;

        view.showPersonalFragment();
    }

    void onNavigationSettings() {
        selectedFragment = R.id.navigation_settings;

        if (view == null)
            return;

        view.showSettingsFragment();
    }

    void onNavigationSubscriptions() {
        selectedFragment = R.id.navigation_subscriptions;

        if (view == null)
            return;

        view.showSubscriptionsFragment();
    }

    void onNavigationTv() {
        selectedFragment = R.id.navigation_tv;

        if (view == null)
            return;

        view.showTvFragment();
    }

    void onNavigationVideo() {
        selectedFragment = R.id.navigation_video;

        if (view == null)
            return;

        view.showVideoFragment(inter.getVideos());
    }



}
