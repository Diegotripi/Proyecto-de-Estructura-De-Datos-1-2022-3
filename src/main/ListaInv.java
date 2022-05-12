/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class ListaInv {

    private NodoInv cabeza;
    private NodoInv fin;
    private int largo;

    public ListaInv() {
        this.cabeza = null;
        this.fin = null;
        this.largo = 0;
    }

    public NodoInv getCabeza() {
        return cabeza;
    }

    public NodoInv getFin() {
        return fin;
    }

    public int getLargo() {
        return largo;
    }

    public void setCabeza(NodoInv cabeza) {
        this.cabeza = cabeza;
    }

    public void setFin(NodoInv fin) {
        this.fin = fin;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    //Esta vacia o no
    public boolean estaVacio() {
        return cabeza == null;
    }

    //Agregar al inicio
    public void insertarCabeza(Producto cabeza) {
        NodoInv nodito = new NodoInv(cabeza);
        if (estaVacio()) {
            setCabeza(nodito);
            fin = nodito;

        } else {
            NodoInv aux = this.cabeza;
            nodito.setSiguiente(aux);
            setCabeza(nodito);
        }

        largo++;
    }

    //Agregar al final
    public void insertarFinal(Producto fin) {
        NodoInv nodito = new NodoInv(fin);
        if (estaVacio()) {
            setCabeza(nodito);
            this.fin = nodito;

        } else {
            NodoInv aux = this.cabeza;
            for (int i = 0; i < largo; i++) {
                if (aux.getSiguiente() == null) {
                    aux.setSiguiente(nodito);
                    this.fin = nodito;
                } else {
                    aux = aux.getSiguiente();
                }
            }
        }

        largo++;
    }

    //Agregar indice
    public void insertarIndice(int pos, Producto medio) {
        NodoInv nodito = new NodoInv(medio);
        int cont = 0;
        if (estaVacio()) {
            setCabeza(nodito);
            this.fin = nodito;

        } else {
            NodoInv aux = cabeza;
            while (cont < pos && aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
                cont += 1;
            }
            nodito.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nodito);

            if ((pos + 1) >= largo) {
                this.fin = nodito;
            }

            largo++;

        }

    }

    //Eliminar al inicio
    public void eliminarCabeza() {
        NodoInv aux = cabeza;
        if (largo ==1) {
            setCabeza(null);
            largo--;
        }
        else if (!estaVacio()) {
            aux = cabeza.getSiguiente();
            setCabeza(aux);
            this.cabeza = aux;
            largo--;
        }
    }

    //Eliminar final
    public void eliminarFinal() {
        NodoInv aux = cabeza;
        if (largo == 1) {
            eliminarCabeza();
        } else if (!estaVacio()) {
            for (int i = 0; i < largo; i++) {
                if (aux.getSiguiente().getSiguiente() == null) {
                    aux.setSiguiente(null);
                    this.fin = aux;
                    largo--;
                } else {
                    aux = aux.getSiguiente();
                }
            }

        }
    }

    //Eliminar Indice
    public void eliminarIndice(int pos) {
        int cont = 0;
        if (largo == 1) {
            eliminarCabeza();
        }else if(largo <= (pos+1)){
            eliminarFinal();
        }
        else if (!estaVacio()) {
            NodoInv aux = cabeza;
            while (cont < pos && aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
                cont += 1;
            }
            aux.setSiguiente(aux.getSiguiente().getSiguiente());


            largo--;
        }

    }

//Imprimir autor
    public void imprimirCantidad() {
        NodoInv aux = cabeza;
        if (!estaVacio()) {
            for (int i = 0; i < largo; i++) {
                System.out.println(aux.getElemento().getCantidad());
                aux = aux.getSiguiente();
            }
        }
    }

    //Imprimir nombre
    public void imprimirNombre() {
        NodoInv aux = cabeza;
        if (!estaVacio()) {
            for (int i = 0; i < largo; i++) {
                System.out.println(aux.getElemento().getNombre());
                aux = aux.getSiguiente();
            }
        }
    }
    
    public void imprimirInventario() {
        NodoInv aux = cabeza;
        if (!estaVacio()) {
            for (int i = 0; i < largo; i++) {
                System.out.println("\nProducto: "+ aux.getElemento().getNombre()+"\nCantidad: "+aux.getElemento().getCantidad()+"\n");
                
                aux = aux.getSiguiente();
            }
        }
    }

}
