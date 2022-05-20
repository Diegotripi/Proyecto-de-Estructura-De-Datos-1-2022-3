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
    
    public ObjectNode(Object element) {
        this.element= element;
        this.next = null;
    }

    public Object getElement() {
        return element;
    }
    
    public Integer getElementInt(){
        return (Integer) this.element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public ObjectNode getNext() {
        return next;
    }

    public void setNext(ObjectNode next) {
        this.next = next;
    }
}
