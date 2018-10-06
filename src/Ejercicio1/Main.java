package Ejercicio1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Ingresa un numero en base 10 entero");
        try {
            int numero = new Scanner(System.in).nextInt();
            System.out.println("BINARIO: "+ convertir(numero, 2));
            System.out.println("OCTAL: "+ convertir(numero, 8));
            System.out.println("HEXADECIMAL: "+convertir(numero, 16));
        } catch (Exception e) {
            System.err.println("Ingresa un numero sin letras ni decimales");
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
}
