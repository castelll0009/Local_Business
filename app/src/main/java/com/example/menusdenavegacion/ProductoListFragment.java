package com.example.menusdenavegacion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


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
            /******************************* Add this code **********************************/
        }
    };
//*************************** Add this code *************************************

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