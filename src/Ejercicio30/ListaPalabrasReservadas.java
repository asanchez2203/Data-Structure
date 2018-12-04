package Ejercicio30;

import java.io.StreamTokenizer;
import java.io.*;
import java.util.Scanner;

public class ListaPalabrasReservadas {

    String[] palabras;
    String[] lenguajes={"Java.txt","C#.txt","c++.txt","Python.txt"};
    int[] size={50,76,73,31};
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
    
    void imprimeResultados() throws IOException{ lisId.imprimir();}
    
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
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    void navegabilidad() throws IOException{
        do{
           palabrasReservadas(escogerLenguaje());
           leerRutaArchivo();
           ComparaPalabras();
           switch(escogerSalida()){
               case 1: imprimeResultados(); break;
               case 2: out("Nombre de archivo: ");
                       guardarEnArchivo(sc.nextLine());
                        break;
           }
           out("¿Desea intentarlo de nuevo? s/n");
           seguir=sc.nextLine();
        }while(seguir.equalsIgnoreCase("s"));
    }
    
    void guardarEnArchivo(String s) throws IOException{
        lisId.guardarEnArchivo(s);
    }
    
    int escogerLenguaje(){
        String opcion;
        int op=0;
        
        out("1.- JAVA");
        out("2.- C#");
        out("3.- C++");
        out("4.- Python");
        do{
            out("Su elección: ");
            opcion=sc.nextLine();
            if(isNum(opcion)) op=Integer.parseInt(opcion);
        }while(op<0 && op>5);
        return op;
    }
    
    int escogerSalida(){
        String opc;
        int op=0;
        
        out("1.- Ver en consola");
        out("2.- Guardar en un archivo");
        do{
            out("Su elección: ");
            opc=sc.nextLine();
            if(isNum(opc)) op=Integer.parseInt(opc);
        }while(op<0&&op>3);
        return op;
    }
    
    public static void main(String[] args) throws IOException {
        ListaPalabrasReservadas ls=new ListaPalabrasReservadas();
        ls.meta();
        ls.navegabilidad();
    }

}
