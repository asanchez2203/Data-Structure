package Tarea3;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

public class Prueba2 {

    FileWriter fw;
    BufferedWriter bw;
    FileReader r;
    BufferedReader br;
    static String path = "diary/";
    char c;
    String text = "", date;
    Scanner leer = new Scanner(System.in);

    void out(String s) {
        System.out.print(s);
    }

    void err(String s) {
        System.err.println(s);
    }

    void meta() {
        out("Analizar las clases BufferedWriter y BufferedReader\n");
        out("(Mostrar flujos de entrada y salida en forma de canal)\n");
        out("aplicandolas a un problema, en este caso, un diario secreto\n");
    }

    void navegabilidad() throws IOException{
        String aux;
        int op;
                
        do{
            out("Bienvenido: ¿Qué deseas hacer?\n");
            out("1.- Escribir una nueva pagina\n");
            out("2.- Leer una pagina\n");
            out("Respuesta: ");
            aux = leer.nextLine();
        }while(!isNum(aux));
        op = Integer.parseInt(aux);
        switch(op){
            case 1: 
                write(entryText());
                break;
            case 2:
                read(entryDate());
                break;
            default:
                err("Respuesta incorrecta: ");
                break;
        }
    }
    
    public String entryText(){
        out("Ingresa el texto: \n");
        text = leer.nextLine();
        return text;
    }
    
    public String entryDate(){
        String d, m, y;
        
        do{
            out("Ingresa el dia: ");
            d = leer.next();
        }while(!isNum(d));
        do{
            out("Ingresa el mes: ");
            m = leer.next();
        }while(!isNum(d));
        do{
            out("Ingresa el año: ");
            y = leer.next();
        }while(!isNum(d));
        return date = d + m + y;
    }  

    void openOutFile() throws IOException {
        fw = new FileWriter(path + fecha() + ".diary",true);
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

    void write(String s) throws IOException {
        try {
            openOutFile();
            for (int i = 0; i < s.length(); i++) {
                byte b = (byte) s.charAt(i);
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
        
        String fecha = d + m + a;
        return fecha;
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

    public static void main(String[] args) throws IOException {
        Prueba2 p = new Prueba2();
        p.meta(); 
        p.navegabilidad();     
    }
    
}
