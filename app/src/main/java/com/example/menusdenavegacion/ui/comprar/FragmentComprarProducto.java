package com.example.menusdenavegacion.ui.comprar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.menusdenavegacion.R;

public class FragmentComprarProducto extends Fragment {

    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comprar_producto, container, false);

        return view;
    }
}
