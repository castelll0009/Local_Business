package com.example.menusdenavegacion.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.menusdenavegacion.R;
import com.example.menusdenavegacion.ui.login.Usuario;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getListaUsuarios().observe(getViewLifecycleOwner(), new Observer<ArrayList<Usuario>>() {

            @Override
            public void onChanged(ArrayList<Usuario> usuarios) {
                        new Usuario("111", "111@", "111","Esteban Castillo",null,50000,
                        "3202486769","https://scontent-scl2-1.xx.fbcdn.net/v/t1.0-0/p206x206/50596823_2098927857085709_2754643194447659008_n.jpg?_nc_cat=109&_nc_sid=7aed08&_nc_ohc=FFL0bopQaagAX9-wOdS&_nc_ht=scontent-scl2-1.xx&_nc_tp=6&oh=77411b7771b7cbf31ad75850976c4cd5&oe=5F0B4F17");



            }

        });


        return root;
    }

}
