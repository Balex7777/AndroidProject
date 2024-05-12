package com.example.myapplication.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.myapplication.R;

public class SecondFragment extends Fragment {

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_second, container, false);
        ProgressBar ProgressBar = root.findViewById(R.id.progressBar);
        Button btn = root.findViewById(R.id.button);
        //ProgressBar.incrementProgressBy(100);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animation = ObjectAnimator.ofInt(ProgressBar, "progress", ProgressBar.getProgress(), 100);
                animation.setDuration(3000);
                animation.setAutoCancel(true);
                animation.setInterpolator( new LinearInterpolator());
                animation.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator animation2 = ObjectAnimator.ofInt(ProgressBar, "progress", ProgressBar.getProgress(), 0);
                        animation2.setDuration(3000);
                        animation2.setAutoCancel(true);
                        animation2.setInterpolator( new LinearInterpolator());
                        animation2.start();
                    }
                }, 7000);
            }
        });
        return root;
    }
}