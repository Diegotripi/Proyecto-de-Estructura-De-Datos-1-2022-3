/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Interface.GlobalUI;

/**
 *
 * @author mdetd
 */
public class Application {

    /**
     * Main app method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initializeApp();
        GlobalUI.openMainPage();

    }

    /**
     * Starts the data flow for the proyect
     */
    public static void initializeApp() {

        int v = 0;
        String direccion = "src\\Direccion Archivo\\Almacenes.txt";
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
