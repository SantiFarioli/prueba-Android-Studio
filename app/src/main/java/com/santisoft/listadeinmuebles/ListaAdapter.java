package com.santisoft.listadeinmuebles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.santisoft.listadeinmuebles.modelo.Inmueble;

import java.util.List;

public class ListaAdapter extends ArrayAdapter {
    /*Creamos 3 Variables:
    una que guarda el contexto, otra la lista de Inmuebles
    y otra LayoutInflater
     */
    private Context context;
    private List<Inmueble> lista;
    private LayoutInflater li;

    // Inflamos la vista de item con LayoutInflater
    public ListaAdapter(@NonNull Context context, int resource, @NonNull List<Inmueble> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }


    /*Sobrescribimos el metodo getView(), que es el metodo que se va ejecutar por cada elemento de la lista que yo le pase,
    si yo paso 5 inmuebles, este metodo se ejecutaria 5 veces. Este metodo recibe el indice del elemento que estoy recorriendo dentro de esa lista,
    la vista en si, en este caso (item) y el contenedor padre que en este caso es el ListView.
    */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // creamos un objeto (itemView) ya que el metodo getView devuelve un view
        View itemView = convertView;
        if (itemView == null) {
            itemView = li.inflate(R.layout.item,parent,false);
        }
        // Creamos un Inmueble
        Inmueble inmueble = lista.get(position);
        //Recuperamos los elementos
        //A la foto le seteamos la imagen y le pasamos el id del ImageView que quiero que se inizialice
        ImageView foto = itemView.findViewById(R.id.ivFoto);
        foto.setImageResource(inmueble.getFoto());

        //Recuperamos los elementos
        //A la direccion le seteamos el texto y le pasamos el id del TextView que quiero que se inizialice
        TextView direccion = itemView.findViewById(R.id.tvdireccion);
        direccion.setText(inmueble.getDireccion());

        //Recuperamos los elementos
        //Al precio le seteamos el texto y le pasamos el id del TextView que quiero que se inizialice
        TextView precio = itemView.findViewById(R.id.tvPrecio);
        precio.setText(inmueble.getPrecio() +"");

        //retornamos la vista
        return itemView;

    }
}
