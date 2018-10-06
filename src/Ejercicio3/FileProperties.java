/*
Ejercicio 3
Favor de teclear, guardar, compilar, depurar y correr la clase 
FilePropertiers.java de K.N. King, Chapter 14, pag. 610
(Java programming from the begining)
 */
package Ejercicio3;

import java.io.*;
import java.util.Scanner;

public class FileProperties {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        //El usuario ingresa el nombre del archivo
        System.out.println("Enter a file name: ");
        String filename = leer.next();
        
        //Crear el objeto file
        File f = new File(filename);
        
        //Mostrando propiedades del archivo
        if(f.canRead())
            System.out.println("El archivo puede leerse");
        if(f.canWrite())
            System.out.println("Se puede escribir en el archivo");
        if(f.exists())
            System.out.println("El archivo existe");
        if(f.isDirectory())
            System.out.println("El archivo es un directorio");
        if(f.isFile())
            System.out.println("El archivo es normal");
        System.out.println("Tamaño del archivo: " + f.length());
    }

}
