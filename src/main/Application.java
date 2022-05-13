/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        int v = 0;
        String direccion = "C:\\Users\\mdetd\\Documents\\NetBeansProjects\\Proyecto-de-Estructura-De-Datos-1-2022-3\\src\\Direccion Archivo\\Almacenes.txt"; //Se debe colocar mientras la direccion a mano
        File a = new File();
        String arInfo = a.readFile(direccion);
        
        v = a.numVertices(arInfo);
        AdjMatrixGraph am = new AdjMatrixGraph(v);

        /*
        La funcion extraer se configuro tal que si son mas o menos almacenes esta lo detecte
        Puede hacerse mas eficiente
         */
        Graph g1 = a.getInfo(arInfo, am);

//      Probar como se imprime la matriz
        g1.getMatrix().printGraph();

//        Probar la impresion de los almacenes y sus inventarios
        g1.nameStorage(0);
        g1.getInventory(0);
        g1.nameStorage(1);
        g1.getInventory(1);
        g1.nameStorage(2);
        g1.getInventory(2);
        g1.nameStorage(3);
        g1.getInventory(3);
        g1.nameStorage(4);
        g1.getInventory(4);
        g1.nameStorage(5);
        g1.getInventory(5);
    }

   

    
}
