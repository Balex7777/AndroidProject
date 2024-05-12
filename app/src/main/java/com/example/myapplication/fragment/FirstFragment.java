package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.GetChars;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_first, container, false);
        RecyclerView rv = root.findViewById(R.id.rv_test);
        rv.setLayoutManager(new LinearLayoutManager(
                getContext(),
                RecyclerView.VERTICAL,
                false
        ));

        ProductAdapter productAdapter = new ProductAdapter();
        productAdapter.Add(new Product("afsffgdfgds", 123331, "sadfsaf"));
        productAdapter.Add(new Product("affffgds", 123331, "sadfsaf"));
        productAdapter.Add(new Product("affffgds", 123331, "sadfsaf"));
        productAdapter.Add(new Product("affffgds", 123331, "sadfsaf"));
        productAdapter.Add(new Product("affffgds", 123331, "sadfsaf"));
        productAdapter.Add(new Product("affffgds", 123331, "sadfsaf"));
        rv.setAdapter(productAdapter);
        return root;
    }
}