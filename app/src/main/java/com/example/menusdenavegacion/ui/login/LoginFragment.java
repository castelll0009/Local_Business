package com.example.menusdenavegacion.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.menusdenavegacion.MainActivity;
import com.example.menusdenavegacion.R;
import com.example.menusdenavegacion.ui.gallery.GalleryViewModel;

import java.util.ArrayList;

public class LoginFragment extends Fragment {
    public static  boolean SESION = true;

    public static ArrayList<Usuario> ListaUsuarios = new ArrayList<Usuario>();
    String nombreRecibido;
    String emailRecibido;
    String passwordRecibido;
    String telefonoRecibido;

    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
        //recuperamos  valores desde le fragmento registro
        Bundle bundle = getArguments();
        if(bundle != null){
            // handle your code here.
            nombreRecibido = bundle.getString("NAME");
            emailRecibido = bundle.getString("EMAIL");
            passwordRecibido = bundle.getString("PASSWORD");
            telefonoRecibido = bundle.getString("PHONE");
            //ListaUsuarios.add(new Usuario(nombreRecibido,emailRecibido,passwordRecibido,telefonoRecibido));

        }else{
            nombreRecibido = "default";
            emailRecibido = "default";
            passwordRecibido = "default";
            telefonoRecibido = "default";
        }*/
        ListaUsuarios.add(new Usuario("1","1","1","1"));

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

                String busquedaEmailUsuario = editTextNombreUsuario.getText().toString();
                String busquedaPasswordUsaurio = editTextPasswordUsuario.getText().toString();
                boolean encontrado = false;
                for (int x = 0; x < ListaUsuarios.size(); x++) {
                    Usuario user = ListaUsuarios.get(x);
                    if (user.getEmail().equals(busquedaEmailUsuario)) {
                        if (user.getPassword().equals(busquedaPasswordUsaurio)) {
                            encontrado = true;
                            break; // Terminar ciclo, pues ya lo encontramos
                        }
                    }
                }
                if (encontrado) { //entonces  debemos hacer el login sin problemas
                    //cambiar el estado de  sesion y logear usuario
                    SESION = true;
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    startActivity(i);
                } else {
                    //no logear usuario
                    Toast.makeText(getContext(), "El correo ó contraseña son incorrectos, intentelo de nuevo.", Toast.LENGTH_LONG).show();

                }
            }

        });
        return view;
    }
}



