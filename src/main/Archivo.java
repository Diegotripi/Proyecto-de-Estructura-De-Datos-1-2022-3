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
    
}
