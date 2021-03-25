package com.example.lvimagenes_2;

public class Producto {
    private String marca;
    private int imagen;

    public Producto() {
    }

    public Producto(String marca, int imagen) {
        this.marca = marca;
        this.imagen = imagen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}