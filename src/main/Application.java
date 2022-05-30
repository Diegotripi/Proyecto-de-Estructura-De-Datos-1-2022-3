/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Interface.GlobalUI;
import javax.swing.JOptionPane;

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

        int v;
        // remember at the end to change the file to their original values 
        String direccion = "src\\Direccion Archivo\\amazon.txt";
        GlobalUI.setDirection(direccion);
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

    }

    /**
     * Sets the graph info using the txt given by user
     *
     * @param path
     */
    public static void initializeAppWithNewInfo(String path) {
        int v;
        String direccion = path;

        File dataFile = new File();
        String arInfo = dataFile.readFile(direccion);

        if (!(arInfo.contains("Almacenes") && arInfo.contains("Rutas"))) {
            JOptionPane.showMessageDialog(null, "Alerta, el documento dado no contiene el formato correspondiente, por favor intentar de nuevo", "Alerta", 2);
        } else {
            v = dataFile.numVertices(arInfo);

            if (v == -1) {
                JOptionPane.showMessageDialog(null, "Alerta, el documento dado no contiene el formato correspondiente, por favor intentar de nuevo", "Alerta", 2);

            } else {
                AdjMatrixGraph am = new AdjMatrixGraph(v);

                Graph g1 = dataFile.getInfo(arInfo, am);
                if (g1 != null) {
                    GlobalUI.setDirection(direccion);
                    GlobalUI.setGraph(g1);
                    JOptionPane.showMessageDialog(null, "Proceso exitoso, los datos han sido cargados", "Éxito", 1);

                } else {
                    JOptionPane.showMessageDialog(null, "Alerta, el documento dado no contiene el formato correspondiente, por favor intentar de nuevo", "Alerta", 2);

                }
            }
        }

    }

}
