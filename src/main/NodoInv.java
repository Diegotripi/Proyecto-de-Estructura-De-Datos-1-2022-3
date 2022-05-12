/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class NodoInv {
    
    private Producto elemento;
    private NodoInv siguiente;

    public NodoInv(Producto elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }

    public Producto getElemento() {
        return elemento;
    }

    public NodoInv getSiguiente() {
        return siguiente;
    }

    public void setElemento(Producto elemento) {
        this.elemento = elemento;
    }

    public void setSiguiente(NodoInv siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
