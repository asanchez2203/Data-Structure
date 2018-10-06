package Tarea2;

import java.util.Scanner;

public class Prueba {

    Scanner lector = new Scanner(System.in);
    Rational r1 = new Rational();
    Rational r2 = new Rational();
    Rational r3 = new Rational();
    int numero;
    String captura;
    int res;
    int numerador, denominador;

    public void meta() {
        print("Meta: Elabore un algoritmo que maneje las ");
        print("operaciones fundamentales de los números ");
        print("racionales implementado un TDA Rational\n");
    }

    public void navegabilidad() {
        System.out.println("****CALCULADORA DE FRACCIONES****");
        do {
            System.out.println("\n1.- Operaciones con dos Fracciones");
            System.out.println("2.- Operaciones con una fracción y un entero");
            System.out.println("3.- Comparacion de Fracciones");
            do {
                System.out.print("Teclea la opción que deseas hacer: ");
                captura = lector.next();
            } while (!validacion(captura));
            res = Integer.parseInt(captura);
            switch (res) {
                case 1:
                    capturaFracciones();
                    operacionesEntreFracciones();
                    break;
                case 2:
                    capturaFraccionNumero();
                    operacionesEntreFraccionNumero();
                    break;
                case 3:
                    capturaFracciones();
                    comparacionFracciones();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            System.out.println("\nIntroduzca 1 para continuar o 2 para salir");
            do{
                System.out.print("¿Su decicion es?: ");
                captura = lector.next();
            }while(!validacion(captura));
            res = Integer.parseInt(captura);
        }while(res == 1);
    
    }

    public void capturaFracciones() {
        do {
            System.out.print("\nIngresa numerador de fraccion 1: ");
            captura = lector.next();
        } while (!validacion(captura));
        numerador = Integer.parseInt(captura);
        do {
            System.out.print("Ingresa denominador de fraccion 1: ");
            captura = lector.next();
        } while (!validacion(captura));
        denominador = Integer.parseInt(captura);
        r1.set(numerador, denominador);
        do {
            System.out.print("\nIngresa numerador de fraccion 2: ");
            captura = lector.next();
        } while (!validacion(captura));
        numerador = Integer.parseInt(captura);
        do {
            System.out.print("Ingresa denominador de fraccion 2: ");
            captura = lector.next();
        } while (!validacion(captura));
        denominador = Integer.parseInt(captura);
        r2.set(numerador, denominador);
    }

    public boolean validacion(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Ingresa un numero entero");
            return false;
        }
    }

    public void capturaFraccionNumero() {
        do {
            System.out.print("\nIngresa numerador de fraccion 1: ");
            captura = lector.next();
        } while (!validacion(captura));
        numerador = Integer.parseInt(captura);
        do {
            System.out.print("Ingresa denominador de fraccion 1: ");
            captura = lector.next();
        } while (!validacion(captura));
        denominador = Integer.parseInt(captura);
        r1.set(numerador, denominador);
        do {
            System.out.print("\nIngresa numero entero: ");
            captura = lector.next();
        } while (!validacion(captura));
        numero = Integer.parseInt(captura);
    }

    public void operacionesEntreFracciones() {
        r3.addition(r1, r2);
        print("\nLa suma es: ", r3);
        r3.subtraction(r1, r2);
        print("La resta es: ", r3);
        r3.multiplication(r1, r2);
        print("La multiplicación es: ", r3);
        r3.division(r1, r2);
        print("La division es: ", r3);
    }

    public void operacionesEntreFraccionNumero() {
        r3.addition(r1, numero);
        print("\nLa suma es: ", r3);
        r3.subtraction(r1, numero);
        print("La resta es: ", r3);
        r3.multiplication(r1, numero);
        print("La multiplicación es: ", r3);
        r3.division(r1, numero);
        print("La division es: ", r3);
        r2.assignment(r1);
        r1.exponentation(numero);
        print("La fraccion exponenciada es: ", r1);
        r2.negation();
        print("La negacion es ", r2);
    }

    public void comparacionFracciones() {
        print("\nLa comparacion == (equals) es: ", r1.equals(r2));
        print("La comparacion > (greater) es: ", r1.greater(r2));
        print("La comparacion <(less) es: ", r1.less(r2));
        print("La comparacion >=(greater equals) es: ", r1.greaterEquals(r2));
        print("La comparacion <=(less equals) es: ", r1.lessEquals(r2));
        print("La comparacion !=(not equals) es: ", r1.notEquals(r2));
    }

    private void print(String concepto, Rational r3) {
        System.out.println(concepto + r3.print());
    }

    private void print(String concepto, boolean valor) {
        System.out.println(concepto + valor);
    }

    private void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Prueba p = new Prueba();
        p.meta();
        p.navegabilidad();
    }
}