package Ejercicio5;

import java.io.*;
import java.util.Scanner;

public class RenameFiles {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        //Obtiene una lista de todos los archivos en el directorio actual
        File currentDirectory = new File(".");
        String[] fileNames = currentDirectory.list();

        //Procesa cada nombre en la lista
        for (int i = 0; i < fileNames.length; i++) {

            //Pregunta que archivo se va a renombrar
            System.out.println("Rename " + fileNames[i] + "[y/n]?: ");
            String response = leer.next();

            //Si la respuesta es s o f, preguntar por el nuevo nombre
            //entonces llamar a renameTo
            if (response.equalsIgnoreCase("y")) {
                System.out.println("Ingresar nuevo nombre: ");
                String newName = leer.next();
                File oldFile = new File(fileNames[i]);
                File newFile = new File(newName);
                boolean succesful = oldFile.renameTo(newFile);
                if (!succesful) {
                    System.out.println("No se pudo renombrar "
                            + fileNames[i] + " como " + newName);
                }
            }
        }

    }

}
