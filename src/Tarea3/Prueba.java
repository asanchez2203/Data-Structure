package Tarea3;

import java.io.*;

public class Prueba {

    FileWriter fw;
    BufferedWriter bw;
    FileReader r;
    BufferedReader br;
    static String path = "diary/d.diary";
    char c;

    void out(String s) {
        System.out.println(s);
    }

    void outE(String s) {
        System.err.println(s);
    }

    void meta() {
        out("Crear un diario secreto, en el cual, la información ");
        out("se almacene y persista en archivos de texto encriptados");
    }

    void navegabilidad() {

    }

    void calculos() {

    }

    void resultados() {

    }

    void datos() {

    }

    void openOutFile() throws IOException {
        fw = new FileWriter(path);
        bw = new BufferedWriter(fw);
    }

    void openInFile() {
        try {
            r = new FileReader(path);
            br = new BufferedReader(r);
        } catch (FileNotFoundException ex) {
            outE("File not found");
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
            outE("Can't Write Into The File: " + ex.getMessage());
        } finally {
            fw.close();
            bw.close();
        }
    }

    void read() throws IOException {
        openInFile();
        int i;
        String res = "";
        while ((i = br.read()) != -1) {
            c = (char) (i-20);
            res+=c;
        }
        br.close();
        r.close();
        out(res);
    }

    public static void main(String[] args) throws IOException {
        Prueba p = new Prueba();
        p.meta();
        /*p.datos();
        p.calculos();
        p.resultados();*/
        p.write("HOLA :D");
        p.read();
    }

}
