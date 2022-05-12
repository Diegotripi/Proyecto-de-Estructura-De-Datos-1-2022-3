/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class NodoAlmacen {
    
    private Almacen almacen;
    private NodoAlmacen siguiente;

    public NodoAlmacen(Almacen almacen) {
        this.almacen = almacen;
        this.siguiente = null;
    }

    public Almacen getElemento() {
        return almacen;
    }

    public NodoAlmacen getSiguiente() {
        return siguiente;
    }

    public void setElemento(Almacen elemento) {
        this.almacen = almacen;
    }

    public void setSiguiente(NodoAlmacen siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
