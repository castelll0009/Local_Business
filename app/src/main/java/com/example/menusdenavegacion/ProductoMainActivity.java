package com.example.menusdenavegacion;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class ProductoMainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private static final String TAG_LIST_FRAGMENT="TAG_LIST_FRAGMENT";


    ProductoListFragment mProductoListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        /////////barra de herramientas///////////////////////////
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        //////////////////////////////////////////////////////////////////
        */

        FragmentManager fm=getSupportFragmentManager();
// Android will automatically re-add any Fragments that
// have previously been added after a configuration change, // so only add it if this isn't an automatic restart.
        if(savedInstanceState==null){
            FragmentTransaction ft=fm.beginTransaction();
            mProductoListFragment=new ProductoListFragment();
            ft.add(R.id.main_activity_frame,
                    //ft.add(R.id.drawer_layout,
                    mProductoListFragment,TAG_LIST_FRAGMENT);
            ft.commitNow();
        }else{
            mProductoListFragment=(ProductoListFragment) fm.findFragmentByTag(TAG_LIST_FRAGMENT);
        }

        Date now = Calendar.getInstance().getTime(); // para obtener  la hora actual
        List<Producto> dummyQuakes = new ArrayList<>(0);
        dummyQuakes.add(new Producto("0",now,"Arepas rellenas de carne",null,100000000,"Jhojan Herrera el pri","3118978755",
                "https://scontent-scl1-1.xx.fbcdn.net/v/t1.0-9/100823282_2460372657607892_6174919290852999168_n.jpg?_nc_cat=111&_nc_sid=e007fa&_nc_ohc=VQLnFLGIccAAX8a_F0g&_nc_ht=scontent-scl1-1.xx&oh=e19cd19994975f51ef8e1d5ee65c8437&oe=5EFA555F", 1));
        dummyQuakes.add(new Producto("2",now,"Moto Kawasaki",null ,800000,"Yohan buritica","3118978755",
                "https://i.pinimg.com/564x/12/2a/82/122a82a8f01fbd35a975f7337a6fc5d0.jpg",0));
        dummyQuakes.add(new Producto("1",now,"Televisor SAMSUNG 32 pulgadas",null ,60000,"Dulcilandia ","3118978755",
                "https://scontent-scl2-1.xx.fbcdn.net/v/t1.0-9/101575565_2460876410890850_2586019196403974144_n.jpg?_nc_cat=107&_nc_sid=e007fa&_nc_ohc=bXJcPuYMuqUAX__0vlu&_nc_ht=scontent-scl2-1.xx&oh=81b0606e24805f57765bdab32ce6dcfd&oe=5EFB97D7",0));
        dummyQuakes.add(new Producto("3",now,"Ancheta del dia de las Madres",null ,50000,"La mama de chucho","3118978720",
                "https://scontent-scl2-1.xx.fbcdn.net/v/t1.0-0/p180x540/101343339_2460457124266112_5012038852303388672_o.jpg?_nc_cat=100&_nc_sid=e007fa&_nc_ohc=i72zQ9c_kr0AX-cGZKZ&_nc_ht=scontent-scl2-1.xx&_nc_tp=6&oh=dd0e2df1c0b0170c7f5e5300b8de0fe8&oe=5EF9E8B2",0));
        dummyQuakes.add(new Producto("4",now,"Xbox ",null ,1000,"El hp de Rodas","3118978720",
                "https://scontent-scl1-1.xx.fbcdn.net/v/t1.0-9/p720x720/100669794_2460457040932787_3976913985499824128_o.jpg?_nc_cat=108&_nc_sid=e007fa&_nc_ohc=Lfz9gFh-ZvwAX_3XFha&_nc_ht=scontent-scl1-1.xx&_nc_tp=6&oh=58d7825c8bd50cdf1dd902036729600d&oe=5EFAA0E3",0));

        mProductoListFragment.setProductos(dummyQuakes);


    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
/*
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    */

}
