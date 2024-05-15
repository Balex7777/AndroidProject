package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {
    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        textView1 = findViewById(R.id.textView5);
        textView2 = findViewById(R.id.textView6);
        textView3 = findViewById(R.id.textView7);
        int articleId = getIntent().getIntExtra("article_id", -1);
        String articleTitle = getIntent().getStringExtra("title");
        String articleDescription = getIntent().getStringExtra("description");
        String articleText = getIntent().getStringExtra("text");

        textView1.setText(articleTitle);
        textView2.setText(articleDescription);
        textView3.setText(articleText);

        // Настраиваем кнопку "Назад"
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Завершаем текущую Activity и возвращаемся к предыдущей
            }
        });
    }
}