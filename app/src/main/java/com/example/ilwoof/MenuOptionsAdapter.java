package com.example.ilwoof;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuOptionsAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    List<MenuOption> Options;
    public MenuOptionsAdapter(List<MenuOption> options) {
        Options = options;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_option,parent,false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuOption option = Options.get(position);
        holder.avatar.setImageResource(option.getImage());
        holder.name.setText(option.getName());
        holder.description.setText(option.getDescription());
        holder.itemView.setOnClickListener(v -> {
            Context context = holder.itemView.getContext();
            context.startActivity(new Intent(context, option.getClazz()));
        });
    }

    @Override
    public int getItemCount() {
        return Options.size();
    }
}
