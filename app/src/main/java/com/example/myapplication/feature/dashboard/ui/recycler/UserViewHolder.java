package com.example.myapplication.feature.dashboard.ui.recycler;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.databinding.ItemUserBinding;
import com.example.myapplication.domain.model.User;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private final ItemUserBinding binding;
    private final UserClickListener listener;
    public UserViewHolder(ItemUserBinding binding, UserClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    void bind(User item){
        Glide.with(binding.getRoot()).load(item.getPhotoURL()).into(binding.image);
        binding.name.setText(item.getName());
        binding.email.setText(item.getEmail());
        binding.getRoot().setOnClickListener(v -> listener.onClick(item.getId()));

    }
}
