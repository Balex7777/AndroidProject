package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.fragment.FirstFragment;
import com.example.myapplication.fragment.SecondFragment;
import com.example.myapplication.fragment.ScrollingCalendarFragment;
import com.example.myapplication.fragment.ProfileFragment;
import com.example.myapplication.model.Product;
import com.example.myapplication.view_adapter.ExampleViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tl);
        ViewPager viewPager = findViewById(R.id.vp);

        ExampleViewPagerAdapter exampleViewPagerAdapter = new ExampleViewPagerAdapter(
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        );
        exampleViewPagerAdapter.Add(new FirstFragment(), "Главная");
        exampleViewPagerAdapter.Add(new SecondFragment(), "Медитация");
        exampleViewPagerAdapter.Add(new ScrollingCalendarFragment(), "Календарь");
        exampleViewPagerAdapter.Add(new ProfileFragment(), "Профиль");

        viewPager.setAdapter(exampleViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}