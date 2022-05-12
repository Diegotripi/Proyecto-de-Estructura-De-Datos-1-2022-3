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
    private Almacen[] almacen;
    private int contador;

    public Graph(AdjMatrixGraph matrix) {
        this.matrix = matrix;
        this.almacen = new Almacen[this.matrix.getNumVertices()];
    }

    public AdjMatrixGraph getMatrix() {
        return matrix;
    }

    public Almacen[] getAlmacen() {
        return almacen;
    }

    public void setMatrix(AdjMatrixGraph matrix) {
        this.matrix = matrix;
    }

    public void setAlmacen(Almacen[] almacen) {
        this.almacen = almacen;
    }
    
    public void obtenerInventario(int vertice){
        almacen[vertice].getInventario().imprimirInventario();
    }
    
    public void nombreAlmacen(int vertice){
        System.out.println("\n"+almacen[vertice].getNombre());
    }
    
    
    public void almacen(ListaInv i, String n){
        Almacen a = new Almacen(i,n);
        almacen[contador] = a;
        contador ++;
    }
    
    public Producto producto(String nombre, int can){
        Producto p1 = new Producto(can, nombre);
        return p1;
    }
    
    public int buscarNumeroAlmacen(String letra){
        int num = 0;
        for (int i = 0; i < almacen.length; i++) {
            String ultimaLetra = almacen[i].getNombre().substring(almacen[i].getNombre().length() - 1); 
            if(letra.equalsIgnoreCase(ultimaLetra)){
                num = i;
                break;
            }
        }
        
        return num;
    }
    
    
    
}
