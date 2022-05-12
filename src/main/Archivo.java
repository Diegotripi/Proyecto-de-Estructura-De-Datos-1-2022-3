package main;


import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mdetd
 */
public class Archivo {
    
    public String leerArchivo(String direccion){
        String texto = "";
        
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine())!= null){
            
            temp = temp + bfRead;
            
        }
            texto = temp;
        }catch(Exception e){
            System.err.println("No existe");
            
        }
        
        return texto;
    }
    /*
        Cuenta el numero de vertices en el grafo
         */
    public int numVertices(String arInfo) {
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
    
    
        
    
    
     public Graph extraerDatos(String arInfo, AdjMatrixGraph am){
        
        Graph g1 = new Graph(am);
        ListaAlmacen l2 = new ListaAlmacen();
        g1.setAlmacen(l2);

        String[] arrayInfo = arInfo.split(";");
        for (int i = 0; i < arrayInfo.length; i++) {
            
            String prueba = arrayInfo[i];
            
            if(prueba.length()>7){
                prueba = prueba.substring(0,7);
            }
            
            
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

            } else if(prueba.equalsIgnoreCase("Almacen")){
                ListaInv l1 = new ListaInv();
                
                String[] arrayInvent = arrayInfo[i].split(":");
                String oracion = arrayInvent[1];
                //System.out.println(arrayInfo[i]);
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
    
    
    
}
