package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "articles.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "my_articles";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "article_name";
    private static final String COLUMN_DESCRIPTION = "article_description";
    private static final String COLUMN_TEXT = "article_text";
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_TEXT + " TEXT);";
        db.execSQL(query);

        addArticle(db, "Заголовок 1", "Описание 1", "Текст статьи 1");
        addArticle(db, "Заголовок 2", "Описание 2", "Текст статьи 2");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void addArticle(SQLiteDatabase db,String title, String description, String content) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, title);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_TEXT, content);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Cursor getAllArticles() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
