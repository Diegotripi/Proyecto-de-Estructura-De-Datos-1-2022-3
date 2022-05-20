/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JOptionPane;
import main.AdjMatrixGraph;
import main.Graph;
import main.ListInv;
import main.ObjectList;
import main.ObjectNode;
import main.Product;
import main.Storage;

/**
 *
 * @author isaac
 */
public class InterfaceFunctions {

    /**
     * initializates the data needed for ShowInvPage
     *
     */
    public static void initShowInvPage() {

        Graph graph = GlobalUI.getGraph();

        ObjectList storagesDFS = graph.getStoragesByDFS();
        ObjectList storagesBFS = graph.getStoragesByBFS();

        GlobalUI.getShowInvPage().getTextFieldDFS().setText(buildStringTotalInv(storagesDFS));
        GlobalUI.getShowInvPage().getTextFieldBFS().setText(buildStringTotalInv(storagesBFS));

    }

    /**
     *
     * From a NodeStorage list, build the string containing all of the inventory
     * in storages
     *
     * @param nodeStorageList
     * @return String
     */
    public static String buildStringTotalInv(ObjectList nodeStorageList) {
        String msg = "";
        ObjectNode pointer = nodeStorageList.getHead();

        while (pointer != null) {
            Storage currentStorage = (Storage) pointer.getElement();
            msg += currentStorage.getName() + ":\n";
            ListInv currentInv = currentStorage.getInventory();

            for (int i = 0; i < currentInv.getLenght(); i++) {
                Product currentProduct = currentInv.getElementInIndex(i);
                msg += currentProduct.getName() + ": " + currentProduct.getQuantity() + "\n";
            }
            msg += "\n";

            pointer = pointer.getNext();
        }

        return msg;

    }

    /**
     *
     * @param a
     * @param b
     * @return boolean
     */
    public static boolean areTheSame(String a, String b) {
        return a.equalsIgnoreCase(b);
    }

    /**
     *
     * @param number
     * @return boolean
     */
    public static boolean isANumber(String number) {
        try {
            int num = Integer.parseInt(number);
            return true;

        } catch (NumberFormatException e) {

        }
        return false;
    }

    /**
     *
     * @param array
     * @return boolean
     */
    public static boolean isAStorage(String[] array) {
        return array[0].equals("Almacen");

    }

    /**
     *
     * @param name
     * @return boolean
     */
    public static boolean alreadyExistStorage(String name) {
        for (int i = 0; i < GlobalUI.getGraph().getCounter(); i++) {
            if (GlobalUI.getGraph().getStorageList().getStorageNodeByIndex(i).getStorage().getName().equalsIgnoreCase(name)) {
                return true;
            }

        }
        return false;

    }

    /**
     * Validate and create the new storage
     *
     * @param transmitter
     * @param receiver
     * @param receiverCost
     * @param transmitterCost
     * @param nameArray
     * @param name
     */
    public static void createStorageButton(String transmitter, String receiver, String receiverCost, String transmitterCost, String[] nameArray, String name) {
        if (InterfaceFunctions.areTheSame(transmitter, receiver)) {
            JOptionPane.showMessageDialog(null, "No se puede ingresar el mismo almacén receptor y emisor en las rutas");
        } else {
            if (!InterfaceFunctions.isANumber(transmitterCost) || !InterfaceFunctions.isANumber(receiverCost)) {
                JOptionPane.showMessageDialog(null, "Debe ingresar las distancias con números");
            } else {
                if (!InterfaceFunctions.isAStorage(nameArray)) {
                    JOptionPane.showMessageDialog(null, "El nombre del almacén debe de empezar con 'Almacén'");

                } else {
                    if (InterfaceFunctions.alreadyExistStorage(name)) {
                        JOptionPane.showMessageDialog(null, "Ya existe el almacén");
                    } else {
                        GlobalUI.getGraph().insertNewStorage(name);
                        createNewMatrixWithAnother(GlobalUI.getGraph().getAdjMatrix(), GlobalUI.getGraph().getCounter());
                        GlobalUI.getGraph().getAdjMatrix().addEdge(GlobalUI.getGraph().getStorageNumberWithName(transmitter), GlobalUI.getGraph().getCounter() - 1, Integer.parseInt(transmitterCost));
                        GlobalUI.getGraph().getAdjMatrix().addEdge(GlobalUI.getGraph().getCounter() - 1, GlobalUI.getGraph().getStorageNumberWithName(receiver), Integer.parseInt(receiverCost));
                        //GlobalUI.getGraph().getAdjMatrix().printMatrix();
                        JOptionPane.showMessageDialog(null, "Almacén creado con éxito");
                    }
                }
            }
        }

    }

    /**
     * Create a new matrix and copy the previos data from another one
     *
     * @param am
     * @param v
     */
    public static void createNewMatrixWithAnother(AdjMatrixGraph am, int v) {
        AdjMatrixGraph newMatrix = new AdjMatrixGraph(v);
        for (int j = 0; j < am.getNumVertices(); j++) {
            System.arraycopy(am.getMatrix()[j], 0, newMatrix.getMatrix()[j], 0, am.getNumVertices());

        }

        GlobalUI.getGraph().setMatrix(newMatrix);

    }

}
