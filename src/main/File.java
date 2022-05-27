package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mdetd
 */
public class File {

    /**
     * Read the file.txt
     *
     * @param direction
     * @return text
     */
    public String readFile(String direction) {
        String text = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direction));
            String temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {

                temp = temp + bfRead;

            }
            
            text = temp;
        } catch (Exception e) {
            System.err.println("No existe");

        }

        return text;
    }

    /**
     * Get vertice's number
     *
     * @param arInfo
     * @return number of vertices
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

    /**
     * Extract the txt information; Storage and routes
     *
     * @param arInfo
     * @param am
     * @return graph
     */
    public Graph getInfo(String arInfo, AdjMatrixGraph am) {

        Graph g1 = new Graph(am);
        ListStorage l2 = new ListStorage();
        g1.setStorage(l2);

        String[] arrayInfo = arInfo.split(";");
        for (int i = 0; i < arrayInfo.length; i++) {
            
            String auxiliar = arrayInfo[i];

            if (auxiliar.length() > 7) {
                auxiliar = auxiliar.substring(0, 7);
            }

            if (arrayInfo[i].equalsIgnoreCase("Rutas")) {
                String chain = arrayInfo[i + 1];
                int kar = 0;
                String from = "";
                String to = "";
                int ll = 0;
                for (int j = 0; j < chain.length(); j++) {
                    if (chain.charAt(j) == ',') {
                        from = chain.substring(0, j);

                        for (int l = j + 1; l < chain.length(); l++) {

                            if (chain.charAt(l) == ',') {
                                to = chain.substring(j + 1, l);

                                ll = l;
                                break;
                            }
                        }

                        for (int k = ll; k < chain.length() - j; k++) {

                            try {
                                Integer.parseInt(Character.toString(chain.charAt(j + k + 1)));
                            } catch (Exception e) {
                                kar = ll + k;
                                break;

                            }

                        }       
                        int coste = Integer.parseInt(chain.substring(ll + 1, kar - 1));

                        chain = chain.substring(kar - 1);

                        j = 0;
                        kar = 0;
                        ll = 0;
//                        System.out.println(from + " " + to + " " + coste);
                        int numerofrom = g1.getStorageNumber(from);
                        int numeroto = g1.getStorageNumber(to);
                        am.addEdge(numerofrom, numeroto, coste);
                    }

                }
                break;
            } else if (arrayInfo[i].equalsIgnoreCase("Almacenes")) {

            } else if (auxiliar.equalsIgnoreCase("Almacen")) {
                ListInv l1 = new ListInv();

                String[] arrayInvent = arrayInfo[i].split(":");
                String oracion = arrayInvent[1];
                //System.out.println(arrayInfo[i]);
                String name = arrayInvent[0];

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
                        Product p1 = new Product(amount, product);
                        l1.addHead(p1);

                    }
                }

                g1.createStorage(l1, name);

            }
        }

        return g1;

    }
    

    public void writeFile(Graph g,String direction){
        String info = "Almacenes;";
        NodeStorage aux = g.getStorageList().getHead();
        String[] storage = new String[g.getCounter()];
        for (int i = 0; i < g.getCounter(); i++) {
            info += "\n"+aux.getStorage().getName()+":";
            String[] arrayAux = aux.getStorage().getName().split(" ");
            storage[i] = arrayAux[1];
            for (int j = 0; j < aux.getStorage().getInventory().getLength(); j++) {
                info += "\n"+aux.getStorage().getInventory().getElementInIndex(j).getName()+","+aux.getStorage().getInventory().getElementInIndex(j).getQuantity();
                if (j ==aux.getStorage().getInventory().getLength()-1 ) {
                    info += ";";
                    
                }
            }
            aux = aux.getNext();
            
        }
        
        info += "\nRutas;";
        int[][] matrix = g.getAdjMatrix().getMatrix();
        
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage.length; j++) {
                if (matrix[i][j] !=0) {
                    info += "\n"+storage[i]+","+storage[j]+","+matrix[i][j];
                }
                
                
            }
            //System.out.println(storage[i]);
        }
       



//        System.out.println(info);
        
        try{
            PrintWriter pw = new PrintWriter(direction);
            pw.print(info);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitoso");      
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
