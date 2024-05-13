package com.example.myapplication.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.GetChars;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.database.MyDatabaseHelper;
import com.example.myapplication.database.ProductRepository;
import com.example.myapplication.databinding.FragmentFirstBinding;
import com.example.myapplication.model.Product;
import com.example.myapplication.view_adapter.ProductsViewModel;
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
    private FragmentFirstBinding binding;
    private ProductsViewModel mStationViewModel;

    List<Product> productList;
    ProductRepository productRepository;


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentFirstBinding.inflate(getLayoutInflater());
        mStationViewModel = new ViewModelProvider(this).get(ProductsViewModel.class);


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

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, articlesList);
        myDataBase = FirebaseDatabase.getInstance().getReference("articles");
//        getDataFromDB();
        productAdapter = new ProductAdapter();
        productAdapter.Add(new Product(1, "fgh", "fgthyju", "defrgthyju"));
        productAdapter.Add(new Product(1, "fgh", "fgthyju", "defrgthyju"));
        productAdapter.Add(new Product(1, "fgh", "fgthyju", "defrgthyju"));
        productAdapter.Add(new Product(1, "fgh", "fgthyju", "defrgthyju"));
        productAdapter.Add(new Product(1, "ABOBA", "fgthyju", "defrgthyju"));

        rv.setAdapter(productAdapter);
        return root;
    }
}


//    @Override
//    public View onCreateView(LayoutInflater inflater,
//                             ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.fragment_first, container, false);
//        Button back_to_stations = (Button) view.findViewById(R.id.back_to_stations);
//        Button done = (Button) view.findViewById(R.id.done);
//
//        RecyclerView rv_add_station = view.findViewById(R.id.rv_add_stantion);
//        rv_add_station.setLayoutManager(new LinearLayoutManager(
//                getContext(),
//                RecyclerView.VERTICAL,
//                false
//        ));
//
//
//        AllStationAdapter allStationAdapter = new AllStationAdapter(new AllStationAdapter.StationDiff());
//        mStationViewModel.getAllWords().observe(getViewLifecycleOwner(), stationsList -> {
//            allStationAdapter.submitList(stationsList);
//            fullStationList = stationsList; // Сохраняем полный список станций
//            for (int i = 0; i < stationsList.size(); i++) {
//                if (i < stationsList.size()) {
//                    Station station = stationsList.get(i);
//                    boolean favourState = station.getBoolFavourite();
//                    allStationAdapter.setSwitchState(favourState, i);
//                }
//            }
//        });
//
//        allStationAdapter.setSwitchChangeListener(new AllStationAdapter.OnSwitchChangeListener() {
//            @Override
//            public void onSwitchChanged(int position, boolean isChecked) {
//                // Обновите значение в базе данных при изменении переключателя
//                Station station = allStationAdapter.getCurrentList().get(position);
//                station.setFavourite(isChecked);
//
//            }
//        });
//        //----------------------------------------------
//
//        rv_add_station.setAdapter(allStationAdapter);
//
//
//        back_to_stations.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FavouriteStationsListFragment favouriteStationsListFragment = new FavouriteStationsListFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                transaction.replace(R.id.container, favouriteStationsListFragment);
//                requireActivity().getSupportFragmentManager().popBackStack();
//
////                mStationViewModel.update(station);
//                List<Station> stationsToUpdate = allStationAdapter.getCurrentList(); // Получить список станций для обновления
//                mStationViewModel.updateStations(stationsToUpdate);
//
////                Toast.makeText(getContext(), "Вы не сохранили изменения", Toast.LENGTH_SHORT).show();
//
//                transaction.commit();
//            }
//        });
//
//        done.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Просто для теста. Добавится один раз, так как описана проверка по содержимому и политика игнорирования одинаковых
////                mStationViewModel.insert(new Station(13,"test","1", "0.0","0.0"));
//
//
//                MainMenuFragment mainMenuFragment = new MainMenuFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                transaction.replace(R.id.container, mainMenuFragment);
//
//                requireActivity().getSupportFragmentManager().popBackStack();
//
//            }