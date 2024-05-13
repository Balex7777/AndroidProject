package com.example.myapplication.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.GetChars;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.database.MyDatabaseHelper;
import com.example.myapplication.model.Product;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private DatabaseReference myDataBase;
    private ArrayAdapter<String> adapter;
    ArrayList<String> articlesList;
    ProductAdapter productAdapter;

    public FirstFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

//    void getDataFromDB(){
//        ValueEventListener vEventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(articlesList.size() > 0) articlesList.clear();
//                for (DataSnapshot ds: snapshot.getChildren()){
//                    Product article = ds.getValue(Product.class);
//                    assert article != null;
//                    articlesList.add(article.name);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        };
//        myDataBase.addValueEventListener(vEventListener);
//    }

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
        articlesList = new ArrayList<>();

        adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, articlesList);
        myDataBase = FirebaseDatabase.getInstance().getReference("articles");
//        getDataFromDB();
        productAdapter = new ProductAdapter();
        productAdapter.Add(new Product("1", "fgh", "fgthyju", "defrgthyju"));
        productAdapter.Add(new Product("1", "fgh", "fgthyju", "defrgthyju"));
        productAdapter.Add(new Product("1", "fgh", "fgthyju", "defrgthyju"));
        productAdapter.Add(new Product("1", "fgh", "fgthyju", "defrgthyju"));
        productAdapter.Add(new Product("1", "fgh", "fgthyju", "defrgthyju"));
        productAdapter.Add(new Product("1", "fgh", "fgthyju", "defrgthyju"));
        productAdapter.Add(new Product("1", "fgh", "fgthyju", "defrgthyju"));
        rv.setAdapter(productAdapter);
        return root;
    }
}