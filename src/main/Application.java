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
//        for (int i = 0; i < GlobalUI.getGraph().getCounter(); i++) {
//            System.out.println(GlobalUI.getGraph().namenOnAString()[i]);
//            
//        }
        GlobalUI.openMainPage();


    }



    /**
     * Starts the data flow for the proyect
     */
    public static void initializeApp() {

        int v = 0;
        // remember at the end to change the file to their original values 
        String direccion = "src\\Direccion Archivo\\Almacenes.txt";
        File dataFile = new File();
        String arInfo = dataFile.readFile(direccion);

        v = dataFile.numVertices(arInfo);
        AdjMatrixGraph am = new AdjMatrixGraph(v);

        /*
        La funcion extraer se configuro tal que si son mas o menos almacenes esta lo detecte
        Puede hacerse mas eficiente
         */
        Graph g1 = dataFile.getInfo(arInfo, am);
        GlobalUI.setGraph(g1);

//      Probar como se imprime la matriz
//        g1.getAdjMatrix().printMatrix();
//        Probar la impresion de los almacenes y sus inventarios
//        g1.printStorageName(0);
//        g1.printInventory(0);
//        g1.printStorageName(1);
//        g1.printInventory(1);
//        g1.printStorageName(2);
//        g1.printInventory(2);
//        g1.printStorageName(3);
//        g1.printInventory(3);
//        g1.printStorageName(4);
//        g1.printInventory(4);
//        g1.printStorageName(5);
//        g1.printInventory(5);
    }

}
