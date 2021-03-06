/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class ListInv {

    private NodeInv head;
    private NodeInv end;
    private int length;

    /**
     * Constructor method
     */
    public ListInv() {
        this.head = null;
        this.end = null;
        this.length = 0;
    }

    /**
     * Getter method
     *
     * @return head
     */
    public NodeInv getHead() {
        return head;
    }

    /**
     * Getter method
     *
     * @return end
     */

    public NodeInv getEnd() {
        return end;
    }

    /**
     * Getter method
     *
     * @return lenght
     */
    public int getLength() {
        return length;
    }

    /**
     * Setter method
     *
     * @param head
     */
    public void setHead(NodeInv head) {
        this.head = head;
    }

    /**
     * Setter method
     *
     * @param end
     */
    public void setEnd(NodeInv end) {
        this.end = end;
    }

    /**
     * Setter method
     *
     * @param length
     */

    public void setLength(int length) {
        this.length = length;
    }

    /**
     * The list is emppty or not
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Add a new node at the head
     *
     * @param head
     */
    public void addHead(Product head) {
        NodeInv nodito = new NodeInv(head);
        if (isEmpty()) {
            setHead(nodito);
            end = nodito;

        } else {
            NodeInv aux = this.head;
            nodito.setNext(aux);
            setHead(nodito);
        }

        length++;
    }

    /**
     * Add a new node at the end
     *
     * @param end
     */
    public void addEnd(Product end) {
        NodeInv nodito = new NodeInv(end);
        if (isEmpty()) {
            setHead(nodito);
            this.end = nodito;

        } else {
            NodeInv aux = this.head;
            for (int i = 0; i < length; i++) {
                if (aux.getNext() == null) {
                    aux.setNext(nodito);
                    this.end = nodito;
                } else {
                    aux = aux.getNext();
                }
            }
        }

        length++;
    }

    /**
     * Add a new product at a index
     *
     * @param pos
     * @param middle
     */
    public void addIndex(int pos, Product middle) {
        NodeInv nodito = new NodeInv(middle);
        int cont = 0;
        if (isEmpty()) {
            setHead(nodito);
            this.end = nodito;

        } else {
            NodeInv aux = head;
            while (cont < pos && aux.getNext() != null) {
                aux = aux.getNext();
                cont += 1;
            }
            nodito.setNext(aux.getNext());
            aux.setNext(nodito);

            if ((pos + 1) >= length) {
                this.end = nodito;
            }

            length++;

        }

    }

    /**
     * Delete a head in the list
     *
     */
    public void deleteHead() {
        NodeInv aux = head;
        if (length == 1) {
            setHead(null);
            length--;
        } else if (!isEmpty()) {
            aux = head.getNext();
            setHead(aux);
            this.head = aux;
            length--;
        }
    }

    /**
     * Delete a end in the list
     */
    public void deleteEnd() {
        NodeInv aux = head;
        if (length == 1) {
            deleteHead();
        } else if (!isEmpty()) {
            for (int i = 0; i < length; i++) {
                if (aux.getNext().getNext() == null) {
                    aux.setNext(null);
                    this.end = aux;
                    length--;
                } else {
                    aux = aux.getNext();
                }
            }

        }
    }

    /**
     * delete a index in the list
     *
     * @param pos
     */
    public void deleteInIndex(int pos) {
        int cont = 0;
        if (length == 1) {
            deleteHead();
        } else if (length <= (pos + 1)) {
            deleteEnd();
        } else if (!isEmpty()) {
            NodeInv aux = head;
            while (cont < pos && aux.getNext() != null) {
                aux = aux.getNext();
                cont += 1;
            }
            aux.setNext(aux.getNext().getNext());

            length--;
        }

    }

    /**
     * Print Quantity of products
     */
    public void printQuantity() {
        NodeInv aux = head;
        if (!isEmpty()) {
            for (int i = 0; i < length; i++) {
                System.out.println(aux.getProduct().getQuantity());
                aux = aux.getNext();
            }
        }
    }

    /**
     * Print product name
     */
    public void printName() {
        NodeInv aux = head;
        if (!isEmpty()) {
            for (int i = 0; i < length; i++) {
                System.out.println(aux.getProduct().getName());
                aux = aux.getNext();
            }
        }
    }

    /**
     * Print inventory
     */
    public void printInventory() {
        NodeInv aux = head;
        if (!isEmpty()) {
            for (int i = 0; i < length; i++) {
                System.out.println("\nProducto: " + aux.getProduct().getName() + "\nCantidad: " + aux.getProduct().getQuantity() + "\n");

                aux = aux.getNext();
            }
        }
    }

    /**
     * Returns the element in the specified index
     *
     * @author isaac
     * @param pos (int)
     * @return Product
     */
    public Product getElementInIndex(int pos) {
        if (!isEmpty()) {
            NodeInv pointer = getHead();
            for (int i = 0; i < pos; i++) {
                if (pointer.getNext() == null) {
                    break;
                }
                pointer = pointer.getNext();
            }
            return pointer.getProduct();
        } else {
            return null;
        }

    }

    /**
     * Returns an String array with the name of all products
     *
     * @return chain (String[])
     */
    public String[] getInvStringArray() {
        String[] array;
        array = new String[getLength()];
        for (int i = 0; i < getLength(); i++) {
            array[i] = getElementInIndex(i).getName();
        }

        return array;

    }

    /**
     * Returns the product matching the name 
     *
     * @param productName
     * @return Product
     */
    public Product getProductByName(String productName) {
        NodeInv pointer = getHead();
        Product wantedProduct = null;
        while(pointer != null) {
            if (pointer.getProduct().getName().equals(productName)) {
                wantedProduct = pointer.getProduct();
                break;
            }
            pointer = pointer.getNext();
        }
        
        return wantedProduct;
    }
    
    /**
     * Returns a Product array with all products
     *
     * @return chain (Product[])
     */
    public Product[] getProductStringArray() {
        Product[] array;
        array = new Product[getLength()];
        for (int i = 0; i < getLength(); i++) {
            array[i] = getElementInIndex(i);
        }

        return array;

    }
    
    /**
     * Add a new product with the quantity on a inventory list
     * @param name
     * @param quantity 
     */
    
    public void addNewProductWithQuantity(String name, int quantity){
        Product p = new Product(quantity,name);
        addEnd(p);
        
    }

}
