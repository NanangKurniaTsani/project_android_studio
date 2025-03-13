package com.aplikasipengelolaankecamatantegalselatan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DokumentasiFragment extends BaseFragment {

    private RecyclerView rvDokumentasiAll;
    private DokumentasiAdapter dokumentasiAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dokumentasi, container, false);

        rvDokumentasiAll = view.findViewById(R.id.rvDokumentasiAll);

        // Set up RecyclerView
        rvDokumentasiAll.setLayoutManager(new LinearLayoutManager(getContext()));
        dokumentasiAdapter = new DokumentasiAdapter(getDokumentasiData());
        rvDokumentasiAll.setAdapter(dokumentasiAdapter);

        return view;
    }

    private List<MainActivity.DokumentasiItem> getDokumentasiData() {
        List<MainActivity.DokumentasiItem> dokumentasiList = new ArrayList<>();

        // Add dokumentasi items
        dokumentasiList.add(new MainActivity.DokumentasiItem("Pembangunan Infrastruktur",
                "Dokumentasi pembangunan jalan dan fasilitas umum", null));
        dokumentasiList.add(new MainActivity.DokumentasiItem("Kegiatan Masyarakat",
                "Dokumentasi program pemberdayaan dan gotong royong", null));
        dokumentasiList.add(new MainActivity.DokumentasiItem("Kerja Sama Daerah",
                "Dokumentasi kerja sama antar instansi", null));
        dokumentasiList.add(new MainActivity.DokumentasiItem("Pelatihan UMKM",
                "Dokumentasi kegiatan pelatihan usaha mikro kecil menengah", null));
        dokumentasiList.add(new MainActivity.DokumentasiItem("Vaksinasi COVID-19",
                "Dokumentasi program vaksinasi massal di kecamatan", null));

        return dokumentasiList;
    }
}

