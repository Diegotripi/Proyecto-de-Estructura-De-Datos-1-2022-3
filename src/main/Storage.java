/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class Storage {

    private ListInv inventory;
    private String name;

    /**
     * Constructor Method
     *
     * @param inventory
     * @param name
     */
    public Storage(ListInv inventory, String name) {
        this.inventory = inventory;
        this.name = name;
    }
    
    /**
     * Constructor Method

     * @param name
     */
    public Storage( String name) {
        
        this.name = name;
    }

    /**
     * Getter Method
     *
     * @return inventory
     */
    public ListInv getInventory() {
        return inventory;
    }

    /**
     * Getter Method
     *
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * Setter Method
     *
     * @param inventory
     */
    public void setInventory(ListInv inventory) {
        this.inventory = inventory;
    }

    /**
     * Setter Method
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }
    
    public void printInv(){
        System.out.println("Almacén: "+getName());
        getInventory().printInventory();
    }

}
