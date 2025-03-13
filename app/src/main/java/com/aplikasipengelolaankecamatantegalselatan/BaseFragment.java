package com.aplikasipengelolaankecamatantegalselatan;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

/**
 * Base fragment class that handles common functionality for all fragments
 */
public class BaseFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        // Set up action bar title based on fragment
        if (getActivity() != null) {
            ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
            if (actionBar != null) {
                // Set title based on fragment class
                if (this instanceof com.aplikasipengelolaankecamatantegalselatan.ProfilFragment) {
                    actionBar.setTitle(R.string.profil);
                } else if (this instanceof com.aplikasipengelolaankecamatantegalselatan.StrukturFragment) {
                    actionBar.setTitle(R.string.struktur);
                } else if (this instanceof AgendaFragment) {
                    actionBar.setTitle(R.string.agenda);
                } else if (this instanceof DokumentasiFragment) {
                    actionBar.setTitle(R.string.dokumentasi);
                } else if (this instanceof FaqFragment) {
                    actionBar.setTitle(R.string.faq);
                } else if (this instanceof PetaFragment) {
                    actionBar.setTitle(R.string.peta);
                }
            }
        }
    }
}

