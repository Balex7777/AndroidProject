package com.example.myapplication.fragment;

import android.animation.Animator;
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
import android.widget.TextView;

import com.example.myapplication.R;



public class SecondFragment extends Fragment {

    private TextView textView;
    private ProgressBar progressBar;
    private Button button;
    private ObjectAnimator inhaleAnimation;
    private ObjectAnimator exhaleAnimation;
    private boolean isBreathing = false;
    private Thread breathingThread;

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
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        textView = view.findViewById(R.id.textView3);
        progressBar = view.findViewById(R.id.progressBar);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isBreathing) {
                    startBreathing();
                } else {
                    stopBreathing();
                }
            }
        });
        return view;
    }

    private void startBreathing() {
        button.setText("СТОП");
        isBreathing = true;

        breathingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    inhaleAnimation = ObjectAnimator.ofInt(progressBar, "progress", 0, 100);
                    inhaleAnimation.setDuration(5000);
                    inhaleAnimation.setInterpolator(new LinearInterpolator());

                    exhaleAnimation = ObjectAnimator.ofInt(progressBar, "progress", 100, 0);
                    exhaleAnimation.setDuration(5000);
                    exhaleAnimation.setInterpolator(new LinearInterpolator());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            inhaleAnimation.start();
                            textView.setText("Вдох");
                        }
                    });
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("Задержите дыхание");
                        }
                    });
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("Выдох");
                            exhaleAnimation.start();
                        }
                    });
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("Задержите дыхание");
                        }
                    });
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        });
        breathingThread.start();
    }

    private void stopBreathing() {
        button.setText("НАЧАТЬ");
        isBreathing = false;
        breathingThread.interrupt();
        progressBar.setProgress(0);
        textView.setText("");
        if (inhaleAnimation != null) {
            inhaleAnimation.cancel();
        }
        if (exhaleAnimation != null) {
            exhaleAnimation.cancel();
        }
    }
}