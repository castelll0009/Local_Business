package com.example.menusdenavegacion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/*
public class ProductoListFragment extends Fragment {

    private ArrayList<Producto> mProductos = new ArrayList<Producto>();

    private RecyclerView mRecyclerView;
    private ProductoRecyclerViewAdapter mProductoAdapter=
            new ProductoRecyclerViewAdapter(mProductos);

    //*************************** Add this code *************************************
    // set a listener to handle events from RecyclerView
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Step 4 of 4: Finally call getTag() on the view.
            // This viewHolder will have all required values.
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            // viewHolder.getItemId();
            // viewHolder.getItemViewType();
            // viewHolder.itemView;
            Producto thisItem = mProductos.get(position);
//toast que mostraba el desplegable cuando se presionaba alguna view
           // Toast.makeText(getContext(), "You Clicked: " + thisItem.getNombre(), Toast.LENGTH_SHORT).show();

            /******************************* Add this code **********************************/
/*
            //Create the intent for navigation purposes; the context is the current Activity, so getActivity() must be called
            Intent i = new Intent(getActivity(), ProductoDetailActivity.class);
            //Set information in the intent for the next Activity
            i.putExtra("NAME_PRODUCTO", thisItem.getNombre());
            i.putExtra("NAME_PROPIETARIO", thisItem.getPropietario());
            i.putExtra("PHONE", thisItem.getTelefono());
            i.putExtra("IMAGE", thisItem.getUrlImage());
            i.putExtra("PRICE", thisItem.getmPrecioConvertidoString());
            //i.putExtra("LOCATION", thisItem.getLocation());
            //Launch the new Activity
            startActivity(i);

        }
    };


    public ProductoListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_producto_list,
                container,false);

        //*********************** Add this code **********************

        mRecyclerView=(RecyclerView)view.findViewById(R.id.list);

        //*********************** Add this code **********************
        return view;
    }
    //************************** Add this code ***************************
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
// Set the Recycler View adapter
        Context context=view.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(mProductoAdapter);

        //*************************** Add this code *************************************
        //Step 1 of 4: Create and set OnItemClickListener to the adapter.
        mProductoAdapter.setOnItemClickListener(onItemClickListener);
        //*************************** Add this code *************************************
    }

    public void setProductos(List<Producto> productos){
        for(Producto producto:productos){
            if(!mProductos.contains(producto)){
                mProductos.add(producto);
                mProductoAdapter
                        .notifyItemInserted(mProductos.indexOf(producto));
            }
        }
    }

}
*/

public class   ProductoListFragment extends Fragment{
    //List<Producto> ListaProductos=new ArrayList<>();
    private ArrayList<Producto> ListaProductos = new ArrayList<Producto>();
    private RecyclerView RecyclerViewProductos;
    private ProductoRecyclerViewAdapter adaptadorProductos;
    private LinearLayoutManager layoutManager;
    private Producto adaptador;
    View viewBotones;
    // set a listener to handle events from RecyclerView
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            //Step 4 of 4: Finally call getTag() on the view.
            // This viewHolder will have all required values.
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            // viewHolder.getItemId();
            // viewHolder.getItemViewType();
            // viewHolder.itemView;
            Producto thisItem = ListaProductos.get(position);
            //Toast.makeText(getContext(), "You Clicked: " + thisItem.getNombre(), Toast.LENGTH_SHORT).show();

            //Create the intent for navigation purposes; the context is the current Activity, so getActivity() must be called
            Intent i = new Intent(getActivity(), ProductoDetailActivity.class);
            //Set information in the intent for the next Activity
            i.putExtra("NAME", thisItem.getNombre());
            i.putExtra("OWNER", thisItem.getPropietario());
            i.putExtra("PRICE", thisItem.getPrecioFormatDecimal());
            i.putExtra("PHONE", thisItem.getTelefono());
            i.putExtra("IMAGE", thisItem.getUrlImage());
            //i.putExtra("TIME", thisItem.getDate().toString());
            //Launch the new Activity
            startActivity(i);
            //////////////////////////////////////////
        }

    };
    public ProductoListFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_producto_list, container, false);
        Button botonComprar;

        RecyclerViewProductos=(RecyclerView)view.findViewById(R.id.list);
        layoutManager= new LinearLayoutManager(getActivity());
        RecyclerViewProductos.setLayoutManager(layoutManager);

        adaptadorProductos=new ProductoRecyclerViewAdapter(obtenerProducto());
        RecyclerViewProductos.setAdapter(adaptadorProductos);
        //Step 1 of 4: Create and set OnItemClickListener to the adapter.
        adaptadorProductos.setOnItemClickListener(onItemClickListener); //configuramos un escuchador para el adaptador
        ////navegacion de  botonoes de  la lista de prtoductos/////
        //botonComprar = (Button) view.findViewById(R.id.botton_buy);

        return view;
    }

    public List<Producto> obtenerProducto() {


        Date now = Calendar.getInstance().getTime(); // para obtener  la hora actual
        ListaProductos.add(new Producto("0",now,"Arepas rellenas de carne",null,100000000,"Jhojan Herrera el pri","3118978755",
                "https://scontent-scl1-1.xx.fbcdn.net/v/t1.0-9/100823282_2460372657607892_6174919290852999168_n.jpg?_nc_cat=111&_nc_sid=e007fa&_nc_ohc=VQLnFLGIccAAX8a_F0g&_nc_ht=scontent-scl1-1.xx&oh=e19cd19994975f51ef8e1d5ee65c8437&oe=5EFA555F", 1));
        ListaProductos.add(new Producto("2",now,"Moto Kawasaki",null ,800000,"Yohan buritica","3118978755",
                "https://www.arpem.com/imagenes/ficha/0/3/5/4/2013-zx-636-r.990354.jpg",0));
        ListaProductos.add(new Producto("1",now,"Televisor SAMSUNG 32 pulgadas",null ,60000,"Dulcilandia ","3118978755",
                "https://scontent-scl2-1.xx.fbcdn.net/v/t1.0-9/101575565_2460876410890850_2586019196403974144_n.jpg?_nc_cat=107&_nc_sid=e007fa&_nc_ohc=bXJcPuYMuqUAX__0vlu&_nc_ht=scontent-scl2-1.xx&oh=81b0606e24805f57765bdab32ce6dcfd&oe=5EFB97D7",0));
        ListaProductos.add(new Producto("3",now,"Ancheta del dia de las Madres",null ,50000,"La mama de chucho","3118978720",
                "https://scontent-scl2-1.xx.fbcdn.net/v/t1.0-0/p180x540/101343339_2460457124266112_5012038852303388672_o.jpg?_nc_cat=100&_nc_sid=e007fa&_nc_ohc=i72zQ9c_kr0AX-cGZKZ&_nc_ht=scontent-scl2-1.xx&_nc_tp=6&oh=dd0e2df1c0b0170c7f5e5300b8de0fe8&oe=5EF9E8B2",0));
        ListaProductos.add(new Producto("4",now,"Xbox ",null ,1000,"El hp de Rodas","3118978720",
                "https://scontent-scl1-1.xx.fbcdn.net/v/t1.0-9/p720x720/100669794_2460457040932787_3976913985499824128_o.jpg?_nc_cat=108&_nc_sid=e007fa&_nc_ohc=Lfz9gFh-ZvwAX_3XFha&_nc_ht=scontent-scl1-1.xx&_nc_tp=6&oh=58d7825c8bd50cdf1dd902036729600d&oe=5EFAA0E3",0));


        return ListaProductos;
    }

}