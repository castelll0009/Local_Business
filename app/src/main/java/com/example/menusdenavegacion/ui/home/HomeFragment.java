package com.example.menusdenavegacion.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.menusdenavegacion.Producto;
import com.example.menusdenavegacion.ProductoListFragment;
import com.example.menusdenavegacion.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class HomeFragment extends Fragment {

    private static final String TAG_LIST_FRAGMENT="TAG_LIST_FRAGMENT";


    ProductoListFragment mProductoListFragment;
//public FragmentActivity fragmentActivitymObjeto = new FragmentActivity();

    private HomeViewModel homeViewModel;
//onCreateView se usa para hacer visible un fragmento en una actividad
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

//FragmentManager fm = fragmentActivitymObjeto.getSupportFragmentManager();
        //FragmentManager fm= getSupportFragmentManager();

// Android will automatically re-add any Fragments that
// have previously been added after a configuration change, // so only add it if this isn't an automatic restart.
/*
        if(savedInstanceState==null){
            FragmentTransaction ft=fm.beginTransaction(); // se instancia para realizar las transacciones entre fragmentos
            mProductoListFragment=new ProductoListFragment();
            ft.add(R.id.main_activity_frame,
                    //ft.add(R.id.drawer_layout,
                    mProductoListFragment,TAG_LIST_FRAGMENT);
            ft.commitNow();
        }else{
            mProductoListFragment=(ProductoListFragment) fm.findFragmentByTag(TAG_LIST_FRAGMENT);
        }
        */
/*
        Date now = Calendar.getInstance().getTime(); // para obtener  la hora actual
        List<Producto> ListaProductos = new ArrayList<>(0);
        ListaProductos.add(new Producto("0",now,"Arepas rellenas de carne",null,100000000,"Jhojan Herrera el pri","3118978755",
                "https://scontent-scl1-1.xx.fbcdn.net/v/t1.0-9/100823282_2460372657607892_6174919290852999168_n.jpg?_nc_cat=111&_nc_sid=e007fa&_nc_ohc=VQLnFLGIccAAX8a_F0g&_nc_ht=scontent-scl1-1.xx&oh=e19cd19994975f51ef8e1d5ee65c8437&oe=5EFA555F", 1));
        ListaProductos.add(new Producto("2",now,"Moto Kawasaki",null ,800000,"Yohan buritica","3118978755",
                "https://i.pinimg.com/564x/12/2a/82/122a82a8f01fbd35a975f7337a6fc5d0.jpg",0));
        ListaProductos.add(new Producto("1",now,"Televisor SAMSUNG 32 pulgadas",null ,60000,"Dulcilandia ","3118978755",
                "https://scontent-scl2-1.xx.fbcdn.net/v/t1.0-9/101575565_2460876410890850_2586019196403974144_n.jpg?_nc_cat=107&_nc_sid=e007fa&_nc_ohc=bXJcPuYMuqUAX__0vlu&_nc_ht=scontent-scl2-1.xx&oh=81b0606e24805f57765bdab32ce6dcfd&oe=5EFB97D7",0));
        ListaProductos.add(new Producto("3",now,"Ancheta del dia de las Madres",null ,50000,"La mama de chucho","3118978720",
                "https://scontent-scl2-1.xx.fbcdn.net/v/t1.0-0/p180x540/101343339_2460457124266112_5012038852303388672_o.jpg?_nc_cat=100&_nc_sid=e007fa&_nc_ohc=i72zQ9c_kr0AX-cGZKZ&_nc_ht=scontent-scl2-1.xx&_nc_tp=6&oh=dd0e2df1c0b0170c7f5e5300b8de0fe8&oe=5EF9E8B2",0));
        ListaProductos.add(new Producto("4",now,"Xbox ",null ,1000,"El hp de Rodas","3118978720",
                "https://scontent-scl1-1.xx.fbcdn.net/v/t1.0-9/p720x720/100669794_2460457040932787_3976913985499824128_o.jpg?_nc_cat=108&_nc_sid=e007fa&_nc_ohc=Lfz9gFh-ZvwAX_3XFha&_nc_ht=scontent-scl1-1.xx&_nc_tp=6&oh=58d7825c8bd50cdf1dd902036729600d&oe=5EFAA0E3",0));

        mProductoListFragment.setProductos(ListaProductos);
*/

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        /*
       homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        return root;

    }

}
