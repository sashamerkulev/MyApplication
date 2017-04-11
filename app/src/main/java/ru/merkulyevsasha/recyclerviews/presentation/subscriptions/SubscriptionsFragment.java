package ru.merkulyevsasha.recyclerviews.presentation.subscriptions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.merkulyevsasha.myapplication.R;

/**
 * Created by sasha_merkulev on 11.04.2017.
 */

public class SubscriptionsFragment extends Fragment {

    public static SubscriptionsFragment getInstance(){
        SubscriptionsFragment fragment = new SubscriptionsFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_subscriptions, container, false);

        return view;

    }
}
