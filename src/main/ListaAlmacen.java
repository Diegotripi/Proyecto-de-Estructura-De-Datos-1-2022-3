/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class ListaAlmacen {

    private NodoAlmacen cabeza;
    private NodoAlmacen fin;
    private int largo;

    public ListaAlmacen() {
        this.cabeza = null;
        this.fin = null;
        this.largo = 0;
    }

    public NodoAlmacen getCabeza() {
        return cabeza;
    }

    public NodoAlmacen getFin() {
        return fin;
    }

    public int getLargo() {
        return largo;
    }

    public void setCabeza(NodoAlmacen cabeza) {
        this.cabeza = cabeza;
    }

    public void setFin(NodoAlmacen fin) {
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
    public void insertarCabeza(Almacen cabeza) {
        NodoAlmacen nodito = new NodoAlmacen(cabeza);
        if (estaVacio()) {
            setCabeza(nodito);
            fin = nodito;

        } else {
            NodoAlmacen aux = this.cabeza;
            nodito.setSiguiente(aux);
            setCabeza(nodito);
        }

        largo++;
    }

    //Agregar al final
    public void insertarFinal(Almacen fin) {
        NodoAlmacen nodito = new NodoAlmacen(fin);
        if (estaVacio()) {
            setCabeza(nodito);
            this.fin = nodito;

        } else {
            NodoAlmacen aux = this.cabeza;
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
    public void insertarIndice(int pos, Almacen medio) {
        NodoAlmacen nodito = new NodoAlmacen(medio);
        int cont = 0;
        if (estaVacio()) {
            setCabeza(nodito);
            this.fin = nodito;

        } else {
            NodoAlmacen aux = cabeza;
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
        NodoAlmacen aux = cabeza;
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
        NodoAlmacen aux = cabeza;
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
            NodoAlmacen aux = cabeza;
            while (cont < pos && aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
                cont += 1;
            }
            aux.setSiguiente(aux.getSiguiente().getSiguiente());


            largo--;
        }

    }
    
    public NodoAlmacen obtenerIndice(int ind){
        NodoAlmacen aux = getCabeza();
        for (int i = 0; i < ind; i++) {
            aux = aux.getSiguiente();
        }
        return aux;
    }

}
