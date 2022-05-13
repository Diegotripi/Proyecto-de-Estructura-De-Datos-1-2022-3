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
    
    
    
    /**
     * Constructor Method
     * @param numVertices 
     */ 
    public AdjMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        matrix = new int[numVertices][numVertices];    
    }
    
    /**
     * Getter Method
     * @return numVertices
     */

    public int getNumVertices() {
        return numVertices;
    }
    
    /**
     * Getter Method
     * @return matrix
     */

    public int[][] getMatrix() {
        return matrix;
    }
    
    /**
     * Setter Method
     * @param numVertices 
     */

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }
    
    /**
     * Setter Method
     * @param matrix 
     */

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    /**
     * Add a new edge in the graph
     * @param from 
     * @param to
     * @param cost
     */
    
    public void addEdge(int from, int to, int cost){
        matrix[from][to] = cost;       
    }
    
    /**
     * Print graph
     */
    
    public void printGraph(){
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    /**
     * Gett Edges of the graph
     */
    
    public void getEdge(){
        int origen =0;
        int destino=1;
        int costo = 1;
        
        for (int i = 0; i < numVertices; i++) {
            addEdge(origen,destino,costo);
            origen +=1;
            if(origen == (numVertices-1)){
                destino = 0;
            }else{
              destino+=1;  
            }
            costo+=2;
        }
    }
    
    
    
    
    
}
