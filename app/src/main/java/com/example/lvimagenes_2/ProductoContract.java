package com.example.lvimagenes_2;

import android.provider.BaseColumns;

public class ProductoContract {

    public static abstract class ProductoEntry implements BaseColumns {

        public static final String TABLE_NAME ="productos";
        public static final String IMAGEN = "IMAGEN";
        public static final String MARCA= "MARCA";

    }
}

