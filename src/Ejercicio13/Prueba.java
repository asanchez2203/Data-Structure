package Ejercicio13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Prueba {
    
    Scanner s=new Scanner(System.in);
    Conjunto c1=new Conjunto();
    Conjunto c2=new Conjunto();
    FileWriter fw;
    BufferedWriter bw;
    FileReader r;
    BufferedReader br;
    static String path = "sets/";
    
    void out(String s){System.out.print(s);}
    void outE(String s){System.err.println(s);}
    void meta(){
        out("Favor de codificar la clase de prueba que implemente\n");
        out("los diseños del ejercicio 10 al 12\n");
    }
    
    String readName(){
        out("Escriba el nombre del conjunto: ");
        return s.nextLine();
    }
    String readItem(){
        out("Escriba item a agregar: ");
        return s.nextLine();
    }
    
    Conjunto readConjunto(Conjunto c){
        String seguir="";
        do {
            c.add(readItem());
            out("Desea Continuar? s/n: ");
            seguir=s.nextLine();
        }
        while(seguir.equalsIgnoreCase("s"));
        return c;
    }
    
    void mostrar(Conjunto c){
        for(Object o:c.getObjects())
            if(o!=null) out(o.toString()+"\n");
    }
    
    boolean isNum(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            outE("Digite un numero válido");
            return false;
        }
    }
    
    void operaciones(){
        out("Union entre C1 Y C2\n");
        mostrar(c1.union(c2));
        out("Interseccion entre C1 Y C2\n");
        mostrar(c1.intersection(c2));
        out("Diferencia entre C1 Y C2\n");
        mostrar(c1.difference(c2));     

        out("\nC2 es subconjunto de C1? :"+c1.isSubSet(c2));
        out("\nC1 es subconjunto de C2? :"+c2.isSubSet(c1)+"\n");
    }
    
    void navegabilidad() throws IOException{
        int op;
        String opcion;
        do{
            out("1.- Ingresa un nuevo conjunto a la lista\n");
            out("2.- Operar entre conjuntos\n");
            out("3.- Salir\n");
            out("Deme su elección: ");
            do opcion=s.nextLine(); while(!isNum(opcion));
            op=Integer.parseInt(opcion);
            switch(op){
                case 1:
                    c1.empty();
                    write(readName(),readConjunto(c1));   
                    break;
                case 2:
                    read(readName(), c1);
                    read(readName(), c2);
                    operaciones();
                    break;
                case 3:
                    break;
            }         
        }
        while(op!=3);
    }
    
    void openOutFile(String fecha) throws IOException {
        fw = new FileWriter(path + fecha + ".set",false);
        bw = new BufferedWriter(fw);
    }
    
    void openInFile(String s) {
        try {
            r = new FileReader(path + s + ".set");
            br = new BufferedReader(r);
        } catch (FileNotFoundException ex) {
            outE("File not found");
        }
    }

    void write(String d,Conjunto c) throws IOException {
        try {
            openOutFile(d);
            for(Object o:c.getObjects())
                if(o!=null) {
                    bw.write(o.toString());
                    bw.newLine();
                }
            bw.flush();
        } catch (IOException ex) {
            outE("Can't Write Into The File: " + ex.getMessage());
        } finally {
            fw.close();
            bw.close();
        }
    }

    void read(String s,Conjunto c) throws IOException {
        openInFile(s);
        int i;
        String res = "";  
        while ((res=br.readLine())!=null) {      
                c.add(res);
        }
        br.close();
        r.close();
    }
    
    public static void main(String[] args) throws IOException {
        Prueba p=new Prueba();
        p.meta();
        p.navegabilidad();
    }
}
