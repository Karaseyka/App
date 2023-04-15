package com.example.myapplication.feature.dashboard.ui.recycler;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.myapplication.databinding.ItemUserBinding;
import com.example.myapplication.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends Adapter<UserViewHolder> {
    private List<User> items = new ArrayList<>();
    private final UserClickListener listener;

    public UserAdapter(UserClickListener listener){
        this.listener = listener;

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UserViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<User> items){
        int count = getItemCount();
        this.items = new ArrayList<>(items);
        notifyItemRangeChanged(0, Math.max(count, getItemCount()));

    }
}
