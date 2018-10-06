package Ejercicio2;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Menu();
    }
    
    static void Menu(){
        System.out.println("INGRESA LA BASE DEL NUMERO A INGRESAR: ");
        System.out.println("1.- Binario");
        System.out.println("2.- Octal");
        System.out.println("3.- Decimal");
        System.out.println("4.- Hexadecimal");
        System.out.println("5.- Salir");
        int numeroD;
        String numero;
        int opcion=new Scanner(System.in).nextInt();
        numero=new Scanner(System.in).next();
        try {
            switch(opcion){
                case 1:numeroD=Integer.parseInt(numero,2);
                    System.out.println("1.- Binario "+convertir(numeroD, 2));
                    System.out.println("2.- Octal "+convertir(numeroD, 8));
                    System.out.println("3.- Decimal "+convertir(numeroD, 10));
                    System.out.println("4.- Hexadecimal "+convertir(numeroD, 16));
                break;
                case 2:numeroD=Integer.parseInt(numero,8); 
                    System.out.println("1.- Binario "+convertir(numeroD, 2));
                    System.out.println("2.- Octal "+convertir(numeroD, 8));
                    System.out.println("3.- Decimal "+convertir(numeroD, 10));
                    System.out.println("4.- Hexadecimal "+convertir(numeroD, 16));
                break;
                case 3:numeroD=Integer.parseInt(numero); 
                    System.out.println("1.- Binario "+convertir(numeroD, 2));
                    System.out.println("2.- Octal "+convertir(numeroD, 8));
                    System.out.println("3.- Decimal "+convertir(numeroD, 10));
                    System.out.println("4.- Hexadecimal "+convertir(numeroD, 16));
                break;
                case 4:numeroD=Integer.parseInt(numero,16); 
                    System.out.println("1.- Binario "+convertir(numeroD, 2));
                    System.out.println("2.- Octal "+convertir(numeroD, 8));
                    System.out.println("3.- Decimal "+convertir(numeroD, 10));
                    System.out.println("4.- Hexadecimal "+convertir(numeroD, 16));
                break;
                default: break;
            }
        } catch (NumberFormatException e) {
            System.err.println("EL numero ingresado no corresponda a la base elegida");
        }
    }
    
    static String convertir(int numero, int base) {
        String numeroConvertido = ""; int modulo;
        while (numero > 0) {
            modulo = numero % base;
            switch (modulo) {
                case 0:numeroConvertido = "0" + numeroConvertido;break;
                case 1:numeroConvertido = "1" + numeroConvertido;break;
                case 2:numeroConvertido = "2" + numeroConvertido;break;
                case 3:numeroConvertido = "3" + numeroConvertido;break;
                case 4:numeroConvertido = "4" + numeroConvertido;break;
                case 5:numeroConvertido = "5" + numeroConvertido;break;
                case 6:numeroConvertido = "6" + numeroConvertido;break;
                case 7:numeroConvertido = "7" + numeroConvertido;break;
                case 8:numeroConvertido = "8" + numeroConvertido;break;
                case 9:numeroConvertido = "9" + numeroConvertido;break;
                case 10:numeroConvertido = "A" + numeroConvertido;break;
                case 11:numeroConvertido = "B" + numeroConvertido;break;
                case 12:numeroConvertido = "C" + numeroConvertido;break;
                case 13:numeroConvertido = "D" + numeroConvertido;break;
                case 14:numeroConvertido = "E" + numeroConvertido;break;
                case 15:numeroConvertido = "F" + numeroConvertido;break;
                default:break;
            }
            numero = numero / base;
        }
        return numeroConvertido;
    }
    
    static int convertirADecimal(int numero,int base){
        int ctd=0,total=0,modulo;
        while(numero>0){
            modulo=numero%10;
            numero=numero/10;
            total=total+(modulo*(int)Math.pow(base,ctd));
            ctd++;
        }
        return total;
    }
    
}
