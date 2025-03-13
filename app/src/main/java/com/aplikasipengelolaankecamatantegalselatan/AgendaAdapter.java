package com.aplikasipengelolaankecamatantegalselatan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.AgendaViewHolder> {

    private List<MainActivity.AgendaItem> agendaList;

    public AgendaAdapter(List<MainActivity.AgendaItem> agendaList) {
        this.agendaList = agendaList;
    }

    @NonNull
    @Override
    public AgendaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agenda, parent, false);
        return new AgendaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AgendaViewHolder holder, int position) {
        MainActivity.AgendaItem item = agendaList.get(position);
        holder.tvAgendaDate.setText(item.getDate());
        holder.tvAgendaTitle.setText(item.getTitle());
        holder.tvAgendaDescription.setText(item.getDescription());
        holder.tvAgendaStatus.setText(item.getStatus());

        // Set status color based on status value
        if (item.getStatus().equals("Akan Datang")) {
            holder.tvAgendaStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.status_upcoming));
        } else if (item.getStatus().equals("Sedang Berlangsung")) {
            holder.tvAgendaStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.status_ongoing));
        } else if (item.getStatus().equals("Selesai")) {
            holder.tvAgendaStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.status_completed));
        }
    }

    @Override
    public int getItemCount() {
        return agendaList.size();
    }

    static class AgendaViewHolder extends RecyclerView.ViewHolder {
        TextView tvAgendaDate;
        TextView tvAgendaTitle;
        TextView tvAgendaDescription;
        TextView tvAgendaStatus;

        public AgendaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAgendaDate = itemView.findViewById(R.id.tvAgendaDate);
            tvAgendaTitle = itemView.findViewById(R.id.tvAgendaTitle);
            tvAgendaDescription = itemView.findViewById(R.id.tvAgendaDescription);
            tvAgendaStatus = itemView.findViewById(R.id.tvAgendaStatus);
        }
    }
}

