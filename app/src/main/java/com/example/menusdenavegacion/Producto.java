package com.example.menusdenavegacion;


/*
public class Earthquake {


    private String mId;
    private String mDetails;
    private Location mLocation;
    private double mMagnitude;
    private String mLink;

    public String getId() {
        return mId;
    }

    public String getDetails() {
        return mDetails;
    }

    public Location getLocation() {
        return mLocation;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLink() {
        return mLink;
    }

    public Earthquake(String id, Date date, String details, Location location,
                      double magnitude, String link) {
        mId = id;
        mDate = date;
        mDetails = details;
        mLocation = location;
        mMagnitude = magnitude;
        mLink = link;
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH.mm", Locale.US);
        String dateString = sdf.format(mDate);
        return dateString + ": " + mMagnitude + " " + mDetails;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Earthquake)
            return (((Earthquake) obj).getId().contentEquals(mId));
        else
            return false;
    }
}
*/

import android.location.Location;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

import java.util.Date;

public class Producto {
    /**
     * Properties with information about the earthquake
     */
    private String mId;
    private Date mDate;
    private String mNombre;
    private Location mLocation;
    private double mPrecio;
    private String mPropietario;
    private String mTelefono;
    private String mUrlImage;
    private  int mIs_new;

    public int getIs_new() {
        return mIs_new;
    }


    public String getId() {
        return mId;
    }

    public Date getDate() {
        return mDate;
    }

    public String getNombre() {
        return mNombre;
    } //details

    public Location getLocation() {
        return mLocation;
    }

    public String getPropietario() {
        return mPropietario;
    }

    public double getPrecio() {
        return mPrecio;
} //magnitude

    public String getmPrecioConvertidoString(){
        return Double.toString(mPrecio);
    }


    public String getTelefono(){
        return mTelefono;
    }

    public String getUrlImage(){
        return mUrlImage;
    }


    public Producto(String id, Date date, String nombre, Location location, double precio, String propietario, String Telefono, String urlImage, int is_new){
        mId = id;
        mDate = date;
        mNombre = nombre;
        mLocation = location;
        mPrecio = precio;
        mPropietario = propietario;
        mTelefono = Telefono;
        mUrlImage = urlImage;
        mIs_new = is_new;
    }

    /**
     * Format the earthquake information to String representation
     * @return a string representing the earthquake information
     */
/*
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH.mm", Locale.US);
        String dateString = sdf.format(mDate);
        return dateString + ": " + mPrecio + " " + mNombre;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Producto)
            return (((Producto) obj).getId().contentEquals(mId));
        else
            return false;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get().load(imageUrl).into(view);
    }
/*
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {

        Picasso.get().load(imageUrl).into(view);
    }*/
/*
    @BindingAdapter( BindingAdapter({"bind:imageUrl","bind:error"})
    public static void loadImage(ImageView view, String url,Drawable error) {
        Picasso.(view.getContext()).load(imageUrl)
                .placeholder(R.drawable.placeholder)
                .into(view);
    }*/
/*
    @BindingAdapter() BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.placeholder)
                .into(view);
    }

 */
}