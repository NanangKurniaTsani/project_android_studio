package com.aplikasipengelolaankecamatantegalselatan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DokumentasiAdapter extends RecyclerView.Adapter<DokumentasiAdapter.DokumentasiViewHolder> {

    private List<MainActivity.DokumentasiItem> dokumentasiList;

    public DokumentasiAdapter(List<MainActivity.DokumentasiItem> dokumentasiList) {
        this.dokumentasiList = dokumentasiList;
    }

    @NonNull
    @Override
    public DokumentasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dokumentasi, parent, false);
        return new DokumentasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DokumentasiViewHolder holder, int position) {
        MainActivity.DokumentasiItem item = dokumentasiList.get(position);
        holder.tvDokumentasiTitle.setText(item.getTitle());
        holder.tvDokumentasiDescription.setText(item.getDescription());
        
        // If there's an image URL, load it (would use a library like Glide or Picasso in a real app)
        // For now, we'll use the placeholder
        holder.ivDokumentasiImage.setImageResource(R.drawable.placeholder_image);
    }

    @Override
    public int getItemCount() {
        return dokumentasiList.size();
    }

    static class DokumentasiViewHolder extends RecyclerView.ViewHolder {
        ImageView ivDokumentasiImage;
        TextView tvDokumentasiTitle;
        TextView tvDokumentasiDescription;

        public DokumentasiViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDokumentasiImage = itemView.findViewById(R.id.ivDokumentasiImage);
            tvDokumentasiTitle = itemView.findViewById(R.id.tvDokumentasiTitle);
            tvDokumentasiDescription = itemView.findViewById(R.id.tvDokumentasiDescription);
        }
    }
}

