/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class Graph {

    private AdjMatrixGraph matrix;
    private ListaAlmacen almacen;
    private int contador;

    public Graph(AdjMatrixGraph matrix) {
        this.matrix = matrix;
        this.almacen = null;
    }

    public AdjMatrixGraph getMatrix() {
        return matrix;
    }

    public ListaAlmacen getAlmacen() {
        return almacen;
    }

    public void setMatrix(AdjMatrixGraph matrix) {
        this.matrix = matrix;
    }

    public void setAlmacen(ListaAlmacen almacen) {
        this.almacen = almacen;
    }

    public void obtenerInventario(int n) {
        almacen.obtenerIndice(n).getElemento().getInventario().imprimirInventario();
    }

    public void nombreAlmacen(int n) {
        System.out.println("\n" + almacen.obtenerIndice(n).getElemento().getNombre());
    }

    public void almacen(ListaInv i, String n) {
        Almacen a = new Almacen(i, n);
        if (almacen.getLargo() == 0) {
            almacen.insertarCabeza(a);
        }else{
            almacen.insertarFinal(a);
        }
        
        contador++;
    }

    public Producto producto(String nombre, int can) {
        Producto p1 = new Producto(can, nombre);
        return p1;
    }

    public int buscarNumeroAlmacen(String letra) {
        int num = 0;
        for (int i = 0; i < almacen.getLargo(); i++) {
            String ultimaLetra = almacen.obtenerIndice(i).getElemento().getNombre().substring(almacen.obtenerIndice(i).getElemento().getNombre().length() - 1);
            if (letra.equalsIgnoreCase(ultimaLetra)) {
                num = i;
                break;
            }
        }

        return num;
    }

    public void agregarNuevoAlmacen(String nombre) {

    }

}
