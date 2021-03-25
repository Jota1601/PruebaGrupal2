package com.example.lvimagenes_2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

    public class Adaptador extends BaseAdapter {
        private Context context;
        private int layout;
        private ArrayList<Producto> productos;


        public Adaptador(Context context, int layout, ArrayList<Producto> productos){
            this.context = context;
            this.layout = layout;
            this.productos = productos;
        }

        @Override
        public int getCount() {
            return this.productos.size();
        }

        @Override
        public Object getItem(int position) {
            return this.productos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            String currentName;
            int currentImage;
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);

            v= layoutInflater.inflate(R.layout.activity_main, null);
            currentImage = productos.get(position).getImagen();
            currentName = productos.get(position).getMarca();

            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            TextView textView = (TextView) v.findViewById(R.id.textView);
            imageView.setImageResource(currentImage);
            textView.setText(currentName);
            return v;
        }
    }
