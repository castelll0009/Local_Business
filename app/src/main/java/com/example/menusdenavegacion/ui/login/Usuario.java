package com.example.menusdenavegacion.ui.login;

import android.location.Location;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;

import com.example.menusdenavegacion.Producto;
import com.squareup.picasso.Picasso;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    private String mId;
    private String mEmail;
    private String mPassword;
    private String mNombre;
    private Location mLocation;
    private double mSaldo;
    private String mTelefono;
    private String mUrlFoto;

    public Usuario() {
        //constructor por defecto
    }
    public ArrayList<Producto> getUsuarioListaProductos() {
        return usuarioListaProductos;
    }

    public void setUsuarioListaProductos(ArrayList<Producto> usuarioListaProductos) {
        this.usuarioListaProductos = usuarioListaProductos;
    }

    private ArrayList<Producto> usuarioListaProductos = new ArrayList<Producto>();

    public Usuario(ArrayList<Producto> listaProductos) {
        usuarioListaProductos = listaProductos;
    }
    public String getId() {
        return mId;
    }
    public String getEmail() {
        return mEmail;
    }
    public String getPassword() {
        return mPassword;
    }
    public String getNombre() {
        return mNombre;
    } //details
    public Location getLocation() {
        return mLocation;
    }
    public double getmSaldo() {
        return mSaldo;
    } //magnitude
    private static final NumberFormat PRICE_FORMAT_DETAIL = new DecimalFormat("");
    public String getSaldoFormatDecimal() {
        return PRICE_FORMAT_DETAIL.format(mSaldo);
    }
    public String getmPrecioConvertidoString(){
        return Double.toString(mSaldo);
    }
    public String getTelefono(){
        return mTelefono;
    }
    public String getUrlFoto(){
        return mUrlFoto;
    }
    public Usuario(String email, String password){
        mEmail = email;
        mPassword = password;
    }
    public Usuario(String nombre, String email, String password, String telefono){
        mNombre = nombre;
        mEmail = email;
        mPassword = password;
        mTelefono = telefono;
    }
    public Usuario(String id, String email, String password, String nombre, Location location, double saldo, String Telefono, String urlFoto){
        mId = id;
        mEmail = email;
        mPassword = password;
        mNombre = nombre;
//        usuarioListaProductos = listaProductos;
        mLocation = location;
        mSaldo= saldo;
        mTelefono = Telefono;
        mUrlFoto = urlFoto;

    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof com.example.menusdenavegacion.ui.login.Usuario)
            return (((com.example.menusdenavegacion.ui.login.Usuario) obj).getId().contentEquals(mId));
        else
            return false;
    }
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(imageUrl).into(view);
    }

}