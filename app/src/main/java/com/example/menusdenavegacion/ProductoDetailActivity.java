package com.example.menusdenavegacion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ProductoDetailActivity extends AppCompatActivity implements View.OnClickListener {
    //Variables to store the information from the intent
    String getProductoNombre; //date
    String getproductoTelefono;
    String getPropietario;
    String getImagen;
    String getPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_detail);

        //Capture the intent from previous activity
        Intent i = getIntent();
        //Get the intent information
        Bundle b = i.getExtras();
        getProductoNombre = b.getString("NAME");
        getPropietario = b.getString("OWNER");
        getproductoTelefono = b.getString("PHONE");
        getImagen = b.getString("IMAGE");
        getPrecio = b.getString("PRICE");
        //productoLocation = b.getString("LOCATION");
        //productoLocation = b.getString("NAME"); // porque no sirve la variable LOcation

        TextView productoNombre = (TextView) findViewById(R.id.textview_nombre_producto_detail);
        TextView productoPropietario = (TextView) findViewById(R.id.textview_propietario_detail);
        ImageView productoImagen = (ImageView)findViewById(R.id.imageView_detail);
        TextView productoPrecio = (TextView) findViewById(R.id.button_precio);

        productoNombre.setText(getProductoNombre);
        productoPropietario.setText("Propietario: " + getPropietario + " Telefono: " + getproductoTelefono + ". Puedes llamar al vendedor ahora mismo.");

        productoPrecio.setText(getPrecio);

        Picasso.get().load(getImagen).into(productoImagen);

///////////boton comprar//// por ahora gps
        ImageView mapButton = (ImageView)findViewById(R.id.imageView_ubicacion_producto);
        mapButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String coordinates;
        if (getProductoNombre.equals("San Jose")) coordinates = "37.330233,-121.888113";
        else if (getProductoNombre.equals("LA")) coordinates = "34.039907, -118.261863";
        else coordinates = "37.440092, -122.143413";

        //Create an URI for Google Maps
        Uri uri = Uri.parse("geo:" + coordinates);
        //Create an implicit intent the Android runtime will resolve to display the correct Activity (Google Maps)

        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}