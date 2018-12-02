package Ejercicio30;

import java.io.StreamTokenizer;
import java.io.*;

public class ListaPalabrasReservadas {
    
    public static boolean palRes(String palabra) {
        String[] palabras = {"abstract", "else", "interface", "static",
            "boolean", "extends", "long", "super",
            "break", "false", "main", "switch",
            "byte", "final", "native", "synchronized",
            "case", "finally", "new", "this",
            "catch", "float", "null", "throw",
            "char", "for", "package", "throws",
            "class", "if", "private", "true",
            "continue", "implements", "protected", "try",
            "default", "import", "public", "void",
            "do", "instanceof", "return", "volatile",
            "double", "int", "short", "while"};
        
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].equals(palabra)) {
                return true;
            }
        }
        return false;
    }
    
    public static void leerPalReservadas(String s) {
    }
    
    public static void main(String[] pps) {
        ListaDeIds lisId = new ListaDeIds();
        int tipoTok;
//
//        if (pps.length != 2) {
//            System.out.println("Uso: ListaPalabrasReservadas archivoFuente");
//            System.exit(0);
//        }
//        leerPalReservadas(pps[0]);
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Alexis Sánchez\\Documents\\NetBeansProjects\\Data-Structure\\src\\Ejercicio1\\Main.java"));
            StreamTokenizer tok = new StreamTokenizer(in);
            tok.ordinaryChar('.');
            tipoTok = tok.nextToken();
            
            while (tipoTok != StreamTokenizer.TT_EOF) {
                if (tipoTok == StreamTokenizer.TT_WORD) {
                    if (palRes(tok.sval)) {
                        lisId.insertar(tok.sval, new Integer(tok.lineno()));
                    }
                }
                tipoTok = tok.nextToken();
            }
            
            lisId.imprimir();
        } catch (IOException e) {
            System.out.println("Se genero IOException " + e);
        }
    }
}
