/*Favor de Correr la clase TestIOStream.java*/
package Ejercicio6;

import java.io.*;
import java.util.Scanner;

public class TestIOStream {
    File outFile,inFile;
    FileOutputStream outStream;
    FileInputStream inStream;
    Scanner s=new Scanner(System.in);
    byte byteArray[]={10,20,30,40,50,60,70,80};
    
    void incio(){
        print("Crea un archivo binario");
        print("Lo guarda en el disco con el nombre Sample.data");
        print("Leer el archivo recien creado abriendolo del disco");
        print("Lo despliega en una pizarra en pantalla");
    }
    
    String capArchName(){
        String aux;
        do aux=s.next(); while(aux.length()<=0);
        return aux;
    }
    
    public void openOut(String name){
        outFile=new File(name);
        try{outStream=new FileOutputStream(outFile);}
        catch(FileNotFoundException fne){printError("NO SE CREO EL ARCHIVO");}
    }
    
    public void openIn(String name){
        inFile=new File(name);
        try{inStream=new FileInputStream(inFile);}
        catch(FileNotFoundException fnfe){printError("No existen el archivo");}
    }
    
    public void out(String arch) throws IOException{
        openOut(arch);
        //Write Data to the Stream
        outStream.write(byteArray);
        //output done, so close the stream
        outStream.close();
    }
    
    public void in(String arch)throws IOException{
        byte[] bytebuff = new byte[byteArray.length];
        openIn(arch);
        inStream.read(bytebuff);
        for (int i = 0; i < bytebuff.length; i++) 
            print(bytebuff[i]+" ");
        inStream.close();
    }
    
    public static void main(String[] args) {
        TestIOStream tfios=new TestIOStream();
        String archivo;
        
        tfios.incio();
        archivo=tfios.capArchName();
        try {
            tfios.out(archivo);
            tfios.in(archivo);
        } catch (IOException ioe) {
            tfios.printError("ERROR DE ENTRADA Y SALIDA");
        }
    }
    void print(String s){
        System.out.println(s);
    }
    void printError(String s){
        System.err.println(s);
    }
}
