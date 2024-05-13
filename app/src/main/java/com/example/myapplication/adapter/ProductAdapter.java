package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

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

        private Switch switchAlarm;



        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            addStationItemBinding = ProductItemBinding.bind(itemView);
        }
        @SuppressLint("SetTextI18n")
        public void bind(Product station) {
            addStationItemBinding.name.setText(station.getName());  // добавление названия станции

//            addStationItemBinding.iconStationAdd.setImageResource(IconManager.getIconResource(station.getNumLine()));  // добавление иконки линии

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

    public void filterById(String text, List<Product> stations) {
        List<Product> filteredList = new ArrayList<>();
        if (text.isEmpty()) {
            filteredList.addAll(stations);
        } else {
            String searchText = text.toLowerCase().trim();
            for (Product station : stations) {
                if (station.getName().toLowerCase().contains(searchText) && station.getName().toLowerCase().charAt(0)==searchText.toLowerCase().charAt(0)) {


                    filteredList.add(station);

                }
            }
        }
        submitList(filteredList);
    }



    public void updateStationsList(List<Product> stationsList) {
        submitList(stationsList);
    }


}
