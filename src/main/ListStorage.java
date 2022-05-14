/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class ListStorage {

    private NodeStorage head;
    private NodeStorage end;
    private int lenght;

    /**
     * Constructor Method
     */
    public ListStorage() {
        this.head = null;
        this.end = null;
        this.lenght = 0;
    }

    /**
     * Getter Method
     *
     * @return head
     */
    public NodeStorage getHead() {
        return head;
    }

    /**
     * Getter Method
     *
     * @return end
     */
    public NodeStorage getEnd() {
        return end;
    }

    /**
     * Getter Method
     *
     * @return lenght
     */
    public int getLenght() {
        return lenght;
    }

    /**
     * Setter Method
     *
     * @param head
     */
    public void setHead(NodeStorage head) {
        this.head = head;
    }

    /**
     * Setter Method
     *
     * @param end
     */
    public void setEnd(NodeStorage end) {
        this.end = end;
    }

    /**
     * Setter Method
     *
     * @param lenght
     */
    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    /**
     * Determinate if the list has not nodes
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Add a head
     *
     * @param head
     */
    public void addHead(Storage head) {
        NodeStorage nodito = new NodeStorage(head);
        if (isEmpty()) {
            setHead(nodito);
            end = nodito;

        } else {
            NodeStorage aux = this.head;
            nodito.setNext(aux);
            setHead(nodito);
        }

        lenght++;
    }

    /**
     * Add a end
     *
     * @param end
     */
    public void addEnd(Storage end) {
        NodeStorage nodito = new NodeStorage(end);
        if (isEmpty()) {
            setHead(nodito);
            this.end = nodito;

        } else {
            NodeStorage aux = this.head;
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
     * Add index
     *
     * @param pos
     * @param medio
     */
    public void addIndex(int pos, Storage medio) {
        NodeStorage nodito = new NodeStorage(medio);
        int cont = 0;
        if (isEmpty()) {
            setHead(nodito);
            this.end = nodito;

        } else {
            NodeStorage aux = head;
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
     * Delete Head
     */
    public void deleteHead() {
        NodeStorage aux = head;
        if (lenght == 1) {
            setHead(null);
            lenght--;
        } else if (!isEmpty()) {
            aux = head.getNext();
            setHead(aux);
            this.head = aux;
            lenght--;
        }
    }

    /**
     * Delete End
     */
    public void deleteEnd() {
        NodeStorage aux = head;
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
     * Delete index
     *
     * @param pos
     */
    public void eliminarIndice(int pos) {
        int cont = 0;
        if (lenght == 1) {
            deleteHead();
        } else if (lenght <= (pos + 1)) {
            deleteEnd();
        } else if (!isEmpty()) {
            NodeStorage aux = head;
            while (cont < pos && aux.getNext() != null) {
                aux = aux.getNext();
                cont += 1;
            }
            aux.setNext(aux.getNext().getNext());

            lenght--;
        }

    }

    public NodeStorage getIndex(int ind) {
        NodeStorage aux = getHead();
        for (int i = 0; i < ind; i++) {
            aux = aux.getNext();
        }
        return aux;
    }

}
