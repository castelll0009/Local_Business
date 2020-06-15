package com.example.menusdenavegacion.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.menusdenavegacion.ui.login.Usuario;

import java.util.ArrayList;

public class GalleryViewModel extends ViewModel  {
 // creamos unA rraylist con envoltura obsercable , asociado a un ciclo de  vida
    private MutableLiveData<ArrayList<Usuario>> ListaUsuarios;
    //constructor de la clase HomeViewModel , permite modificar el objeto en este caso le pasamos un mensaje por defecto
    //metodo publico que permitira  obetener el objeto Listausuarios
    public GalleryViewModel() {
        ListaUsuarios = new MutableLiveData<>();
    }
    //constructor
    public LiveData<ArrayList<Usuario>> getListaUsuarios() {
        if (ListaUsuarios == null) {
            ListaUsuarios = new MutableLiveData<ArrayList<Usuario>>();
            loadUsers();
        }
        return ListaUsuarios;
    }
    private void loadUsers() {
        //Realice una operación asincrónica para load usuarios.
    }
    private void addUsers(){}
}