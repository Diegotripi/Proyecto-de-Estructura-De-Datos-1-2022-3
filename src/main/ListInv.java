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
    private int lenght;

    /**
     * Constructor method
     */
    public ListInv() {
        this.head = null;
        this.end = null;
        this.lenght = 0;
    }
    
    /**
     * Getter method
     * @return head
     */

    public NodeInv getHead() {
        return head;
    }
    /**
     * Getter method
     * @return end
     */

    public NodeInv getEnd() {
        return end;
    }
    
    /**
     * Getter method
     * @return lenght
     */

    public int getLenght() {
        return lenght;
    }
    
    /**
     * Setter method
     * @param head
     */

    public void setHead(NodeInv head) {
        this.head = head;
    }
    
    /**
     * Setter method
     * @param end
     */

    public void setEnd(NodeInv end) {
        this.end = end;
    }
    /**
     * Setter method
     * @param lenght
     */

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    /**
     * The list is emppty or not
     * @return boolean
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Add a new node at the head
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

        lenght++;
    }

    /**
     * Add a new node at the end
     * @param end 
     */
    public void addEnd(Product end) {
        NodeInv nodito = new NodeInv(end);
        if (isEmpty()) {
            setHead(nodito);
            this.end = nodito;

        } else {
            NodeInv aux = this.head;
            for (int i = 0; i < lenght; i++) {
                if (aux.getNext() == null) {
                    aux.setNext(nodito);
                    this.end = nodito;
                } else {
                    aux = aux.getNext();
                }
            }
        }

        lenght++;
    }

    /**
     * Add a new product at a index
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

            if ((pos + 1) >= lenght) {
                this.end = nodito;
            }

            lenght++;

        }

    }

    /**
     * Delete a head in the list
     * 
     */
    public void deleteHead() {
        NodeInv aux = head;
        if (lenght ==1) {
            setHead(null);
            lenght--;
        }
        else if (!isEmpty()) {
            aux = head.getNext();
            setHead(aux);
            this.head = aux;
            lenght--;
        }
    }

    /**
     * Delete a end in the list
     */
    public void deleteEnd() {
        NodeInv aux = head;
        if (lenght == 1) {
            deleteHead();
        } else if (!isEmpty()) {
            for (int i = 0; i < lenght; i++) {
                if (aux.getNext().getNext() == null) {
                    aux.setNext(null);
                    this.end = aux;
                    lenght--;
                } else {
                    aux = aux.getNext();
                }
            }

        }
    }

    /**
     * delete a index in the list
     * @param pos 
     */
    public void eliminarIndice(int pos) {
        int cont = 0;
        if (lenght == 1) {
            deleteHead();
        }else if(lenght <= (pos+1)){
            deleteEnd();
        }
        else if (!isEmpty()) {
            NodeInv aux = head;
            while (cont < pos && aux.getNext()!= null) {
                aux = aux.getNext();
                cont += 1;
            }
            aux.setNext(aux.getNext().getNext());


            lenght--;
        }

    }

    /**
     * Print Quantity of products
     */
    public void printQuantity() {
        NodeInv aux = head;
        if (!isEmpty()) {
            for (int i = 0; i < lenght; i++) {
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
            for (int i = 0; i < lenght; i++) {
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
            for (int i = 0; i < lenght; i++) {
                System.out.println("\nProducto: "+ aux.getProduct().getName()+"\nCantidad: "+aux.getProduct().getQuantity()+"\n");
                
                aux = aux.getNext();
            }
        }
    }

}
