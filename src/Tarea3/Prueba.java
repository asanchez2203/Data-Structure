package Tarea3;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

public class Prueba {
    FileWriter fw;
    BufferedWriter bw;
    FileReader r;
    BufferedReader br;
    static String path = "diary/";
    char c;
    String text = "", date;
    Scanner leer = new Scanner(System.in);

    void out(String s) {System.out.print(s);}

    void err(String s) {System.err.println(s);}

    void meta() {
        out("Analizar las clases BufferedWriter y BufferedReader\n");
        out("Utilizando flujos de entrada y salida en forma de canal\n");
        out("aplicandolas a un problema, en este caso, un diario secreto\n");
    }

    void navegabilidad() throws IOException {
        String aux, d = "", t = "", r;
        int op;    
        do {
            out("\n¿Qué deseas hacer?\n");
            do {
                out("1.- Escribir una nueva pagina\n");
                out("2.- Escribir en una pagina ya existente\n");
                out("3.- Leer una pagina\n");
                out("Respuesta: ");
                aux = leer.nextLine();
            } while (!isNum(aux));
            op = Integer.parseInt(aux);
            switch (op) {
                case 1:
                    d = fecha();
                    t = entryText();
                    write(d, t);
                    break;
                case 2:
                    d = entryDate();
                    t = entryText();
                    write(d, t);
                case 3:
                    read(entryDate());
                    break;
                default:
                    err("Opcion no valida: ");
                    break;
            }
            out("\nDeseas realizar otra accion?[s/n]:  ");
            r = leer.nextLine();
        } while (r.equalsIgnoreCase("s"));
    }
    
    public String entryText(){
        out("Ingresa el texto: \n");
        text = leer.nextLine();
        return text;
    }
    
    public String entryDate(){
        String d, m, y;
        
        do{
            out("\nIngresa el dia: ");
            d = leer.nextLine();
        }while(!isDay(d));
        do{
            out("Ingresa el mes: ");
            m = leer.nextLine();
        }while(!isMonth(d));
        do{
            out("Ingresa el año: ");
            y = leer.nextLine();
        }while(!isNum(d));
        return date = d + m + y;
    }  

    void openOutFile(String fecha) throws IOException {
        fw = new FileWriter(path + fecha + ".diary",true);
        bw = new BufferedWriter(fw);
    }
    
    void openInFile(String s) {
        try {
            r = new FileReader(path + s + ".diary");
            br = new BufferedReader(r);
        } catch (FileNotFoundException ex) {
            err("File not found");
        }
    }

    void write(String d, String t) throws IOException {
        try {
            openOutFile(d);
            for (int i = 0; i < t.length(); i++) {
                byte b = (byte) t.charAt(i);
                bw.write(b+20);
            }
            bw.flush();
        } catch (IOException ex) {
            err("Can't Write Into The File: " + ex.getMessage());
        } finally {
            fw.close();
            bw.close();
        }
    }

    void read(String s) throws IOException {
        openInFile(s);
        int i;
        String res = "";  
        while ((i = br.read()) != -1) {
            c = (char) (i-20);
            res+=c;
        }
        br.close();
        r.close();
        out("\n" + res);
    }

    public String fecha(){
        Calendar c = Calendar.getInstance();
        String d, m, a;
        
        d = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
        m = Integer.toString(c.get(Calendar.MONTH) + 1);
        a = Integer.toString(c.get(Calendar.YEAR));
        
        date = d + m + a;
        return date;
    }
    
    boolean isNum(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            err("Ingresa un numero valido");
            return false;
        }
    }
    
    boolean isDay(String s){
        try{
            int n;
            n=Integer.parseInt(s);
            if(n>0&&n<=31) return true;
            else {
                err("Ingresa un día válido");
                return false;
            }
        }catch(NumberFormatException e){
            err("Ingresa un numero valido");
            return false;
        }
    }
    
    boolean isMonth(String s){
        try{
            int n;
            n=Integer.parseInt(s);
            if(n>0&&n<=12) return true;
            else {
                err("Ingresa un mes válido");
                return false;
            }
        }catch(NumberFormatException e){
            err("Ingresa un numero valido");
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        Prueba p = new Prueba();
        p.meta(); 
        p.navegabilidad();     
    }
    
}