package com.aplikasipengelolaankecamatantegalselatan;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvAgendaBerlangsung;
    private RecyclerView rvAgendaSelesai;
    private RecyclerView rvDokumentasi;
    private AgendaAdapter agendaBerlangsungAdapter;
    private AgendaAdapter agendaSelesaiAdapter;
    private DokumentasiAdapter dokumentasiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up toolbar
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // Hide default title

        // Add back button handling for fragments
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onBackPressed();
                        }
                    });
                } else {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                }
            }
        });

        // Initialize RecyclerViews
        rvAgendaBerlangsung = findViewById(R.id.rvAgendaBerlangsung);
        rvAgendaSelesai = findViewById(R.id.rvAgendaSelesai);
        rvDokumentasi = findViewById(R.id.rvDokumentasi);

        // Set up Agenda Berlangsung RecyclerView
        rvAgendaBerlangsung.setLayoutManager(new LinearLayoutManager(this));
        agendaBerlangsungAdapter = new AgendaAdapter(getAgendaBerlangsungData());
        rvAgendaBerlangsung.setAdapter(agendaBerlangsungAdapter);

        // Set up Agenda Selesai RecyclerView
        rvAgendaSelesai.setLayoutManager(new LinearLayoutManager(this));
        agendaSelesaiAdapter = new AgendaAdapter(getAgendaSelesaiData());
        rvAgendaSelesai.setAdapter(agendaSelesaiAdapter);

        // Set up Dokumentasi RecyclerView
        rvDokumentasi.setLayoutManager(new LinearLayoutManager(this));
        dokumentasiAdapter = new DokumentasiAdapter(getDokumentasiData());
        rvDokumentasi.setAdapter(dokumentasiAdapter);

        // Set up tab navigation
        setupTabNavigation();
    }

    private void setupTabNavigation() {
        LinearLayout tabProfil = findViewById(R.id.tabProfil);
        LinearLayout tabStruktur = findViewById(R.id.tabStruktur);
        LinearLayout tabAgenda = findViewById(R.id.tabAgenda);
        LinearLayout tabDokumentasi = findViewById(R.id.tabDokumentasi);
        LinearLayout tabFaq = findViewById(R.id.tabFaq);
        LinearLayout tabPeta = findViewById(R.id.tabPeta);

        tabProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load Profil fragment
                loadFragment(new ProfilFragment());
            }
        });

        tabStruktur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load Struktur fragment
                loadFragment(new StrukturFragment());
            }
        });

        tabAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load Agenda fragment
                loadFragment(new AgendaFragment());
            }
        });

        tabDokumentasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load Dokumentasi fragment
                loadFragment(new DokumentasiFragment());
            }
        });

        tabFaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load FAQ fragment
                loadFragment(new FaqFragment());
            }
        });

        tabPeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load Peta fragment
                loadFragment(new PetaFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        // Show the container and hide the main content
        View container = findViewById(R.id.container);
        View mainContent = findViewById(R.id.mainScrollView);

        container.setVisibility(View.VISIBLE);
        mainContent.setVisibility(View.GONE);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();

            // Always check if we need to restore the main content visibility
            // after popping from the back stack
            View container = findViewById(R.id.container);
            View mainContent = findViewById(R.id.mainScrollView);

            container.setVisibility(View.GONE);
            mainContent.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }

    // Sample data methods
    private List<AgendaItem> getAgendaBerlangsungData() {
        List<AgendaItem> agendaList = new ArrayList<>();

        // Data from React code - only ongoing and upcoming
        agendaList.add(new AgendaItem("15 Mar", "Rapat Koordinasi Pembangunan",
                "Pembahasan rencana pembangunan infrastruktur daerah", "Akan Datang"));
        agendaList.add(new AgendaItem("22 Mar", "Sosialisasi Program Pemerintah",
                "Penyampaian informasi program pemberdayaan masyarakat", "Akan Datang"));
        agendaList.add(new AgendaItem("10 Mar", "Pelatihan Kewirausahaan",
                "Pelatihan untuk UMKM di wilayah kecamatan", "Sedang Berlangsung"));

        return agendaList;
    }

    private List<AgendaItem> getAgendaSelesaiData() {
        List<AgendaItem> agendaList = new ArrayList<>();

        // Data from React code - only completed
        agendaList.add(new AgendaItem("05 Mar", "Vaksinasi Massal",
                "Program vaksinasi untuk warga kecamatan", "Selesai"));
        agendaList.add(new AgendaItem("01 Mar", "Musyawarah Desa",
                "Pembahasan program desa tahun 2025", "Selesai"));

        return agendaList;
    }

    private List<DokumentasiItem> getDokumentasiData() {
        List<DokumentasiItem> dokumentasiList = new ArrayList<>();

        // Data from React code
        dokumentasiList.add(new DokumentasiItem("Pembangunan Infrastruktur",
                "Dokumentasi pembangunan jalan dan fasilitas umum", null));
        dokumentasiList.add(new DokumentasiItem("Kegiatan Masyarakat",
                "Dokumentasi program pemberdayaan dan gotong royong", null));
        dokumentasiList.add(new DokumentasiItem("Kerja Sama Daerah",
                "Dokumentasi kerja sama antar instansi", null));

        return dokumentasiList;
    }

    // Model classes
    public static class AgendaItem {
        private String date;
        private String title;
        private String description;
        private String status;

        public AgendaItem(String date, String title, String description, String status) {
            this.date = date;
            this.title = title;
            this.description = description;
            this.status = status;
        }

        public String getDate() { return date; }
        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public String getStatus() { return status; }
    }

    public static class DokumentasiItem {
        private String title;
        private String description;
        private String imageUrl;

        public DokumentasiItem(String title, String description, String imageUrl) {
            this.title = title;
            this.description = description;
            this.imageUrl = imageUrl;
        }

        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public String getImageUrl() { return imageUrl; }
    }
}

