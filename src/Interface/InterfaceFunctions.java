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
import main.ListStorage;
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
     * initializes the data needed for ShowInvPage
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
     * initializes the data needed for NewOrderPage
     */
    public static void initNewOrderPage() {
        Graph graph = GlobalUI.getGraph();
        ObjectList storagesObject = graph.getStoragesByDFS();
        ListStorage storages = graph.getStorageList();
        String[] storagesName = graph.namenOnAString();
        GlobalUI.getNewOrderPage().getInvTextField().setText(buildStringTotalInv(storagesObject));

        for (String item : storagesName) {

            if (storages.getStorageByName(item).getInventory() != null) {
                GlobalUI.getNewOrderPage().getStorageComboBox().removeItem(item);
                GlobalUI.getNewOrderPage().getStorageComboBox().addItem(item);
            }

        }
    }

    /**
     * in NewOrderPage, updates the storages products in productComboBox
     *
     * @param storageName
     */
    public static void setAvailableProducts(String storageName) {
        GlobalUI.getNewOrderPage().getProductComboBox().removeAllItems();

        Graph graph = GlobalUI.getGraph();
        Storage selectedStorage = graph.getStorageList().getStorageByName(storageName);
        String[] productsNames = selectedStorage.getInventory().getInvStringArray();

        for (String item : productsNames) {
            GlobalUI.getNewOrderPage().getProductComboBox().addItem(item);
        }

    }

    /**
     * in NewOrderPage, updates the order texfield when the users adds a product
     * and its qty productComboBox
     *
     * @param currentOrder
     */
    public static void updateOrderDisplay(String currentOrder) {
        String qtyString = GlobalUI.getNewOrderPage().getProductQtyTextField().getText();
        if (isANumber(qtyString)) {
            String product = GlobalUI.getNewOrderPage().getProductComboBox().getSelectedItem().toString();
            currentOrder += product + ": " + qtyString + "\n";
            GlobalUI.getNewOrderPage().getOrderTextArea().setText(currentOrder);
        } else {
            JOptionPane.showMessageDialog(null, "Número de cantidad inválido, por favor intente de nuevo");
        }
    }

    /**
     * in NewOrderPage, resets every component used to build the newOrder
     *
     */
    public static void resetOrder() {
        GlobalUI.getNewOrderPage().getStorageComboBox().setEnabled(true);
        setAvailableProducts(GlobalUI.getNewOrderPage().getStorageComboBox().getSelectedItem().toString());
        GlobalUI.getNewOrderPage().getOrderTextArea().setText("");
    }

    /**
     * in NewOrderPage, Completes the order if the stock is available, if not,
     * starts searching products in other storages to build the newOrder
     *
     * @param order
     */
    public static void completeOrder(String order) {
        Graph graph = GlobalUI.getGraph();
        ListStorage storages = graph.getStorageList();
        Storage selectedStorage = storages.getStorageByName(GlobalUI.getNewOrderPage().getStorageComboBox().getSelectedItem().toString());
        String[] orderSplit = order.split("\n");

        boolean isStockAvailable = true;

        for (String productString : orderSplit) {
            String[] productAux = productString.split(":");
            String productName = productAux[0];
            int productQty = Integer.parseInt(productAux[1].replace(" ", ""));
            if (selectedStorage.getInventory().getProductByName(productName).getQuantity() < productQty) {
                isStockAvailable = false;
            }

        }

        if (isStockAvailable) {
            for (String productString : orderSplit) {
                String[] productAux = productString.split(":");
                String productName = productAux[0];
                int productQty = Integer.parseInt(productAux[1].replace(" ", ""));
                int originalQty = selectedStorage.getInventory().getProductByName(productName).getQuantity();
                selectedStorage.getInventory().getProductByName(productName).setQuantity(originalQty-productQty);

            }
            
            JOptionPane.showMessageDialog(null, "Pedido agregado con éxito");
            initNewOrderPage();
            resetOrder();

        } else {
            JOptionPane.showMessageDialog(null, "Trigger para pedir a otro almacén");
        }
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

            if (currentInv != null) {
                for (int i = 0; i < currentInv.getLength(); i++) {
                    Product currentProduct = currentInv.getElementInIndex(i);
                    msg += currentProduct.getName() + ": " + currentProduct.getQuantity() + "\n";
                }
            } else {
                msg += "Sin inventario\n";
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
     * Create a new matrix and copy the previous data from another one
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