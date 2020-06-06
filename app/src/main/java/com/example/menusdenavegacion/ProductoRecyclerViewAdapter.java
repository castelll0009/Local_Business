package com.example.menusdenavegacion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.menusdenavegacion.databinding.ListItemProductoBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

//import edu.unicauca.earthquake.databinding.ListItemProductoBinding;


public class ProductoRecyclerViewAdapter extends RecyclerView.Adapter<ProductoRecyclerViewAdapter.ViewHolder> {
    private final List<Producto> mProductos;
    //***** Add this code to ProductoRecyclerViewAdapter variables definition section ********
    //private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm", Locale.US);
    private static final NumberFormat PRICE_FORMAT = new DecimalFormat("");
    //Step 1 of 3: Defines a variable for listening user interactions with the items list
    private static View.OnClickListener mOnItemClickListener;

    //Step 2 of 3: Assign itemClickListener to your local View.OnClickListener variable
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    public ProductoRecyclerViewAdapter(List<Producto> productos) {
        mProductos = productos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemProductoBinding binding = ListItemProductoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return mProductos.size();
    }

/*
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View parentView;
        public final TextView detailsView;
        public Producto producto;

        public ViewHolder(View view) {
            super(view);
            parentView = view;
            detailsView = (TextView)
                    view.findViewById(R.id.list_item_producto_details);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + detailsView.getText() + "'";
        }
    }*/

    public static class ViewHolder extends RecyclerView.ViewHolder {
    /*
       //public final TextView date;
       public final TextView nombre;
       public final TextView propietario;
       public final TextView precio;
       public final TextView telefono;


    public ViewHolder(View view) {
        super(view);
        //date = (TextView) view.findViewById(R.id.date);
        propietario = (TextView) view.findViewById(R.id.propietario);
        nombre = (TextView) view.findViewById(R.id.nombreProducto);
        precio = (TextView) view.findViewById(R.id.precio);
        telefono = (TextView) view.findViewById(R.id.telefono);
    }
   */
    public final ListItemProductoBinding binding;

        public ViewHolder(ListItemProductoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            //binding.setTimeformat(TIME_FORMAT);
            //binding.setMagnitudeformat(MAGNITUDE_FORMAT);
            binding.setPriceFormat(PRICE_FORMAT);

            //Step 3 of 3: setTag() as current view holder along with
            // setOnClickListener() as your local View.OnClickListener variable.
            // You can set the same mOnItemClickListener on multiple views if required
            // and later differentiate those clicks using view's id.
            //funcion para poder clickear sobre diferentes items usando su id
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }
/*
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.producto = mProductos.get(position);
        holder.detailsView.setText(mProductos.get(position).toString());
    }*/
/*
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Producto earthquake = mProductos.get(position);
        //holder.date.setText(TIME_FORMAT.format(earthquake.getDate()));
        holder.nombre.setText(earthquake.getNombre());
        holder.propietario.setText(earthquake.getPropietario());
        holder.telefono.setText(earthquake.getTelefono());
        holder.precio.setText(
                PRECIO_FORMAT.format(earthquake.getPrecio()));
    }*/
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Producto producto = mProductos.get(position);
        holder.binding.setProducto(producto);
        holder.binding.executePendingBindings();
    }

}