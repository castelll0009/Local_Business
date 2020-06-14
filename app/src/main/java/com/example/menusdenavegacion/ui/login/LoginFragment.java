package com.example.menusdenavegacion.ui.login;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menusdenavegacion.MainActivity;
import com.example.menusdenavegacion.Producto;
import com.example.menusdenavegacion.R;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle objetoLista = getArguments();

        Button loginBoton;
        TextView textviewRegister;
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        loginBoton = view.findViewById(R.id.loginBtn);
        textviewRegister = view.findViewById(R.id.createText);

        final EditText editTextNombreUsuario = view.findViewById(R.id.Email);
        final EditText editTextPasswordUsuario = view.findViewById(R.id.password);

        textviewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.nav_host_fragment, new RegisterFragment());
                fr.commit();
            }
        });

        loginBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario  mUsuario   = new Usuario("111", "castell@unicauca.edu.co", "castillo","Esteban Castillo",null,50000,
                        "3202486769","https://scontent-scl2-1.xx.fbcdn.net/v/t1.0-0/p206x206/50596823_2098927857085709_2754643194447659008_n.jpg?_nc_cat=109&_nc_sid=7aed08&_nc_ohc=FFL0bopQaagAX9-wOdS&_nc_ht=scontent-scl2-1.xx&_nc_tp=6&oh=77411b7771b7cbf31ad75850976c4cd5&oe=5F0B4F17");
                String emailUsaurio = editTextNombreUsuario.getText().toString();
                String passwordUsaurio = editTextPasswordUsuario.getText().toString();
                if(mUsuario.getEmail().equals(emailUsaurio) && mUsuario.getPassword().equals(passwordUsaurio) ){
                    // logro iniciar secion contraseña y correo validos
                    informacionGlobal.SESION =true;
                    Intent  i  = new Intent(getActivity(), MainActivity.class);
                    //i.putExtra("TRUE",Lo)
                    startActivity(i);
                }else{
                    Toast.makeText(getContext(), "El correo ó contraseña son incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

}
