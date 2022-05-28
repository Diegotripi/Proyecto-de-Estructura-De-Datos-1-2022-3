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
    private ListStorage storageList;
    private int counter;

    /**
     * Constructor Method
     *
     * @param matrix
     */
    public Graph(AdjMatrixGraph matrix) {
        this.matrix = matrix;
        this.storageList = null;
    }

    /**
     * Constructor whiout param
     */
    public Graph() {

    }

    /**
     * Getter Method
     *
     * @return matrix
     */
    public AdjMatrixGraph getAdjMatrix() {
        return matrix;
    }

    /**
     * Getter Method
     *
     * @return storage
     */
    public ListStorage getStorageList() {
        return storageList;
    }

    /**
     * Setter Method
     *
     * @param matrix
     */
    public void setMatrix(AdjMatrixGraph matrix) {
        this.matrix = matrix;
    }

    /**
     * Setter Method
     *
     * @param storage
     */
    public void setStorage(ListStorage storage) {
        this.storageList = storage;
    }

    /**
     * Print Storage's inventory
     *
     * @param index
     */
    public void printInventory(int index) {
        storageList.getStorageNodeByIndex(index).getStorage().getInventory().printInventory();
    }

    /**
     * Print Storage's name
     *
     * @param n
     */
    public void printStorageName(int n) {
        System.out.println("\n" + storageList.getStorageNodeByIndex(n).getStorage().getName());
    }

    /**
     * Create a new Storage
     *
     * @param i
     * @param n
     */
    public void createStorage(ListInv i, String n) {
        Storage a = new Storage(i, n);
        if (storageList.getLength() == 0) {
            storageList.addHead(a);
        } else {
            storageList.addEnd(a);
        }

        counter++;
    }

    /**
     * Create a new Product
     *
     * @param name
     * @param quantity
     * @return Product
     */
    public Product product(String name, int quantity) {
        Product p1 = new Product(quantity, name);
        return p1;
    }

    /**
     * Gets storage Number
     *
     * @param letter
     * @return storageNumber
     */
    public int getStorageNumber(String letter) {
        int num = 0;
        for (int i = 0; i < storageList.getLength(); i++) {
            String storage = storageList.getStorageNodeByIndex(i).getStorage().getName();
            String[] storageArray = storage.split(" ");
            
            if (letter.equalsIgnoreCase(storageArray[1])) {
                num = i;
                break;
            }
        }

        return num;
    }
    
    public int getStorageNumberWithName(String name){
        int num = 0;
        for (int i = 0; i < storageList.getLength(); i++) {
            String storageName = storageList.getStorageNodeByIndex(i).getStorage().getName();
            if (storageName.equalsIgnoreCase(name)) {
                num = i;
                break;
            }
            
        }
        return num;
    }

    /**
     *
     * @return counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Returns an String array with the name of all storages
     * @return chain (String[])
     */
    public String[] namenOnAString() {
        String[] chain;
        chain = new String[counter];
        for (int i = 0; i < counter; i++) {
            chain[i] = storageList.getStorageNodeByIndex(i).getStorage().getName();

        }

        return chain;

    }

    /**
     * gets first node of the graph
     *
     * @return NodeStorage
     */
    public NodeStorage getFirstNode() {
        return getStorageList().getHead();
    }

    /**
     * gets the index num of the given node
     *
     * @param node
     * @return int
     */
    public int getNodeIndex(NodeStorage node) {
        NodeStorage pointer = getStorageList().getHead();
        int cont = 0;
        while (pointer != node) {
            pointer = pointer.getNext();
            cont++;
        }

        return cont;
    }

    /**
     * Performs the DFS in the graph returns the list of all graphs storages
     *
     * @return ObjectList of storages
     */
    public ObjectList getStoragesByDFS() {
        NodeStorage currentNode = getFirstNode();
        ObjectList traveledNodes = new ObjectList();
        ObjectList traveledIndexes = new ObjectList();

        int[][] adjMatrix = getAdjMatrix().getMatrix();

//        getAdjMatrix().printMatrix();
        boolean traveledAllNodes = false;
        int stepsBack = 0;

        mainLoop:
        while (!traveledAllNodes) {
            int currentIndex = getNodeIndex(currentNode);

            boolean validRoute = false;

            if (!traveledNodes.isObjectInList(currentNode.getStorage())) {
//                System.out.println(currentNode.getStorage().getName());
                traveledNodes.addEnd(currentNode.getStorage());
                traveledIndexes.addStart(currentIndex);
            }

            innerLoop:
            for (int i = 0; i < adjMatrix[currentIndex].length; i++) {
                int route = adjMatrix[currentIndex][i];

                if (route != 0) {
                    if (!traveledIndexes.isObjectInList(i)) {
                        
                        currentNode = getStorageList().getStorageNodeByIndex(i);
                        
                        validRoute = true;
                        stepsBack = 0;
                        break innerLoop;
                    }
                }
            }

            if (traveledNodes.getLength() == getStorageList().getLength()) {
                traveledAllNodes = true;
            }
            if (!validRoute) {
                stepsBack++;
                int newIndex = (int) traveledIndexes.getElementInIndex(stepsBack);
                currentNode = getStorageList().getStorageNodeByIndex(newIndex);

            }
        }
// prints in console
//        for (int i = 0; i < traveledNodes.getLength(); i++) {
//            ((Storage) traveledNodes.getElementInIndex(i)).printInv();
//        }

        return traveledNodes;
    }

    /**
     * Performs the BFS in the graph returns the list of all graphs storages
     *
     * @return ObjectList of storages
     */
    public ObjectList getStoragesByBFS() {
        NodeStorage currentNode = getFirstNode();
        ObjectList traveledNodes = new ObjectList();
        ObjectList indexToCheck = new ObjectList();

        int[][] adjMatrix = getAdjMatrix().getMatrix();

        boolean traveledAllNodes = false;

        traveledNodes.addEnd(currentNode.getStorage());
        indexToCheck.addEnd(getNodeIndex(currentNode));

        while (!traveledAllNodes) {
            currentNode = getStorageList().getStorageNodeByIndex((int) (indexToCheck.getHead().getElement()));
            indexToCheck.deleteStart();

            int currentIndex = getNodeIndex(currentNode);

            for (int i = 0; i < adjMatrix[currentIndex].length; i++) {
                int route = adjMatrix[currentIndex][i];

                if (route != 0) {
                    Storage objectToEvaluate = getStorageList().getStorageNodeByIndex(i).getStorage();
                    if (!traveledNodes.isObjectInList(objectToEvaluate)) {
                        traveledNodes.addEnd(getStorageList().getStorageNodeByIndex(i).getStorage());
                        indexToCheck.addEnd(i);
                    }

                }

            }

            if (traveledNodes.getLength() == getStorageList().getLength()) {
                traveledAllNodes = true;
            }

        }

        getAdjMatrix().printMatrix();
        System.out.println("----");
// prints in console
//        for (int i = 0; i < traveledNodes.getLength(); i++){
//            ((Storage)traveledNodes.getElementInIndex(i)).printInv();
//        }
        return traveledNodes;

    }
    
    /**
     * Create a new storage whiout an invent
     * @param name 
     */
    public void insertNewStorage(String name){
        Storage storag = new Storage(name);
        this.storageList.addEnd(storag);
        counter++;
        
    }
}
