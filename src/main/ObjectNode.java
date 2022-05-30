/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author isaac
 */
public class ObjectNode {
     private Object element;
    private ObjectNode next;
    
    
    /**
     * Constructor
     * @param element 
     */
    public ObjectNode(Object element) {
        this.element= element;
        this.next = null;
    }
    /**
     * Get the element
     * @return 
     */
    public Object getElement() {
        return element;
    }
    /**
     * get the element integer
     * @return 
     */
    public Integer getElementInt(){
        return (Integer) this.element;
    }
    /**
     * set a element
     * @param element 
     */
    public void setElement(Object element) {
        this.element = element;
    }
    /**
     * get the next node
     * @return 
     */
    public ObjectNode getNext() {
        return next;
    }
    /**
     * set a next node
     * @param next 
     */
    public void setNext(ObjectNode next) {
        this.next = next;
    }
}
