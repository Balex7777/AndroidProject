package com.example.myapplication.database;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;


import com.example.myapplication.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public List<Product> getAllStationsList() {
        return allStations;
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

//    public LiveData<List<Product>> getFavouriteStations() {
//        ProductDatabase.databaseWriteExecutor.execute(() -> {
//            mStationDAO.getFavouriteStations();
//        });
//        return mStationDAO.getFavouriteStations();
//    }
//
//    public LiveData<List<Product>> getAlarmStations() {
//        ProductDatabase.databaseWriteExecutor.execute(() -> {
//            mStationDAO.getAlarmStations();
//        });
//        return mStationDAO.getAlarmStations();
//    }

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

//    public void deleteAndInsertAll(List<Product> stations, Context context) {
//        ProductDatabase.databaseWriteExecutor.execute(() -> {
//
//            Map<Integer> stationDataMap = new HashMap<>();
//
//            StationDatabase stationDatabase = StationDatabase.getDatabase(context);
//            stationDAO = stationDatabase.stationDAO();
//            stationDataMap.clear();
//
//            // Получим список всех станций из базы данных
//            List<Product> allStations = stationDAO.getAllStationsSync();
//
//
//            // Заполним словарь данными из станций
//            for (Station station : allStations) {
//                StationData data = new StationData(station.getIs_favourite(), station.getAlarm());
//                Log.d("LALALA", station.getName() + " " + station.getIs_favourite() + " " + station.getAlarm());
//                Log.d("LALALA-data", data.getIsFavourite() + " " + data.getAlarm());
//                Log.d("LALALA", " ");
//                stationDataMap.put(station.getId(), data);
//            }
//            Log.d("Server", stationDataMap.toString());
//
//
//            mStationDAO.deleteAll(); // Удалить все записи
//
//            for (Product station : stations) {
//                StationData data = stationDataMap.get(station.getId());
//                if (data != null) {
//                    Log.d("server", data.getIsFavourite() +" "+ data.toString());
//                    if(Objects.equals(data.getIsFavourite(), "false")){
//                        station.setFavourite(false);
//                    }else{
//                        station.setFavourite(true);
//                    }
//
//                    if(Objects.equals(data.getAlarm(), "false")){
//                        station.setAlarm(false);
//                    }else{
//                        station.setAlarm(true);
//                    }
//
//                    Log.d("SERVER", station.getName() +" " + station.getIs_favourite());
//
//
//
//                }
//            }
//
//
//            mStationDAO.insertAll(stations); // Вставить новые записи
//
//        });
//    }


}
