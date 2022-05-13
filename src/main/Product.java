/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 * 
 * Class Product
 * 
 */
public class Product {
    
    private String Name;
    private int Quantity;
    
/**
 * Class Constructor
 * @param quantity
 * @param name
 */

    public Product(int quantity, String name) {
        this.Quantity = quantity;
        this.Name = name;
    }
    
    /**
     * Getter method
     * @return Quantity
     */

    public int getQuantity() {
        return Quantity;
    }
    
    /**
     * getter Name
     * @return Name
     */

    public String getName() {
        return Name;
    }
    
    /**
     * Setter method
     * @param quantity 
     */

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }
    
    /**
     * Setter method
     * @param name 
     */

    public void setName(String name) {
        this.Name = name;
    }
    
    
    
}
