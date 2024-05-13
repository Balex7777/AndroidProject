package com.example.myapplication.data;

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
    void insert(Product station);

    @Query("SELECT * FROM articles")
    LiveData<List<Product>> getAllStations();

    @Update
    void update(Product station);

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