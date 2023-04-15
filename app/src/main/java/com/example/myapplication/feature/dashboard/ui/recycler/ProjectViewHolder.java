package com.example.myapplication.feature.dashboard.ui.recycler;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.databinding.ItemUserBinding;
import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.domain.model.User;
import com.squareup.picasso.Picasso;

public class ProjectViewHolder extends RecyclerView.ViewHolder {
    private final ItemUserBinding binding;
    private final ProjectClickListener listener;
    public ProjectViewHolder(ItemUserBinding binding, ProjectClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    void bind(Projects item){
        binding.name.setText(item.getName());
        binding.email.setText(item.getDescription());

        Glide.with(binding.getRoot()).load("https://vkusnaya-tochka-menu.ru/wp-content/cache/thumb/c3/9cb1c24c81d8ec3_320x200_notrise.jpg")
                .into(binding.imageObyavlenie1);
        Log.d("vdl;gkshpla;j", "lf;h;dgivjzhpdodhuviah");


    }
}
