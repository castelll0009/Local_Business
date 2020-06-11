package com.example.menusdenavegacion.ui.home;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.menusdenavegacion.Producto;
import com.example.menusdenavegacion.ProductoListFragment;
import com.example.menusdenavegacion.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
//Se diseñó la clase ViewModel a fin de almacenar y administrar datos relacionados con la IU de
// manera optimizada para los ciclos de vida. La clase ViewModel permite que los datos sobrevivan a cambios
// de configuración, como las rotaciones de pantallas.

// Se trata de una envoltura observable para nuestros datos con la ventaja de que está asociado
// a un ciclo de vida (de un fragment o activity).
public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText; // creamos un string con envoltura obsercable , asociado a un ciclo de  vida

     //constructor de la clase HomeViewModel , permite modificar el objeto en este caso le pasamos un mensaje por defecto
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment"); //modificamos el valor del string
    }
//metodo publico que permitira  obetener el objeto mText
    public LiveData<String> getText() {
        return mText;
    }

}