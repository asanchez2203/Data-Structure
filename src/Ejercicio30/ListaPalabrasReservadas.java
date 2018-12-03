package Ejercicio30;

import java.io.StreamTokenizer;
import java.io.*;
import java.util.Scanner;

public class ListaPalabrasReservadas {

    String[] palabras;
    String[] lenguajes={"Java.txt","C#.txt","c++.txt","Python.txt"};
    int[] size={50,76,73,31};
    int opcion;
    String filepath,seguir,opc;
    FileReader r;
    BufferedReader br;
    ListaDeIds lisId;
    Scanner sc=new Scanner(System.in);

    void out(String s) { System.out.println(s);}
    void err(String s) { System.err.println(s);}
    
    void meta(){
        out("Escriba un programa que pida al usuario la ruta de un archivo");
        out("de texto o codigo fuente para contabilizar y ubicar las palabras");
        out("no reservadas de un lenguaje de progrmacion");
    }

    void leerRutaArchivo() {
        boolean existe=false;
        do{
            out("Digite la ruta de su archivo");
            filepath=sc.nextLine();
            if(new File(filepath).exists()) existe=true;
            else err("El archivo no existe");
        }while(!existe);
    }

    boolean palRes(String palabra) {
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].equals(palabra)) {
                return true;
            }
        }
        return false;
    }

    void ComparaPalabras() {
        lisId = new ListaDeIds();
        int tipoTok;

        try {
            BufferedReader in = new BufferedReader(new FileReader(filepath));
            StreamTokenizer tok = new StreamTokenizer(in);
            tok.ordinaryChar('.');
            tipoTok = tok.nextToken();

            while (tipoTok != StreamTokenizer.TT_EOF) {
                if (tipoTok == StreamTokenizer.TT_WORD) 
                    if (!palRes(tok.sval)) 
                        lisId.insertar(tok.sval, tok.lineno());     
                tipoTok = tok.nextToken();
            }
        } catch (IOException e) {
            System.out.println("Se genero IOException " + e);
        }
    }
    
    void imprimeResultados(){ lisId.imprimir();}
    
    void openInFile(String s) {
        try {
            r = new FileReader(s);
            br = new BufferedReader(r);
        } catch (FileNotFoundException ex) {
            err("File not found");
        }
    }
    
    void palabrasReservadas(int i){
        openInFile(lenguajes[i]);
        palabras=new String[size[i]];
        for (int j = 0; j < size[i]; j++)
            try {
                palabras[j]=br.readLine();
            } catch (IOException ex) {
                err("IO Excpetion");
            }
    }
    
    boolean isNum(String s){
        try { 
            int opcion;
            opcion=Integer.parseInt(s);
            if(opcion<1&&opcion>4){
                err("Opcion inválida");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    void navegabilidad(){
        do{
            out("Escoja su lenguaje para comparar su archivo");
            out("1.- JAVA");
            out("2.- C#");
            out("3.- C++");
            out("4.- PYTHON");
            out("Su elección: ");
            do opc=sc.nextLine(); while(!isNum(opc));
            opcion=Integer.parseInt(opc);
            palabrasReservadas(opcion-1);
            
            leerRutaArchivo();
            ComparaPalabras();
            imprimeResultados();
            
            out("Desea hacerlo de nuevo? s/n");
            seguir=sc.nextLine();
        }while(seguir.equalsIgnoreCase("s"));
    }
    
    public static void main(String[] args) {
        ListaPalabrasReservadas ls=new ListaPalabrasReservadas();
        ls.meta();
        ls.navegabilidad();
    }

}
