package com.example.myapplication.feature.dashboard.ui.recycler;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.example.myapplication.databinding.ItemUserBinding;
import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.domain.model.User;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

public class ProjectViewHolder extends RecyclerView.ViewHolder {
    private final ItemUserBinding binding;
    private final ProjectClickListener listener;
    public ProjectViewHolder(ItemUserBinding binding, ProjectClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    void bind(Projects item){
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();

        binding.name.setText(item.getName());
        binding.email.setText(item.getDescription());
        binding.getRoot().setOnClickListener(v -> listener.onClick(item.getId()));
        storageReference.child(item.getFoto_id() + ".jpeg");
        binding.nameOfAutor.setText(item.getUser_nick());

        Glide.with(binding.getRoot()).load("https://firebasestorage.googleapis.com/v0/b/myapplication5-50c5d.appspot.com/o/images%2F"+item.getFoto_id()+"?alt=media&token=a05a10b5-5f6c-4a79-a075-d13932945427")
                .into(binding.imageObyavlenie1);
        Log.d("vdl;gkshpla;j", "lf;h;dgivjzhpdodhuviah");


    }

}

