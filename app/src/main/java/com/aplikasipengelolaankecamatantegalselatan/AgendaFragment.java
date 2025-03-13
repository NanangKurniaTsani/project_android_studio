package com.aplikasipengelolaankecamatantegalselatan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AgendaFragment extends BaseFragment {

    private RecyclerView rvAgendaAll;
    private AgendaAdapter agendaAdapter;
    private TabLayout tabLayoutAgenda;
    private List<MainActivity.AgendaItem> allAgendaItems;
    private List<MainActivity.AgendaItem> ongoingAgendaItems;
    private List<MainActivity.AgendaItem> completedAgendaItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agenda, container, false);

        rvAgendaAll = view.findViewById(R.id.rvAgendaAll);
        tabLayoutAgenda = view.findViewById(R.id.tabLayoutAgenda);

        // Initialize data
        prepareAgendaData();

        // Set up RecyclerView
        rvAgendaAll.setLayoutManager(new LinearLayoutManager(getContext()));
        agendaAdapter = new AgendaAdapter(allAgendaItems);
        rvAgendaAll.setAdapter(agendaAdapter);

        // Set up tab selection listener
        tabLayoutAgenda.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0: // All
                        agendaAdapter = new AgendaAdapter(allAgendaItems);
                        break;
                    case 1: // Ongoing
                        agendaAdapter = new AgendaAdapter(ongoingAgendaItems);
                        break;
                    case 2: // Completed
                        agendaAdapter = new AgendaAdapter(completedAgendaItems);
                        break;
                }
                rvAgendaAll.setAdapter(agendaAdapter);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Not needed
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Not needed
            }
        });

        return view;
    }

    private void prepareAgendaData() {
        allAgendaItems = new ArrayList<>();
        ongoingAgendaItems = new ArrayList<>();
        completedAgendaItems = new ArrayList<>();

        // Add all agenda items
        allAgendaItems.add(new MainActivity.AgendaItem("15 Mar", "Rapat Koordinasi Pembangunan",
                "Pembahasan rencana pembangunan infrastruktur daerah", "Akan Datang"));
        allAgendaItems.add(new MainActivity.AgendaItem("22 Mar", "Sosialisasi Program Pemerintah",
                "Penyampaian informasi program pemberdayaan masyarakat", "Akan Datang"));
        allAgendaItems.add(new MainActivity.AgendaItem("05 Apr", "Musyawarah Perencanaan Pembangunan",
                "Musrenbang tingkat kecamatan", "Akan Datang"));
        allAgendaItems.add(new MainActivity.AgendaItem("10 Mar", "Pelatihan Kewirausahaan",
                "Pelatihan untuk UMKM di wilayah kecamatan", "Sedang Berlangsung"));
        allAgendaItems.add(new MainActivity.AgendaItem("05 Mar", "Vaksinasi Massal",
                "Program vaksinasi untuk warga kecamatan", "Selesai"));
        allAgendaItems.add(new MainActivity.AgendaItem("01 Mar", "Musyawarah Desa",
                "Pembahasan program desa tahun 2025", "Selesai"));

        // Filter for ongoing and upcoming
        for (MainActivity.AgendaItem item : allAgendaItems) {
            if (item.getStatus().equals("Sedang Berlangsung") || item.getStatus().equals("Akan Datang")) {
                ongoingAgendaItems.add(item);
            }
        }

        // Filter for completed
        for (MainActivity.AgendaItem item : allAgendaItems) {
            if (item.getStatus().equals("Selesai")) {
                completedAgendaItems.add(item);
            }
        }
    }
}

