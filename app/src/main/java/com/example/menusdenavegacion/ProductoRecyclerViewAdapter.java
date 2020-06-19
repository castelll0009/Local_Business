package com.example.menusdenavegacion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menusdenavegacion.databinding.ListItemProductoBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductoRecyclerViewAdapter extends RecyclerView.Adapter<ProductoRecyclerViewAdapter.ViewHolder> implements Filterable {
    public List<Producto>  productosLista;
    List<Producto> productosListAll;
    //List<Producto> ProductosAll = new ArrayList<>();

    public  ProductoRecyclerViewAdapter(List<Producto> productosLista) {
        /*
        this.productosLista = productosLista; // se inicializa la lista
        productosListAll = new ArrayList<>();
        productosListAll.addAll(productosLista);
        */
         this.productosLista = productosLista;
         this.productosListAll = new ArrayList<>(productosLista);
    }

    //Step 1 of 3: Defines a variable for listening user interactions with the items list
    private static View.OnClickListener mOnItemClickListener; //variable que escuchara las interaciones con los items de la lista list_item_pruductos
    private static final NumberFormat PRICE_FORMAT = new DecimalFormat("");
    //Step 2 of 3: Assign itemClickListener to your local View.OnClickListener variable
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    @Override
    public Filter getFilter() {
        return filter; //para obtener el filtro
    }

    Filter filter= new Filter() {
        //se ejecuta en  hilo fondo
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Producto> filteredList = new ArrayList<>();
//            List<Producto> ProductosAll = new ArrayList<>();

            List<String> listFilteredList = new ArrayList<>();
            List<String> listaProductosAll = new ArrayList<>();
            ///crear una Lista apartir de los nombres de mi ArrayListProductos.getNombre
            String apuntadorNombre;
            for(int i = 0; i < productosListAll.size(); i++){
                apuntadorNombre = productosListAll.get(i).getNombre();
                listaProductosAll.add(apuntadorNombre);
            }
///si no hay restriciones o coincidencias  encontradas
            if(constraint.toString().isEmpty()){
                filteredList.addAll(productosListAll);
            }else{
                for(int i = 0; i <productosListAll.size(); i++){
                    if(productosListAll.get(i).getNombre().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(productosListAll.get(i));
                    }
                }
/*
                for(String nombre : listaProductosAll){
                    if(nombre.toLowerCase().contains(constraint.toString().toLowerCase())){
                        listFilteredList.add(nombre);
                        filteredList.add(productosListAll));
                    }
                }*/
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            ////regresar el ArrayList
            return filterResults;
        }
//se ejecuta en el hilo de la interfaz grafica
        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
        productosLista.clear();
        productosLista.addAll((Collection<? extends Producto>) filterResults.values);
        notifyDataSetChanged();
        }
    };
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
    @Override //pasa los datos del arrayList de cada posicion a su poscion correspondiente
    public void onBindViewHolder(ViewHolder holder, int position) {
    // asigna los valores correcpondientes  a cada producto
        Producto producto = productosLista.get(position);
        holder.bindingProducto.setProducto(producto);
        holder.bindingProducto.executePendingBindings();
    }
    @Override
    public int getItemCount() {
    return productosLista.size();
    }
}

