package com.example.menusdenavegacion.ui.vender;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.menusdenavegacion.Producto;
import com.example.menusdenavegacion.ProductoListFragment;
import com.example.menusdenavegacion.R;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class ProductoVerderActivity extends AppCompatActivity {
    public static boolean  seCreoProducto = false;
    private final String CARPETA_RAIZ="misImagenesPrueba/";
    private final String RUTA_IMAGEN= CARPETA_RAIZ+"misFotos";

    final int COD_SELECCIONADA = 10;
    final int COD_FOTO = 20;
    ImageView imagen;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verder_producto);
        imagen = (ImageView) findViewById(R.id.imageView_vender);
    }

    public void onclick(View view) {
        cargarImagen();
    }

    private void cargarImagen() {

        final CharSequence[] opciones = {"Tomar foto", "Cargar Imagen", "Cancelar"};
        final AlertDialog.Builder alertOpciones =  new AlertDialog.Builder(ProductoVerderActivity.this);
        alertOpciones.setTitle("Seleciones una Opcion");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(opciones[i].equals("Tomar foto")){
                    Toast.makeText(getApplication(), "TOMAR FOTO", Toast.LENGTH_SHORT).show();
                    tomarFotografia();
                }else{
                    if(opciones[i].equals("Cargar Imagen")){
                        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent, "Selecione la aplicación "),COD_SELECCIONADA);
                    }else{
                         dialog.dismiss();
                    }
                }
            }
        });
        alertOpciones.show();
    }
    private void tomarFotografia() {
    File fileImagen= new File (Environment.getExternalStorageDirectory(), RUTA_IMAGEN);// busca y abre la imagen
    boolean isCreada = fileImagen.exists();//indica si existe
        String nombreImagen = "";
        if(isCreada == false){
            isCreada = fileImagen.mkdir();
        }
        if(isCreada == true){
            nombreImagen = (System.currentTimeMillis()/100)+".jpg";
        }
        path= Environment.getExternalStorageDirectory()+File.separator+RUTA_IMAGEN+File.separator+nombreImagen;
        File imagef= new File(path);
        //lanzar la aplicacion de  camara
        Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagef));
        startActivityForResult(intent, COD_FOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case COD_SELECCIONADA:
                    Uri miPath = data.getData();
                    imagen.setImageURI(miPath);
                    break;
                case COD_FOTO:
                    MediaScannerConnection.scanFile(this,new String []{path},null,
                        new MediaScannerConnection.OnScanCompletedListener() {
                            @Override
                            public void onScanCompleted(String path, Uri uri) {
                                Log.i("Ruta de almacenamiento","Path: "+path);
                            }
                        });
                    Bitmap bitmap  = BitmapFactory.decodeFile(path);
                    imagen.setImageBitmap(bitmap);
                    break;
            }

        }
    }
    public void publicarProducto(View view) {
        //nombreProducto = (EditText) findViewById(R.id.textview_nombre_producto_detail);
        TextView nombreVender = (EditText) findViewById(R.id.textview_nombre_producto_vender);
        TextView propietarioVender = (EditText) findViewById(R.id.textview_propietario_vender);
        TextView telefonoVender = (EditText) findViewById(R.id.telefono_verder);
        TextView precioVender = (EditText) findViewById(R.id.button_precio_vender);

        String varNombre = nombreVender.getText().toString();
        String varPropietario = propietarioVender.getText().toString();
        ImageView varImagen =(ImageView) findViewById(R.id.imageView_vender);
        String varTelefono = telefonoVender.getText().toString();
        String varPrecio = precioVender.getText().toString();
        double varPrecioDouble = Double.parseDouble(varPrecio);

        Date now = Calendar.getInstance().getTime(); // para obtener  la hora actual
        ProductoListFragment.ListaProductos.add(new Producto("5",now,varNombre,null ,varPrecioDouble,varPropietario,varTelefono,
                "https://scontent-scl2-1.xx.fbcdn.net/v/t1.0-9/104267209_2474372596207898_7160444479821226596_n.jpg?_nc_cat=101&_nc_sid=e007fa&_nc_eui2=AeFhQtJfrYjoz7n0F6uXwzkcLRRgC1utd8YtFGALW613xhpa8oak2PjBurwCTWUMwAsPpYfAqY5WGnlxP30AqTJj&_nc_ohc=gAY7hGUfKgcAX87KbxY&_nc_ht=scontent-scl2-1.xx&oh=ff45d94ac50c76d0e7fc0de27ac93adc&oe=5F128847",1));
        Toast.makeText(getApplicationContext(), "Se ha publicado  su producto con ¡Exito!, los usuarios podran verlo  en la lista de productos y comprarlo.", Toast.LENGTH_LONG).show();
    }
}
