package com.example.menusdenavegacion.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.menusdenavegacion.MainActivity;
import com.example.menusdenavegacion.Producto;
import com.example.menusdenavegacion.ProductoDetailActivity;
import com.example.menusdenavegacion.ProductoListFragment;
import com.example.menusdenavegacion.R;

import java.util.ArrayList;
import java.util.List;

public class RegisterFragment extends Fragment {
    private ArrayList<Usuario> ListaUsuarios = new ArrayList<Usuario>();
    //ArrayList<Usuario> ListaUsuarios = (ArrayList<Usuario>) getArguments().getSerializable("bundle_key");
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        //acciones
        TextView loginTextview  = view.findViewById(R.id.createText);
        Button botonRegistro = view.findViewById(R.id.boton_registro);
        ///Campos que necesitamos
        final EditText nombreCompleto = view.findViewById(R.id.fullName);
        final EditText email = view.findViewById(R.id.Email);
        final EditText password = view.findViewById(R.id.password);
        final EditText telefono = view.findViewById(R.id.phone);

        loginTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment, new LoginFragment());
                fr.commit();
            }
        });

        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String varNombreCompleto = nombreCompleto.getText().toString();
                String varEmail = email.getText().toString();
                String varPassword = password.getText().toString();
                String varTelefono = telefono.getText().toString();

                ListaUsuarios.add(new Usuario(varNombreCompleto, varEmail, varPassword, varTelefono));
                informacionGlobal.SESION =true;

            }
        });
        return view;
    }
    public List<Usuario> obtenerUsuario() {
        return ListaUsuarios;
    }
}
