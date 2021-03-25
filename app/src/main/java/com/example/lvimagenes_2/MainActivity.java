package com.example.lvimagenes_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list1;
    ImageView imageView;
    TextView textView;
    private ArrayList<Producto> listaproductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView) findViewById(R.id.list1);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);

        listaproductos = new ArrayList<Producto>();
        listaproductos.add(new Producto("NiKE", R.drawable.a1));
        listaproductos.add(new Producto("Adidas", R.drawable.a2));
        listaproductos.add(new Producto("Rebook", R.drawable.a3));
        listaproductos.add(new Producto("Puma", R.drawable.a4));
        listaproductos.add(new Producto("Sketcher", R.drawable.a5));


       /*   list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(listaproductos.get(position).getImagen());
                textView.setText(listaproductos.get(position).getMarca());
            }
        });

        Adaptador productAdapterAdapter = new Adaptador (this, R.layout.prod, listaproductos);
        list1.setAdapter(productAdapterAdapter);

*/

        AdaptadorPersonas adp = new AdaptadorPersonas(this);
        ListView lv1 = findViewById(R.id.list1);
        lv1.setAdapter(adp);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, listaproductos.get(i).getMarca(), Toast.LENGTH_LONG).show();
            }
        });

    }

    class AdaptadorPersonas extends ArrayAdapter<Producto> {

        AppCompatActivity appCompatActivity;

        AdaptadorPersonas(AppCompatActivity context) {
            super(context, R.layout.prod, listaproductos);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.prod, null);

            ImageView imageView1 = item.findViewById(R.id.imageView);
            TextView textView1 = item.findViewById(R.id.textView);

            imageView1.setImageResource(listaproductos.get(position).getImagen());

            textView1.setText(listaproductos.get(position).getMarca());
            return (item);
        }

    }

    public void r(View view) {

        //Intent intent = new Intent(this, CrudActivity.class);
        //startActivity(intent);

        Intent numbersIntent = new Intent(MainActivity.this, CrudActivity.class);
        startActivity(numbersIntent);
    }
}
      /*      TextView textView1 = item.findViewById(R.id.textView);
            textView1.setText(listapersonas.get(position).getNombre());

            ImageView imageView1 = item.findViewById(R.id.imageView);
            imageView1.setImageResource(R.drawable.hombre);





            if (listapersonas.get(position).getGenero()=='m')

            else
                imageView1.setImageResource(R.drawable.mujer);
            return(item);

            */