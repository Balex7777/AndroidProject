package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ArticleActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentFirstBinding;
import com.example.myapplication.databinding.ProductItemBinding;
import com.example.myapplication.model.Product;

import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ProductAdapter extends ListAdapter<Product, ProductAdapter.ProductViewHolder> {
    private static final String DATABASE_NAME = "database/stations.db";
    private String url;
    private OnSwitchChangeListener switchChangeListener;

    public interface OnSwitchChangeListener {
        void onSwitchChanged(int position, boolean isChecked);
    }

    public void setSwitchChangeListener(OnSwitchChangeListener listener) {
        this.switchChangeListener = listener;
    }

    public ProductAdapter(@NonNull DiffUtil.ItemCallback<Product> diffCallback) {
        super(diffCallback);
    }


    public void setStations(List<Product> stations) {
        submitList(stations);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.product_item,
                parent,
                false
        );



        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bind(getItem(position));

    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ProductItemBinding addStationItemBinding;




        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            addStationItemBinding = ProductItemBinding.bind(itemView);
        }
        @SuppressLint("SetTextI18n")
        public void bind(Product station) {
            addStationItemBinding.name.setText(station.getName());
            addStationItemBinding.description.setText(station.getDescription());
            //addStationItemBinding.text.setText(station.getText());
            // Добавляем обработчик щелчка
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    Intent intent = new Intent(context, ArticleActivity.class);
                    intent.putExtra("article_id", station.getId_article()); // Передаем ID статьи
                    intent.putExtra("title", station.getName());
                    intent.putExtra("description", station.getDescription());
                    intent.putExtra("text", station.getText());
                    context.startActivity(intent);
                }
            });
        }
    }


    public static class StationDiff extends DiffUtil.ItemCallback<Product> {

        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return (oldItem.getId_article() == newItem.getId_article()
                    && Objects.equals(oldItem.getName(), newItem.getName()));
        }
    }


    public void updateStationsList(List<Product> stationsList) {
        submitList(stationsList);
    }


}
