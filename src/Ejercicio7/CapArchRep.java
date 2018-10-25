/*Lo mismo del ejercicio 6 ahora con CapArchRep.java

1.- Meta: Permite ver que los archivos solo significan lo que se desea
     interpetar de ellos, leyendo datos en binario como chars o como numeros,
     guardandolos en un archivo binario y luego leyendo su contenido y
     desplegando en pantalla con el formato leído.
     (ojo cada fromato es solo la interpretación de los mismos datos).

2.- Datos: ir al 5
    2.1 leeBinEsChar() empezar
            escribe("deme un numero de 32 bits en binario:"); num=?
            guardarComoChar(0-15);
            guardarComoChar(16-31);
            Termiar
    2.2 leeCharEsArch() empezar
            escribe("deme un char: "); m=?
            escribe("deme otro char: "); n=?
            guardaComoChar(m);
            guardaComoChar(n);
            Terminar
    2.3 leeShortEsArch() empezar
            escribe("deme un numero short: "); n=?
            escribe("deme otro numero short: "); m=?
            guardaComoShort(m);
            guardaComoShort(n);
            Terminar
    2.4 leeIntEsArch() empezar
            escribe("deme un numero entero: "); n=?
            guardaComoInt(n);
            Terminar
    2.5 leeFloatEsArch() empezar
            escribe("deme un numero float: "); n=?
            guardaComoFloat(n);
            Terminar

3.- No hay Calculos

4.-Resultados: empezar
    AbrirArch(entrada);
    n=leerArch(entrada)
    m=leerArch(entrada)
    escribe("en binario:"+bitpatterns(m))
    escribe("en binario:"+bitpatterns(n))
    escribe("como char:"+m+" "+n)
    escribe("Short:"+toShort(m,n))
    escribe("Entero:"+toInt(m,n))
    escribe("Flotante:"+toFloat(m,n))
    cierrArch(entrada);
    terminar

5.-Navegabilidad. mostrar opciones
    hacer empezar
    escribir("Menu de Captura\n")
    escribir("Desea Captuar\n")
    escribir("1.- En binario")
    escribir("2.- En Caracter")
    escribir("3.- Numero Short")
    escribir("4.- Numero Entero")
    escribir("5.- Flotante")
    escribir("6.- Salir")
    escribe("Su elección: ")
    aux=t.nextLine();
    terminar while(!isNum(aux));
    segun (op) empezar
    caso 1: leeBinEsChArch(); break;
    caso 2: leeCharEsArch(); break;
    caso 3: leeShortEsArch(); break;
    caso 4: leeEntEsArch(); break;
    caso 5: leeFloatEsArch(); break;
    omision: escribe("Opciones validas 1-5");
    terminar
 */
package Ejercicio7;

import java.util.Scanner;
import java.io.*;

public class CapArchRep {

    Scanner t = new Scanner(System.in);
    FileOutputStream fw;
    DataOutputStream ds;//flujo de salida
    FileInputStream f;
    DataInputStream dis;//Flujo de Entrada
    String aux = "";
    char m, n;

    void abreSal() throws IOException {
        fw = new FileOutputStream("Data.mbd", false);
        ds = new DataOutputStream(fw);
    }

    void cierraSal() throws IOException {
        ds.close();
        fw.close();
    }

    void inicio() {
        System.out.println("Para ilustrar la interpretación");
        System.out.println("del formato de datos leidos del teclado");
        System.out.println("y guardados en un archivo");
    }

    boolean isNum(String cad) {
        try {
            Double.parseDouble(cad);
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Favor de introducir un numero");
            return false;
        }
    }

    public String bitPattern(short value) {
        short BIT1_MASK = 1;
        final char[] bits = new char[16];
        for (short i = 7; i >= 0; i--) {
            bits[i] = (value & BIT1_MASK) == 1 ? '1' : '0';
            value >>>= 1;
        }
        return new String(bits);
    }

    boolean isBin(String cad) {
        for (int i = 0; i < cad.length(); i++) {
            if (cad.charAt(i) != '0' && cad.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }

    int menu() {
        int op;
        do {
            System.out.println("Menu de Caputra");
            System.out.println("  Desea Capturar:");
            System.out.println("1.- En binario");
            System.out.println("2.- En caracter");
            System.out.println("3.- Numero Short");
            System.out.println("4.- Numero Entero");
            System.out.println("5.- Flotante");
            System.out.println("6.- Salir");
            System.out.print("Su Eleccion: ");
            aux = t.nextLine();
        } while (!isNum(aux));
        op = Integer.parseInt(aux);
        return op;
    }

    void captura() throws IOException {
        int op;
        if ((op = menu()) != 6) {
            switch (op) {
                case 1:
                    leeBinEsChArch();
                    break;
                case 2:
                    leeCharEsArch();
                    break;
                case 3:
                    leeShortEsChArch();
                    break;
                case 4:
                    leeEntEsChArch();
                    break;
                case 5:
                    leeFloatEsChArch();
                    break;
                default:
                    System.out.println("Opciones válidas 1-5");
            }
        }
    }

    int toInt(String s) {
        int n = 0;
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            n += (s.charAt(i) - '0') * Math.pow(2, j);
        }
        return n;
    }

    void leeBinEsChArch() { //Con c de la a a la z
        String entra = "";
        do {
            System.out.print("Dame un numero de 32 bits en Binario: ");
            entra = t.nextLine();
        } while (entra.length() != 32 || !isBin(entra));
        m = (char) toInt(entra.substring(0, 15));
        n = (char) toInt(entra.substring(16, 32));
        try {
            ds.writeChar(m);
            ds.writeChar(n);
        } catch (Exception e) {
            System.err.println("Hubo un error al escribir el archivo");
        }
    }

    void leeCharEsArch() { //leer 2 char
        System.out.print("Deme un caracter: ");
        aux = t.nextLine();
        if (aux.length() > 1) {
            m = aux.charAt(0);
            n = aux.charAt(1);
        } else {
            n = aux.charAt(0);
            System.out.print("Deme otro caracter: ");
            aux = t.nextLine();
            n = aux.charAt(0);
        }
        try {
            ds.writeChar(m);
            ds.writeChar(n);
        } catch (IOException e) {
            System.err.println("Excpetion While Save Characters");
        }
    }

    void leeShortEsChArch() { //lee 2 short
        short n, m;
        do {
            System.out.println("Dame un numero corto: ");
            aux = t.nextLine();
        } while (!isNum(aux));
        n = Short.parseShort(aux);
        do {
            System.out.println("Dame otro numero corto: ");
            aux = t.nextLine();
        } while (!isNum(aux));
        m = Short.parseShort(aux);
        try {
            ds.writeChar(m);
            ds.writeChar(n);
        } catch (IOException e) {
            System.err.println("Excpetion While Save Short Numbers");
        }
    }

    void leeEntEsChArch() throws IOException {
        int num;
        do {
            System.out.print("Deme un numero: ");
            aux = t.nextLine();
        } while (!isNum(aux));
        num = Integer.parseInt(aux);
        ds.writeInt(num);
    }

    void leeFloatEsChArch() throws IOException {
        Float num;
        do {
            System.out.print("Deme un numero flotante: ");
            aux = t.nextLine();
        } while (!isNum(aux));
        num = Float.parseFloat(aux);
        ds.writeFloat(num);
    }

    void abreArchivo() throws IOException {
        f = new FileInputStream("Data.mbd");
        dis = new DataInputStream((f));
    }

    void r3f(short n) {
        System.out.println("En el archivo hay numero con formato binario ");
        System.out.println(bitPattern(n));
        System.out.printf("el mismo como char es %c\n", n);
        System.out.printf("el mismo como numero corto es %d\n", n);
        System.out.printf("con formato decimal %d\n", n);
    }

    void reporta() throws IOException { //All formats
        short num, o;
        int n;
        float f;

        ds.close();
        abreArchivo();
        num = dis.readShort();
        r3f(num);
        o = dis.readShort();
        r3f(o);
        dis.close();
        abreArchivo();
        n = dis.readInt();
        System.out.println("El numero entero es: " + n);
        dis.close();

        abreArchivo();
        f = dis.readFloat();
        System.out.println("El numero flotante es: " + f);
        dis.close();
    }

    public static void main(String[] args) throws IOException {
        CapArchRep car = new CapArchRep();
        int opcion;
        car.inicio();

        while ((opcion = car.menu()) != 5) {
            car.abreSal();
            car.captura();
            car.reporta();
        }
        car.cierraSal();
    }
}
