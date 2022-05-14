/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class NodeStorage {

    private Storage storage;
    private NodeStorage next;

    /**
     * Constructor method
     *
     * @param storage
     */
    public NodeStorage(Storage storage) {
        this.storage = storage;
        this.next = null;
    }

    /**
     * Getter method
     *
     * @return storage
     */
    public Storage getStorage() {
        return storage;
    }

    /**
     * Getter Method
     *
     * @return next
     */
    public NodeStorage getNext() {
        return next;
    }

    /**
     * Setter method
     *
     * @param storage
     */

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * Setter method
     *
     * @param next
     */

    public void setNext(NodeStorage next) {
        this.next = next;
    }

}
