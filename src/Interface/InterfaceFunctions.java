/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.io.File;
import javax.swing.JOptionPane;
import main.AdjMatrixGraph;
import main.Application;
import main.Graph;
import main.ListInv;
import main.ListStorage;
import main.NodeStorage;
import main.ObjectList;
import main.ObjectNode;
import main.Product;
import main.Storage;
import org.graphstream.graph.Edge;

import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;

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
     * @param storageName
     */
    public static void completeOrder(String order, String storageName) {
        Graph graph = GlobalUI.getGraph();
        ListStorage storages = graph.getStorageList();
        Storage selectedStorage = storages.getStorageByName(storageName);
        String[] orderSplit = order.split("\n");

        boolean isStockAvailable = true;
        ListInv missingStock = new ListInv();

        for (String productString : orderSplit) {
            String[] productAux = productString.split(":");
            String productName = productAux[0];
            int productQty = Integer.parseInt(productAux[1].replace(" ", ""));
            int currentStock = selectedStorage.getInventory().getProductByName(productName).getQuantity();

            if (currentStock < productQty) {
                isStockAvailable = false;
                Product missingProduct = new Product((productQty - currentStock), productName);
                missingStock.addEnd(missingProduct);
            }

        }

        if (isStockAvailable) {
            for (String productString : orderSplit) {
                String[] productAux = productString.split(":");
                String productName = productAux[0];
                int productQty = Integer.parseInt(productAux[1].replace(" ", ""));
                int originalQty = selectedStorage.getInventory().getProductByName(productName).getQuantity();
                selectedStorage.getInventory().getProductByName(productName).setQuantity(originalQty - productQty);

            }

            JOptionPane.showMessageDialog(null, "Pedido agregado con éxito");
            initNewOrderPage();
            resetOrder();

        } else {

//            missingStock.printInventory();
            for (String orderString : orderSplit) {
                String productName = orderString.split(":")[0];

                if (missingStock.getProductByName(productName) != null) {
                    selectedStorage.getInventory().getProductByName(productName).setQuantity(0);
                } else {
                    int qtyToReduce = Integer.parseInt(orderString.split(":")[1].replace(" ", ""));
                    Product productToReduce = selectedStorage.getInventory().getProductByName(productName);
                    productToReduce.setQuantity(productToReduce.getQuantity() - qtyToReduce);
                }
            }

            askStockInOtherStorage(missingStock, storageName);
        }
    }

    /**
     *
     * Finds the missing stock in other storages, evaluates the shortest route,
     * updates the inventory and notifies the user in storages
     *
     * @param missingStock
     * @param originalStorage
     */
    public static void askStockInOtherStorage(ListInv missingStock, String originalStorage) {
        ListStorage storageWithStock = new ListStorage();
        ListStorage allStorages = GlobalUI.getGraph().getStorageList();

        // get storages that can provide the stock
        for (int i = 0; i < allStorages.getLength(); i++) {

            if (!allStorages.getStorageNodeByIndex(i).getStorage().getName().equals(originalStorage)) {
                boolean isStockAvailable = true;
                ListInv currentInv = allStorages.getStorageNodeByIndex(i).getStorage().getInventory();

                for (int j = 0; j < missingStock.getLength(); j++) {
                    Product currentMissingProduct = missingStock.getElementInIndex(j);
                    Product productInStorage = currentInv.getProductByName(currentMissingProduct.getName());
                    if (productInStorage == null) {
                        isStockAvailable = false;
                        break;
                    } else if (productInStorage.getQuantity() < currentMissingProduct.getQuantity()) {
                        isStockAvailable = false;
                        break;
                    }

                }

                if (isStockAvailable) {
                    storageWithStock.addEnd(allStorages.getStorageNodeByIndex(i).getStorage());
                }
            }

        }

        if (storageWithStock.getLength() <= 0) {
            JOptionPane.showMessageDialog(null, "Alerta no existe la cantidad de stock especificada en ninguno de los almacenes de la red");
        } else {
            String shortestRoute = getShortestRoute(storageWithStock, originalStorage);
            String[] shortestRouteSplit = shortestRoute.split(";");
            Storage storageToGiveProducts = allStorages.getStorageByName(shortestRouteSplit[1].split(",")[0]);
            String userReport = "El pedido tiene los siguientes productos faltantes de stock:\n";

            for (int i = 0; i < missingStock.getLength(); i++) {
                Product productToReduce = storageToGiveProducts.getInventory().getProductByName(missingStock.getElementInIndex(i).getName());
                productToReduce.setQuantity(productToReduce.getQuantity() - missingStock.getElementInIndex(i).getQuantity());

                userReport += "- " + missingStock.getElementInIndex(i).getName() + ": " + missingStock.getElementInIndex(i).getQuantity() + "\n";
            }
            //report to user
            userReport += "Así que se solicitaron los productos a: " + storageToGiveProducts.getName() + "\n";
            userReport += "Siguiendo la ruta más corta " + "(" + shortestRouteSplit[0] + "Km)" + ": ";
            userReport += shortestRouteSplit[1].replace(",", " --> ");

            JOptionPane.showMessageDialog(null, userReport);
            createShortestRouteGraph(shortestRouteSplit[1]);

            initNewOrderPage();
            resetOrder();

        }

    }

    /**
     *
     * Creates and show the shortest route corresponding graph
     *
     * @param route
     */
    public static void createShortestRouteGraph(String route) {
        MultiGraph multiGraph = new MultiGraph("GraphMap");
        Graph originalGraph = GlobalUI.getGraph();
        AdjMatrixGraph adjMatrix = originalGraph.getAdjMatrix();
        ListStorage storages = originalGraph.getStorageList();
        String[] routeSplit = route.split(",");

        for (String storage : routeSplit) {
            System.out.println(storage);
            Node n = multiGraph.addNode(storage);
            n.setAttribute("ui.label", storage);
        }

        int forAux;
        if (routeSplit.length <= 2) {
            forAux = 1;
        } else {
            forAux = routeSplit.length - 1;
        }

        for (int i = 0; i < forAux; i++) {
            String emitter = routeSplit[i];
            String receiver = routeSplit[i + 1];
            int emitterIndex = storages.getIndexByElement(emitter);
            int receiverIndex = storages.getIndexByElement(receiver);
            String routeValue = String.valueOf(adjMatrix.getMatrix()[emitterIndex][receiverIndex]);
            //multiGraph.addEdge(edgeName, storage1, storage2, true);
            String edgeId = emitter + "-" + receiver;
            Edge ed = multiGraph.addEdge(edgeId, emitter, receiver, true);

            ed.setAttribute("ui.label", routeValue);

        }

        String graphCss = "node { text-offset: 0px, -10px; size: 20px; text-size: 12; fill-color: blue, aquamarine; fill-mode: gradient-horizontal; text-alignment: above; text-color: #222; text-background-mode: plain; text-background-color: white; } edge { size: 2px; fill-color: #444; text-alignment: above; text-size: 20; arrow-size: 12; text-color: blue; text-offset: 10px, -20px;}";
        multiGraph.setAttribute("ui.stylesheet", graphCss);

        System.setProperty("org.graphstream.ui", "swing");

        Viewer viewer = multiGraph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }

    /**
     *
     * Gets shortest route using Dijkstra
     *
     *
     * @param storagesWithStock
     * @param originalStorage
     * @return string
     */
    public static String getShortestRoute(ListStorage storagesWithStock, String originalStorage) {
        ObjectList shortestRoutes = new ObjectList();
        ListStorage allStorages = GlobalUI.getGraph().getStorageList();
        int[][] adjMatrix = GlobalUI.getGraph().getAdjMatrix().getMatrix();
//        adjMatrix.printMatrix();

        for (int i = 0; i < storagesWithStock.getLength(); i++) {
            String currentStorageWithStock = storagesWithStock.getStorageNodeByIndex(i).getStorage().getName();

            ObjectList visitedNodes = new ObjectList();
//            ObjectList unVisitedNodes = new ObjectList();

            Object[][] routesMatrix = new Object[adjMatrix.length][3];

            //fill columns [0] storages names, [1] shortest distance, [2] previous node
            for (int j = 0; j < allStorages.getLength(); j++) {
                routesMatrix[j][0] = allStorages.getStorageNodeByIndex(j).getStorage().getName();
                routesMatrix[j][1] = Integer.MAX_VALUE;

//                unVisitedNodes.addEnd(allStorages.getStorageNodeByIndex(j).getStorage().getName());
                if (routesMatrix[j][0].equals(currentStorageWithStock)) {
                    routesMatrix[j][1] = 0;
                }
            }

            //Dijkstra
            while (visitedNodes.getLength() != allStorages.getLength()) {

                //identify the lowest distance unvisited node
                String lowestUnvisitedNode = "default";
                for (int j = 0; j < allStorages.getLength(); j++) {
                    String currentStorageName = allStorages.getStorageNodeByIndex(j).getStorage().getName();

                    if (!visitedNodes.isObjectInList(currentStorageName)) {

                        if (lowestUnvisitedNode.equals("default")) {
                            lowestUnvisitedNode = currentStorageName;
                        } else {
                            int lowestUnvisitedRow = allStorages.getIndexByElement(lowestUnvisitedNode);
                            int currentRow = allStorages.getIndexByElement(currentStorageName);

                            int lowestRouteValue = (int) routesMatrix[lowestUnvisitedRow][1];
                            int currentRouteValue = (int) routesMatrix[currentRow][1];

                            if (currentRouteValue < lowestRouteValue) {
                                lowestUnvisitedNode = currentStorageName;
                            }
                        }

                    }

                }
                // examine unvisited neighbours

                int lowestIUnvisitedIndex = allStorages.getIndexByElement(lowestUnvisitedNode);

                for (int j = 0; j < adjMatrix[lowestIUnvisitedIndex].length; j++) {
                    int currentRoute = adjMatrix[lowestIUnvisitedIndex][j];
                    if (currentRoute != 0) {
                        String currentNeighbour = (String) routesMatrix[j][0];

                        if (!visitedNodes.isObjectInList(currentNeighbour)) {
                            int newDistance = currentRoute + ((int) routesMatrix[lowestIUnvisitedIndex][1]);
                            int oldDistance = (int) routesMatrix[j][1];

                            if (newDistance < oldDistance) {
                                //update new lowest route and previous node
                                routesMatrix[j][1] = newDistance;
                                routesMatrix[j][2] = lowestUnvisitedNode;
                            }

                        }
                    }
                }

                visitedNodes.addEnd(lowestUnvisitedNode);

            }
            // end of Dijkstra        

            int currentIndex = allStorages.getIndexByElement(originalStorage);
            String finalRoute = String.valueOf((int) routesMatrix[currentIndex][1]) + ";" + originalStorage + ",";
            boolean isRouteIncomplete = true;

            while (isRouteIncomplete) {
                if (routesMatrix[currentIndex][2] == null) {
                    isRouteIncomplete = false;
                } else {
                    finalRoute += ((String) routesMatrix[currentIndex][2]) + ",";
                    currentIndex = allStorages.getIndexByElement(routesMatrix[currentIndex][2].toString());
                }
            }

            shortestRoutes.addEnd(finalRoute);

            //print Dijkstra matrix
//             System.out.println("Ruta sin invertir:" + finalRoute);
//            System.out.println("Almacen origen:" + currentStorageWithStock);
//            for (int k = 0; k < routesMatrix.length; k++) {
//                for (int j = 0; j < routesMatrix[0].length; j++) {
//                    System.out.print(routesMatrix[k][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("------\n");
        }

        String lowestRoute = shortestRoutes.getHead().getElement().toString();
        for (int i = 0; i < shortestRoutes.getLength(); i++) {
            int currentValue = Integer.parseInt(((String) shortestRoutes.getElementInIndex(i)).split(";")[0]);
            int lowestValue = Integer.parseInt(lowestRoute.split(";")[0]);

            if (currentValue < lowestValue) {
                lowestRoute = (String) shortestRoutes.getElementInIndex(i);
            }
        }
//        System.out.println("original");
//        System.out.println(lowestRoute);

        String correctedLowestRoute = lowestRoute.split(";")[0] + ";" + invertRoute(lowestRoute.split(";")[1]);
//        System.out.println("inverted");
//        System.out.println(correctedLowestRoute);

        return correctedLowestRoute;
    }

    /**
     *
     * Inverts the storage secuence given
     *
     * @param original
     * @return String
     */
    public static String invertRoute(String original) {
        String inverted = "";
        String[] originalSplit = original.split(",");
        for (int i = originalSplit.length - 1; i >= 0; i--) {
            inverted += originalSplit[i] + ",";
        }

        return inverted.substring(0, inverted.length() - 1);
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
                        Product element = new Product(0, "Placa");
                        ListInv inventory = new ListInv();
                        inventory.addHead(element);

                        GlobalUI.getGraph().getStorageList().getStorageNodeByIndex(GlobalUI.getGraph().getStorageList().getLength() - 1).getStorage().setInventory(inventory);
                        //GlobalUI.getGraph().getAdjMatrix().printMatrix();
                        JOptionPane.showMessageDialog(null, "Almacén creado con éxito");
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

    /**
     * Create a library graph and shows it to the user
     */
    public static void createGraphMap() {
        MultiGraph multiGraph = new MultiGraph("GraphMap");
        Graph originalGraph = GlobalUI.getGraph();
        AdjMatrixGraph adjMatrix = originalGraph.getAdjMatrix();
        ListStorage storages = originalGraph.getStorageList();

        //add all Nodes
        NodeStorage pointer = storages.getHead();
        while (pointer != null) {
            Node n = multiGraph.addNode(pointer.getStorage().getName());
            String storageName = pointer.getStorage().getName();
            n.setAttribute("ui.label", storageName + "\n");

            pointer = pointer.getNext();
        }

        for (int i = 0; i < adjMatrix.getMatrix().length; i++) {

            for (int j = 0; j < adjMatrix.getMatrix()[i].length; j++) {

                if (adjMatrix.getMatrix()[i][j] != 0) {
                    String storage1 = storages.getStorageNodeByIndex(i).getStorage().getName();
                    String storage2 = storages.getStorageNodeByIndex(j).getStorage().getName();
                    String edgeName = storage1 + " " + storage2;
                    multiGraph.addEdge(edgeName, storage1, storage2, true);
                    Edge ed = multiGraph.getEdge(edgeName);
                    ed.setAttribute("ui.label", adjMatrix.getMatrix()[i][j]);
                }

            }
        }

        String graphCss = "node { text-offset: 0px, -10px; size: 20px; text-size: 12; fill-color: blue, aquamarine; fill-mode: gradient-horizontal; text-alignment: above; text-color: #222; text-background-mode: plain; text-background-color: white; } edge { size: 2px; fill-color: #444; text-alignment: above; text-size: 20; arrow-size: 12; text-color: blue; text-offset: 10px, -20px;}";
        multiGraph.setAttribute("ui.stylesheet", graphCss);

        System.setProperty("org.graphstream.ui", "swing");

        Viewer viewer = multiGraph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }

    /**
     * Checks if file is txt, if so ask the user confirmation and change the
     * current graph info
     *
     * @param file
     */
    public static void uploadTxt(File file) {
        if (file.getAbsolutePath().endsWith(".txt")) {

            int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea usar el archivo: " + file.getName(), "Confimción", JOptionPane.YES_NO_OPTION);

            if (option == 0) {
                Application.initializeAppWithNewInfo(file.getAbsolutePath());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Alerta, solo se pueden ingresar archivos de texto (.txt)", "Alerta", 2);
        }
    }

    /**
     * Writes the txt with the current data
     *
     * @param message
     */
    public static void saveCurrentData(String message) {
        main.File f = new main.File();
        int resp = JOptionPane.showConfirmDialog(null, message, "Cofirmación", JOptionPane.YES_NO_OPTION);

        if (resp == 0) {

            try {
                f.writeFile(GlobalUI.getGraph(), GlobalUI.getDirection());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un error guardando la información");
            }

        }
    }

    /**
     * add new Rutes to the Graph
     *
     * @param direction
     * @param from
     */
    public static void addNewRutesButton(String direction, String from) {
        
        GlobalUI.getGraph().getAdjMatrix().printMatrix();
        String[] arrayAux = direction.split("  ");
        for (int i = 0; i < arrayAux.length; i++) {
            if (!arrayAux[i].equalsIgnoreCase("")) {
                String[] secondArray = arrayAux[i].split(",");
                int num = Integer.parseInt(secondArray[1]);
                String storage = secondArray[0];
                GlobalUI.getGraph().getAdjMatrix().addEdge(GlobalUI.getGraph().getStorageNumberWithName(from), GlobalUI.getGraph().getStorageNumberWithName(storage), num);
            }

        }

        GlobalUI.getGraph().getAdjMatrix().printMatrix();
    }
    
    /**
     * Create an array with String
     * @param direction
     * @return 
     */

    public static String[] fromTexttoArray(String direction) {
        
        String[] arrayAux = direction.split("  ");

        return arrayAux;
    }

}
