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
public class ObjectList {

    private ObjectNode head;
    private int length;

    /**
     * Constructor for ObjectList
     *
     * @author isaac
     */
    public ObjectList() {
        this.head = null;
        this.length = 0;
    }

    /**
     * add element at the start of the list
     *
     * @author isaac
     * @param element
     */
    public void addStart(Object element) {
        ObjectNode node = new ObjectNode(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            node.setNext(getHead());
            setHead(node);
        }
        this.length++;
    }

    /**
     * add element at the end of the list
     *
     * @author isaac
     * @param element
     */
    public void addEnd(Object element) {
        ObjectNode node = new ObjectNode(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            ObjectNode pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
        }
        this.length++;
    }

    /**
     * add element at the specified index of the list
     *
     * @author isaac
     * @param pos (int)
     * @param element
     */
    public void addInIndex(int pos, Object element) {
        ObjectNode node = new ObjectNode(element);
        if (isEmpty()) {
            setHead(node);
            this.length++;
        } else {
            if (pos > 0) {
                ObjectNode pointer = getHead();
                for (int i = 0; i < pos - 1; i++) {
                    if (pointer.getNext() == null) {
                        break;
                    }
                    pointer = pointer.getNext();
                }
                node.setNext(pointer.getNext());
                pointer.setNext(node);
                this.length++;
            } else {
                addStart(element);
            }

        }

    }

    /**
     * deletes element at the start of the list
     *
     * @author isaac
     *
     */
    public void deleteStart() {
        if (!isEmpty()) {
            ObjectNode temp = getHead();
            setHead(temp.getNext());
            temp.setNext(null);
            this.length--;
        }
    }

    /**
     * deletes element at the end of the list
     *
     * @author isaac
     *
     */
    public void deleteEnd() {
        if (!isEmpty()) {
            if (getLength() == 1) {
                setHead(null);
            } else {
                ObjectNode pointer = getHead();
                while (pointer.getNext().getNext() != null) {
                    pointer = pointer.getNext();
                }
                pointer.setNext(null);
            }

            this.length--;
        }
    }

    /**
     * deletes element at the specified index of the list
     *
     * @author isaac
     * @param pos (int)
     *
     */
    public void deleteInIndex(int pos) {
        if (!isEmpty()) {
            if (pos <= 0) {
                deleteStart();
            } else {
                ObjectNode pointer = getHead();
                for (int i = 0; i < pos - 1; i++) {
                    if (pointer.getNext() == null) {
                        break;
                    }
                    pointer = pointer.getNext();
                }
                ObjectNode temp = pointer.getNext();
                boolean isNull = temp == null;
                if (!isNull) {
                    pointer.setNext(temp.getNext());
                    temp.setNext(null);
                    this.length--;
                } else {
                    deleteEnd();
                }
            }

        }
    }

    /**
     * Prints all elements in the list
     *
     * @author isaac
     *
     */
    public void printList() {
        if (!isEmpty()) {
            ObjectNode pointer = getHead();
            while (pointer != null) {
                System.out.println(pointer.getElement());
                pointer = pointer.getNext();
            }
        } else {
            System.out.println("Sin elementos");
        }

    }

    /**
     * Returns the element in the specified index
     *
     * @author isaac
     * @param pos (int)
     * @return Object
     */
    public Object getElementInIndex(int pos) {
        if (!isEmpty()) {
            ObjectNode pointer = getHead();
            for (int i = 0; i < pos; i++) {
                if (pointer.getNext() == null) {
                    break;
                }
                pointer = pointer.getNext();
            }
            return pointer.getElement();
        } else {
            return null;
        }

    }

    /**
     * getter for head
     *
     * @author isaac
     * @return ObjectNode
     *
     */
    public ObjectNode getHead() {
        return head;
    }

    /**
     * setter for head
     *
     * @author isaac
     * @param head
     *
     */
    public void setHead(ObjectNode head) {
        this.head = head;
    }

    /**
     * getter for length
     *
     * @author isaac
     * @return int
     */
    public int getLength() {
        return length;
    }

    /**
     * getter for length
     *
     * @author isaac
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Checks if the list is empty
     *
     * @author isaac
     * @return boolean
     */
    public boolean isEmpty() {
        return getHead() == null;
    }

    /**
     * deletes the element given by parameter
     *
     * @author isaac
     * @param element
     */
    public void deleteByElement(Object element) {
        if (!isEmpty()) {
            ObjectNode pointer = getHead();
            if (element == pointer.getElement()) {
                deleteStart();
            } else {
                boolean found = false;
                while ((pointer.getNext() != null) && (!found)) {
                    if (pointer.getNext().getElement() == element) {
                        found = true;
                        break;
                    }
                    pointer = pointer.getNext();
                }
                if (found) {
                    ObjectNode temp = pointer.getNext();
                    pointer.setNext(temp.getNext());
                    temp.setNext(null);

                    this.length--;
                } else {
                    System.out.println("El elemento no existe en la lista");
                }

            }
        }
    }

    /**
     * gets node by Index in the list
     *
     * @author isaac
     * @param pos (int)
     * @return ObjectNode
     */
    public ObjectNode getNodeByIndex(int pos) {
        if (!isEmpty()) {
            ObjectNode pointer = getHead();
            for (int i = 0; i < pos; i++) {
                if (pointer.getNext() == null) {
                    break;
                }
                pointer = pointer.getNext();
            }
            return pointer;
        } else {
            return null;
        }

    }

    /**
     * Orders the list in ascendig order
     *
     * @author isaac
     *
     */
    public void reorderListToAscending() {
        int originalLength = getLength();
        for (int i = 0; i < originalLength; i++) {
            ObjectNode lowestElementNode = getLowestValueNode(getNodeByIndex(i));
            deleteByElement(lowestElementNode.getElement());
            addInIndex(i, lowestElementNode.getElement());
        }
    }

    /**
     * returns the lowest value node in list
     *
     * @author isaac
     * @param auxHead (Head to start looping)
     * @return ObjectNode
     */
    public ObjectNode getLowestValueNode(ObjectNode auxHead) {
        ObjectNode pointer = auxHead;
        ObjectNode lowestElementNode = pointer;

        while (pointer.getNext() != null) {
            if ((int) lowestElementNode.getElement() > (int) pointer.getNext().getElement()) {
                lowestElementNode = pointer.getNext();
            }
            pointer = pointer.getNext();
        }

        return lowestElementNode;

    }

    /**
     * checks if the given element is in list, returns boolean
     *
     * @author isaac
     * @param element
     * @return boolean
     */
    public boolean isObjectInList(Object element) {
        ObjectNode pointer = getHead();
        boolean found = false;
        while (pointer != null) {
            if (pointer.getElement().equals(element)) {
                found = true;
                break;
            }
            pointer = pointer.getNext();
        }
        return found;
    }



}
