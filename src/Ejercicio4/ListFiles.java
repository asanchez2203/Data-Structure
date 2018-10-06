/*
Ejericio 4
 */
package Ejercicio4;

import java.io.*;
import java.util.Scanner;

public class ListFiles {

    public static void main(String[] args) {
         Scanner leer = new Scanner(System.in);
         
         //Obtiene una lista de todos los archivos en el directorio actual
         File currentDirectory = new File(".");
         String[] fileNames = currentDirectory.list();
         
         //Muestra cada nombre en la lista
         for (int i = 0; i < fileNames.length; i++) {
             System.out.println(fileNames[i]);
        }
    }
    
}
