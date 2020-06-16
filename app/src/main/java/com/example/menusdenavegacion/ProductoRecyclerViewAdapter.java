package com.example.menusdenavegacion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menusdenavegacion.databinding.ListItemProductoBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class ProductoRecyclerViewAdapter extends RecyclerView.Adapter<ProductoRecyclerViewAdapter.ViewHolder> {
    //Step 1 of 3: Defines a variable for listening user interactions with the items list
    private static View.OnClickListener mOnItemClickListener; //variable que escuchara las interaciones con los items de la lista list_item_pruductos
    private static final NumberFormat PRICE_FORMAT = new DecimalFormat("");
    //Step 2 of 3: Assign itemClickListener to your local View.OnClickListener variable
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
    /*
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombreProducto;
        TextView nombrePropietario;
        TextView telefono;
        TextView precio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreProducto =(TextView)itemView.findViewById(R.id.textview_nombre_producto);
            nombrePropietario =(TextView)itemView.findViewById(R.id.textview_propietario);
            precio =(TextView)itemView.findViewById(R.id.button_precio);
            telefono =(TextView)itemView.findViewById(R.id.textView_telefono);
        }
    }*/
    public static class ViewHolder extends RecyclerView.ViewHolder{

    public final ListItemProductoBinding bindingProducto;
        public ViewHolder(ListItemProductoBinding bindingProducto) {
            super(bindingProducto.getRoot());
            this.bindingProducto = bindingProducto;
            bindingProducto.setPriceFormat(PRICE_FORMAT);
            //Step 3 of 3: setTag() como titular de la vista actual junto con
            //setOnClickListener () como su variable local View.OnClickListener.
            // Puede configurar el mismo mOnItemClickListener en varias vistas si es necesario
            // y luego diferenciar esos clics usando la identificación de la vista.
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }

    public List<Producto> productosLista;
//le pasamos la lista que tiene el recycler a la lista que acabamos de crear
    public ProductoRecyclerViewAdapter(List<Producto> productosLista) {
        this.productosLista = productosLista;
    }
/*
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_producto,parent,false);
        ViewHolder viewHolder=new ViewHolder(view, bindingProducto);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ProductoRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.nombreProducto.setText(productosLista.get(position).getNombre());
        holder.nombrePropietario.setText(productosLista.get(position).getPropietario());
        holder.telefono.setText(productosLista.get(position).getTelefono());
        holder.precio.setText(PRICE_FORMAT.format(productosLista.get(position).getPrecio()) );
    }*/
@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ListItemProductoBinding binding = ListItemProductoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    return new ViewHolder(binding);
}
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Producto producto = productosLista.get(position);
        holder.bindingProducto.setProducto(producto);
        holder.bindingProducto.executePendingBindings();
    }
    @Override
    public int getItemCount() {
    return productosLista.size();
    }
}

