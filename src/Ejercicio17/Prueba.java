package Ejercicio17;

import java.util.Scanner;

public class Prueba {

    Scanner s = new Scanner(System.in);
    String n;
    int number;
    String res;

    public void navegabilidad() {
        int num;
        out("Programa que obtiene el factorial ");
        out("en forma iterativa y recursiva");
        do {
            out("1.- Calcularlo de forma iterativa");
            out("2.- Calcularlo de forma recursiva");
            out("Su eleccion: ");
            do {
                res = s.nextLine();
            } while (!isNum(res));
            num = Integer.parseInt(res);

            switch (num) {
                case 1:
                    resultados(factorial(captura()));
                    break;
                case 2:
                    resultados(factorialR(captura()));
                    break;
                default:
                    System.err.println("Opcion inválida");
                    break;
            }          
            out("Desea continuar? 1-Si 2- No");
            res=s.nextLine();
        } while (res.equals("1"));

    }

    public int captura() {
        do {
            out("Ingresa El Numero para obtener el factorial: ");
            n = s.nextLine();
        } while (!isNum(n));
        number = Integer.parseInt(n);
        return number;
    }

    public void resultados(int n) {
        out("El factorial es: "+n);
    }

    boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Ingresa un numero valido");
            return false;
        }
    }

    private void out(String s) {
        System.out.println(s);
    }

    public int factorial(int n) {
        int factorial = 1;
        while (n != 0) {
            factorial = factorial * n;
            n--;
        }
        return factorial;
    }

    public int factorialR(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorialR(n - 1);
        }
    }
    
    public static void main(String[] args) {
        Prueba p=new Prueba();
        p.navegabilidad();
    }
}
