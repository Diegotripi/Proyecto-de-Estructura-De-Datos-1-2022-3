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
    private ListStorage storage;
    private int counter;
    /**
     * Constructor Method
     * @param matrix 
     */

    public Graph(AdjMatrixGraph matrix) {
        this.matrix = matrix;
        this.storage = null;
    }
    
    /**
     * Getter Method
     * @return matrix
     */

    public AdjMatrixGraph getMatrix() {
        return matrix;
    }
    
    /**
     * Getter Method
     * @return storage
     */

    public ListStorage getStorage() {
        return storage;
    }
    
    /**
     * Setter Method
     * @param matrix
     */

    public void setMatrix(AdjMatrixGraph matrix) {
        this.matrix = matrix;
    }
    
    /**
     * Setter Method
     * @param storage
     */

    public void setStorage(ListStorage storage) {
        this.storage = storage;
    }
    
    /**
     * Print Storage's inventory
     * @param index
     */

    public void getInventory(int index) {
        storage.getIndex(index).getStorage().getInventory().printInventory();
    }
    
    /**
     * Print Storage's name
     * @param n
     */

    public void nameStorage(int n) {
        System.out.println("\n" + storage.getIndex(n).getStorage().getName());
    }
    
    /**
     * Create a new Storage 
     * @param i
     * @param n
     */

    public void createStorage(ListInv i, String n) {
        Storage a = new Storage(i, n);
        if (storage.getLenght() == 0) {
            storage.addHead(a);
        }else{
            storage.addEnd(a);
        }
        
        counter++;
    }
    
    /**
     * Create a new Storage 
     * @param name
     * @param quantity
     * @return Product
     */

    public Product product(String name, int quantity ) {
        Product p1 = new Product(quantity, name);
        return p1;
    }
    
    /**
     * Create a new Storage 
     * @param letter
     * @return storageNumber
     */

    public int getStorageNumber(String letter) {
        int num = 0;
        for (int i = 0; i < storage.getLenght(); i++) {
            String ultimaLetra = storage.getIndex(i).getStorage().getName().substring(storage.getIndex(i).getStorage().getName().length() - 1);
            if (letter.equalsIgnoreCase(ultimaLetra)) {
                num = i;
                break;
            }
        }

        return num;
    }

}
