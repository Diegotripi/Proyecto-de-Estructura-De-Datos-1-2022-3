/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author mdetd
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        /*Recomiendo que este main pase a ser una clase con metodos que permita la extraccion de 
        Informacion asi como armar el grafoooos
         */
        int v = 0;
        String direccion = "C:\\Users\\mdetd\\Documents\\NetBeansProjects\\PracticaGrafos\\src\\Direccion Archivo\\Almacenes.txt";
        Archivo a = new Archivo();
        String arInfo = a.leerArchivo(direccion);
        /*
        Cuenta el numero de vertices en el grafo
         */
        v = numVertices(arInfo);
        AdjMatrixGraph am = new AdjMatrixGraph(v);

        /*
        La funcion extraer se configuro tal que si son mas o menos almacenes esta lo detecte
        Puede hacerse mas eficiente
         */
        Graph g1 = extraerDatos(arInfo, am);

//      Probar como se imprime la matriz
        g1.getMatrix().printGraph();

//        Probar la impresion de los almacenes y sus inventarios
        g1.nombreAlmacen(0);
        g1.obtenerInventario(0);
        g1.nombreAlmacen(1);
        g1.obtenerInventario(1);
        g1.nombreAlmacen(2);
        g1.obtenerInventario(2);
        g1.nombreAlmacen(3);
        g1.obtenerInventario(3);
        g1.nombreAlmacen(4);
        g1.obtenerInventario(4);
    }

    public static Graph extraerDatos(String arInfo, AdjMatrixGraph am) {

        Graph g1 = new Graph(am);

        String[] arrayInfo = arInfo.split(";");
        for (int i = 0; i < arrayInfo.length; i++) {
            if (arrayInfo[i].equalsIgnoreCase("Rutas")) {
                String cadena = arrayInfo[i + 1];
                int kar = 0;
                String origen = "";
                String destino = "";
                int ll = 0;
                for (int j = 0; j < cadena.length(); j++) {
                    if (cadena.charAt(j) == ',') {
                        origen = cadena.substring(0, j);

                        for (int l = j + 1; l < cadena.length(); l++) {

                            if (cadena.charAt(l) == ',') {
                                destino = cadena.substring(j + 1, l);

                                ll = l;
                                break;
                            }
                        }

                        for (int k = ll; k < cadena.length() - j; k++) {

                            try {
                                Integer.parseInt(Character.toString(cadena.charAt(j + k + 1)));
                            } catch (Exception e) {
                                kar = ll + k;
                                break;

                            }

                        }
                        int coste = Integer.parseInt(cadena.substring(ll + 1, kar - 1));

                        cadena = cadena.substring(kar - 1);

                        j = 0;
                        kar = 0;
                        ll = 0;
//                        System.out.println(origen + " " + destino + " " + coste);
                        int numeroOrigen = g1.buscarNumeroAlmacen(origen);
                        int numeroDestino = g1.buscarNumeroAlmacen(destino);
                        am.addedge(numeroOrigen, numeroDestino, coste);
                    }

                }
                break;
            } else if (arrayInfo[i].equalsIgnoreCase("Almacenes")) {

            } else {
                ListaInv l1 = new ListaInv();
                String[] arrayInvent = arrayInfo[i].split(":");
                String oracion = arrayInvent[1];
                String nombre = arrayInvent[0];

//                System.out.println("\n");
                int kar = 0;
                for (int j = 0; j < oracion.length(); j++) {
                    if (oracion.charAt(j) == ',') {
                        String product = oracion.substring(0, j);
                        for (int k = 0; k < oracion.length() - j; k++) {

                            try {
                                Integer.parseInt(Character.toString(oracion.charAt(j + k + 1)));
                            } catch (Exception e) {
                                kar = j + k;

                                break;
                            }
                        }
                        int amount = Integer.parseInt(oracion.substring(j + 1, kar + 1));
                        oracion = oracion.replace(product + "," + oracion.substring(j + 1, kar + 1), "");
                        j = 0;
                        kar = 0;

//                        System.out.println(product + " " + amount);
                        Producto p1 = new Producto(amount, product);
                        l1.insertarCabeza(p1);

                    }
                }
                g1.almacen(l1, nombre);

            }
        }

        return g1;

    }

    public static int numVertices(String arInfo) {
        int v = 0;
        String[] arrayInfo = arInfo.split(";");
        for (int i = 0; i < arrayInfo.length; i++) {
            if (arrayInfo[i].equalsIgnoreCase("Rutas")) {
                break;
            } else if (arrayInfo[i].equalsIgnoreCase("Almacenes")) {

            } else {
                v = i;

            }

        }
        return v;
    }
}
