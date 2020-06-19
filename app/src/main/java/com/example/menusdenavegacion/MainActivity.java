package com.example.menusdenavegacion;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.widget.SearchView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

public class  MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        Bundle bundle = getIntent().getExtras();
        String fraseimportada=bundle.getString("NAME_ADD");
        String textoPasado = fraseimportada;*/
//        boolean seCreo = ProductoVerderActivity.seCreoProducto;
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Este método establece la barra de herramientas como la barra de la app de la actividad
        FloatingActionButton fab = findViewById(R.id.fab); //define un boton flotante en activity_main
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG) //barra que se despliega
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout); //creamos un contenedor drawer sobre el cual se pondran las otras views
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each ; pasar cada Id como un menu
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.productoVerderActivity, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_lista_productos,R.id.nav_loginFragment,
                R.id.nav_registerFragment)
                .setDrawerLayout(drawer)//mete las views en los drawer dibujables
                .build();
        //NavController gestiona la navegacion de la  app con un NavHost
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //busca quien controle la navegacion en este caso elije la vista nav_host_fragment
        //NavigaationUI conecta elementos  de drawer o btones , barras de navegacion  que tengan su NavController
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration); //actualiza el titulo de la barra de accion
        NavigationUI.setupWithNavController(navigationView, navController); //actualiza titulo de la barra de  herramientas
//////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // agrega elementos a la barra de accion si estos estan presentes
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ProductoListFragment.adaptadorProductos.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
    //Se llama a este método cada vez que el usuario elige navegar hacia arriba dentro de la jerarquía
    // de actividad de su aplicación desde la barra de acción.
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) //llena el nav_host con el elemento selecionado del menu
                || super.onSupportNavigateUp();
    }

   public  boolean sesion = false;
    public boolean getSesion(){
        return sesion;
    }

}
