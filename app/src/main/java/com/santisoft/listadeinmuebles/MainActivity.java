package com.santisoft.listadeinmuebles;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.santisoft.listadeinmuebles.modelo.Inmueble;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Creamos un Array que es la lista que le vamos a pasa al Adapter
    private ArrayList<Inmueble> lista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarDatos();
        generarListView();
    }

    //Creamos otro metodo que se va encargar de generar el ListView
    public void generarListView() {
        //creamos (instanciamos) un adaptador de la Lista
        ArrayAdapter<Inmueble> adapter = new ListaAdapter(this,R.layout.item,lista,getLayoutInflater());
        //Creamos una variable para recuperar el ListView
        ListView lv = findViewById(R.id.milista);
        lv.setAdapter(adapter);
    }

    //Creamos un metodo que se va encargar de meter los datos(Inmuebles) a la vista
    public void cargarDatos() {
        lista.add(new Inmueble(R.drawable.casa, "San Martin 375487", 1.4564));
        lista.add(new Inmueble(R.drawable.csa,"Bolivar 245459", 20000));
        lista.add(new Inmueble(R.drawable.casita,"Potrero 456725", 90000));
    }

}