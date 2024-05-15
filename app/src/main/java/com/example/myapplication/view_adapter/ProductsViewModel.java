package com.example.myapplication.view_adapter;



import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.data.ProductRepository;
import com.example.myapplication.model.Product;

import java.util.List;

public class ProductsViewModel extends AndroidViewModel {

    private ProductRepository mRepository;

    private final LiveData<List<Product>> mAllStation;

    public ProductsViewModel(Application application) {
        super(application);
        mRepository = new ProductRepository(application);
        mAllStation = mRepository.getAllStations();
    }

    public LiveData<List<Product>> getAllWords() {
        return mAllStation;
    }

    public void insert(Product station) {
        mRepository.insert(station);
    }
    public void update(Product station) {
        mRepository.update(station);
    }

    public LiveData<List<Product>> getAllArticles(){ return mRepository.getAllStationsList();}

    public void updateStations(List<Product> stations) { mRepository.updateStations(stations); }

}

