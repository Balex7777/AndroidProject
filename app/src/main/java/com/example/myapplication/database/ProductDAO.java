package com.example.myapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.example.myapplication.model.Product;

import java.util.List;
@Dao
public interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Product product);

    @Query("SELECT * FROM articles")
    LiveData<List<Product>> getAllStations();

//    @Query("UPDATE articles SET alarm = :alarm, is_favourite= :alarm WHERE id_station = :id")
//    void updateAlarm(int id, String alarm);

//    @Query("SELECT * FROM articles WHERE is_favourite = 'true'")
//    LiveData<List<Product>> getFavouriteStations();
//
//    @Query("SELECT * FROM articles WHERE alarm = 'true' AND is_favourite = 'true'")
//    LiveData<List<Product>> getAlarmStations();

    @Update
    void update(Product product);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Product> stations);

    @Query("DELETE FROM articles")
    void deleteAll();

    @Update
    public void updateStations(List<Product> stations); // Метод для обновления списка станций

    @Update
    void updateStation(Product station);

    @Delete
    void deleteStation(Product station);

    @Query("SELECT * FROM articles")
    List<Product> getAllStationsSync();
}