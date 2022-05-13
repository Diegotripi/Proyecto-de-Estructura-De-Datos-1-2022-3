/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * Class Node Inv
 */
public class NodeInv {
    
    private Product product;
    private NodeInv next;
/**
 * Class Constructor 
 * @param product
 */
    public NodeInv(Product product) {
        this.product = product;
        this.next = null;
    }
/**
 * Getter Method
 * @return product
 */
    public Product getProduct() {
        return product;
    }
/**
 * Getter Method
 * @return next 
 */
    public NodeInv getNext() {
        return next;
    }
/**
 * Setter Method
 * @param product
 */
    public void setProduct(Product product) {
        this.product = product;
    }
/**
 * Setter Method
 * @param next
 */
    public void setNext(NodeInv next) {
        this.next = next;
    }
    
    
    
}
