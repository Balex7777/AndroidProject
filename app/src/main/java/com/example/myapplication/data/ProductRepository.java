package com.example.myapplication.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.myapplication.model.Product;

import java.util.List;

public class ProductRepository {
    private ProductDAO mStationDAO;
    private LiveData<List<Product>> mAllStations;
    private List<Product> allStations;
    private ProductDAO stationDAO;

    public ProductRepository(Application application) {
        ProductDatabase db = ProductDatabase.getDatabase(application);
        mStationDAO = db.stationDAO();
        mAllStations = mStationDAO.getAllStations();
    }

    public LiveData<List<Product>> getAllStationsList() {
        return mStationDAO.getAllStations();
    }


    public LiveData<List<Product>> getAllStations() {
        return mAllStations;
    }

    public void insert(Product station) {
        ProductDatabase.databaseWriteExecutor.execute(() -> {
            mStationDAO.insert(station);

        });
    }

    public void update(Product station) {
        ProductDatabase.databaseWriteExecutor.execute(() -> {
            mStationDAO.update(station);
        });
    }

    public void updateStations(List<Product> stations) {
        ProductDatabase.databaseWriteExecutor.execute(() -> {
            mStationDAO.updateStations(stations);
        });
    }

    public void updateStation(Product station) {
        ProductDatabase.databaseWriteExecutor.execute(() -> {
            mStationDAO.updateStation(station);
        });
    }

    public void deleteStation(Product station) {
        ProductDatabase.databaseWriteExecutor.execute(() -> {
            mStationDAO.deleteStation(station);
        });
    }
    public void deleteAll() {
        ProductDatabase.databaseWriteExecutor.execute(() -> {
            mStationDAO.deleteAll();
        });
    }
}
