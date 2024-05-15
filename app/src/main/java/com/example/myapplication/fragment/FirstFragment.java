package com.example.myapplication.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.GetChars;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.ProductAdapter;

import com.example.myapplication.databinding.FragmentFirstBinding;
import com.example.myapplication.fragment.viewmodel.FirstFragmentViewModel;
import com.example.myapplication.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FirstFragment extends Fragment {
    public FragmentFirstBinding binding;
    private FirstFragmentViewModel mStationViewModel;
    private List<Product> fullStationList;

    public FirstFragmentViewModel getStationViewModel() {
        return mStationViewModel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        mStationViewModel = new ViewModelProvider(this).get(FirstFragmentViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);


        RecyclerView rv_add_station = view.findViewById(R.id.rv_test);
        rv_add_station.setLayoutManager(new LinearLayoutManager(
                getContext(),
                RecyclerView.VERTICAL,
                false
        ));


        ProductAdapter allStationAdapter = new ProductAdapter(new ProductAdapter.StationDiff());
        //FirstFragmentViewModel firstFragmentViewModel = getStationViewModel();
        //firstFragmentViewModel.insert(new Product(1, "Заголовок 1", "Описание 1", "превью", "Текст 1"));

        mStationViewModel.getAllWords().observe(getViewLifecycleOwner(), stationsList -> {
            allStationAdapter.submitList(stationsList);
            fullStationList = stationsList;

        });


        //----------------------------------------------

        rv_add_station.setAdapter(allStationAdapter);


        return view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}