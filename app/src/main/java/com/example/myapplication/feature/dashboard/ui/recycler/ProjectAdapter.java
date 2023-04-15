package com.example.myapplication.feature.dashboard.ui.recycler;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.myapplication.databinding.ItemUserBinding;
import com.example.myapplication.domain.model.Projects;
import com.example.myapplication.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public class ProjectAdapter extends Adapter<ProjectViewHolder> {
    private List<Projects> items = new ArrayList<>();
    private final ProjectClickListener listener;

    public ProjectAdapter(ProjectClickListener listener){
        this.listener = listener;

    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProjectViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Projects> items){
        int count = getItemCount();
        this.items = new ArrayList<>(items);
        notifyItemRangeChanged(0, Math.max(count, getItemCount()));

    }
}
