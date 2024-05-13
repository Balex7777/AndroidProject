package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ProductItemBinding;
import com.example.myapplication.model.Product;

import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private List<Product> products = new ArrayList<>();
    private ProductItemBinding productItemBinding;


    public ProductAdapter(){}

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
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        holder.bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ProductItemBinding productItemBinding;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productItemBinding = ProductItemBinding.bind(itemView);
        }
        public void bind(Product product){
            productItemBinding.name.setText(product.getName());
            productItemBinding.text.setText(String.valueOf(product.getText()));
            productItemBinding.description.setText(product.getDescription());
        }
    }

    public void Add(Product product){
        products.add(product);
        notifyDataSetChanged();
    }
}
