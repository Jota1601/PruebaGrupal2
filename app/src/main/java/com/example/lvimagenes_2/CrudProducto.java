package com.example.lvimagenes_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CrudProducto {
    private BaseDeDatos Bdatos;
    private SQLiteDatabase db;
    private ContentValues values = new ContentValues();

    public CrudProducto(Context context) {
        Bdatos = new BaseDeDatos(context);
    }

    public CrudProducto() {

    }

    public void insertar(Producto n) {
        db = Bdatos.getWritableDatabase();
        values.clear();
        values.put(ProductoContract.ProductoEntry.IMAGEN, n.getImagen());
        values.put(ProductoContract.ProductoEntry.MARCA, n.getMarca());
        db.insert(ProductoContract.ProductoEntry.TABLE_NAME, null, values);
        //  db.close();
    }

    public void editar(Producto n) {
        db = Bdatos.getWritableDatabase();
        values.clear();
        values.put(ProductoContract.ProductoEntry.IMAGEN, n.getImagen());
        values.put(ProductoContract.ProductoEntry.MARCA, n.getMarca());
        //db.update(ProductoContract.ProductoEntry.TABLE_NAME, "MARCA=?", new String[]{String.valueOf(n.getMarca())});
        //  db.update(ProductoContract.ProductoEntry.TABLE_NAME, values, new String[]{ProductoContract.ProductoEntry.MARCA});
        // db.update(ProductoContract.ProductoEntry.TABLE_NAME, values, ProductoContract.ProductoEntry.MARCA + "=" + n.getMarca(), null);
        String[] args = new String[]{n.getMarca()};
        db.update(ProductoContract.ProductoEntry.TABLE_NAME, values, ProductoContract.ProductoEntry.MARCA + "=?", args);
        // db.close();
    }

    public void borrar(String n) {
        db = Bdatos.getWritableDatabase();
        //  values.clear();
        //    values.put(ProductoContract.ProductoEntry.COLOR, n.getColor());
        //   values.put(ProductoContract.ProductoEntry.TALLA, n.getTalla());
        //  values.put(ProductoContract.ProductoEntry.MARCA, n.getMarca());
        //db.update(ProductoContract.ProductoEntry.TABLE_NAME, "MARCA=?", new String[]{String.valueOf(n.getMarca())});
        //  db.update(ProductoContract.ProductoEntry.TABLE_NAME, values, new String[]{ProductoContract.ProductoEntry.MARCA});
        // db.update(ProductoContract.ProductoEntry.TABLE_NAME, values, ProductoContract.ProductoEntry.MARCA + "=" + n.getMarca(), null);
        String[] args1 = new String[]{n};
        db.delete(ProductoContract.ProductoEntry.TABLE_NAME, ProductoContract.ProductoEntry.MARCA + "=?", args1);
        //   db.close();


    }

    public ArrayList<Producto> ListaProducto() {
        ArrayList<Producto> ListaProducto = new ArrayList<>();
        db =Bdatos.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from " + ProductoContract.ProductoEntry.TABLE_NAME, null);

        while (cursor.moveToNext()) {
            Producto m = new Producto (cursor.getString(0),
                    cursor.getInt(1));

            ListaProducto.add(m);
        }
        db.close();
        return ListaProducto;

    }
}





