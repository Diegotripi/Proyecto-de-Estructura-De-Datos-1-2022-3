/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.Scanner;

public class AdjMatrixGraph {
    
    Scanner sc = new Scanner(System.in);
    private int numVertices;
    private int matrix [][];
    
    
    
    public AdjMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        matrix = new int[numVertices][numVertices];    
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public void addedge(int origen, int destino, int costo){
        matrix[origen][destino] = costo;       
    }
    
    public void printGraph(){
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public void obtenerEdge(){
        int origen =0;
        int destino=1;
        int costo = 1;
        
        for (int i = 0; i < numVertices; i++) {
            addedge(origen,destino,costo);
            origen +=1;
            if(origen == (numVertices-1)){
                destino = 0;
            }else{
              destino+=1;  
            }
            costo+=2;
        }
    }
    
    public void armarMatriz(){
        boolean aux = true;
        int origen;
        int destino;
        int costo;
        String opcion;
        
        while(aux){
            System.out.println("Ingrese vertice origen: ");
            origen = sc.nextInt();
            System.out.println("Ingrese vertice destino: ");
            destino = sc.nextInt();
            System.out.println("Ingrese el costo: ");
            costo = sc.nextInt();
            addedge(origen,destino,costo);
            System.out.println("Desea introducir una nueva arista (s/n): ");
            opcion = sc.nextLine();
            if (opcion.equalsIgnoreCase("s")) {
                aux = true;
            }else{
                aux = false;
            }
        }
    }
    
    
    
    
    
}
