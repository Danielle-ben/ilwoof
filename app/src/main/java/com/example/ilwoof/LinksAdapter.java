package com.example.ilwoof;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LinksAdapter extends RecyclerView.Adapter<LinkViewHolder> {
    List<Link> Links;
    public LinksAdapter(List<Link> links) {
        Links = links;
    }

    @NonNull
    @Override
    public LinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_option,parent,false);
        return new LinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LinkViewHolder holder, int position) {
        Link link = Links.get(position);
        holder.avatar.setImageResource(link.getImage());
        holder.name.setText(link.getName());
        holder.description.setText(link.getDescription());
        holder.itemView.setOnClickListener(v -> {
            Context context = holder.itemView.getContext();
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link.getUrl())));
        });
    }

    @Override
    public int getItemCount() {
        return Links.size();
    }
}
