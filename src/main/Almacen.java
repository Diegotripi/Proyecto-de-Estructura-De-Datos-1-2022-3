/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class Almacen {
    
    private ListaInv inventario;
    private String nombre;

    public Almacen(ListaInv inventario, String nombre) {
        this.inventario = inventario;
        this.nombre = nombre;
    }

    public ListaInv getInventario() {
        return inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setInventario(ListaInv inventario) {
        this.inventario = inventario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
