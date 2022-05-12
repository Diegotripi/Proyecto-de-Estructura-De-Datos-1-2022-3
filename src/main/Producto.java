/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class Producto {
    
    private String Nombre;
    private int Cantidad;

    public Producto(int Cantidad, String Nombre) {
        this.Cantidad = Cantidad;
        this.Nombre = Nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
}
