package Tarea5;

import java.util.Scanner;

public class Prueba {
    Recta r=new Recta();
    Recta r2=new Recta();
    Scanner s=new Scanner(System.in);
    
    void out(String s){System.out.print(s);}
    
    void meta(){
        out("Elabore el algoritmo para probar y aprovechar las \n");
        out("prestaciones del ADT Recta.\n");
    }
    
    boolean isDouble(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Ingrese un número válido");
            return false;
        }
    }
    boolean isNum(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Ingrese un número válido");
            return false;
        }
    }
    
    void capturaEcuacion(Recta rec){
        String res;
        double a,b,c;
        do{       
            out("Ingrese el coeficiente de X: ");
            res=s.nextLine();
        }while(!isDouble(res));
        a=Double.parseDouble(res);
        do{       
            out("Ingrese el coeficiente de Y: ");
            res=s.nextLine();
        }while(!isDouble(res));
        b=Double.parseDouble(res);
        do{       
            out("Ingrese el valor de C: ");
            res=s.nextLine();
        }while(!isDouble(res));
        c=Double.parseDouble(res);
        rec.setA(a);
        rec.setB(b);
        rec.setC(c);
    }
    
    void imprimeRecta(Recta r){r.get();}
    
    void imprimeRectaPrestaciones(Recta r){
        out("\nLa intersección con el eje X es: ("+r.intersectionX() + ",0)\n");
        out("La intersección con el eje Y es: (0,"+r.intersectionY() + ")\n");
        out("La pendiente es: "+r.pendiente()+"\n");
        out("El ángulo de la pendiente es: "+r.anguloInclinacion()+"\n");
    }
    
    void comparacionRectas(){
        out("\nLas rectas son paralelas: "+r.esParalelo(r2));
        out("\nLas rectas son perpendiculares: "+r.esPerpendicular(r2));
    }
    
    void navegabilidad(){
        String seguir;
        do{
            String res;
            out("\nPrestaciones ADT Recta\n");
            out("1.-Capturar 2 rectas\n");
            out("2.-Salir\n");
            out("Su Elección: ");
            do res=s.nextLine(); while(!isNum(res));
            int opcion=Integer.parseInt(res);
            
            switch(opcion){
                case 1:
                    out("Ecuacion 1:\n");
                    capturaEcuacion(r);
                    out("Ecuacion 2:\n");
                    capturaEcuacion(r2);
                    out("\nEcuacion 1:\n");
                    imprimeRectaPrestaciones(r);
                    out("\nEcuacion 2:\n");
                    imprimeRectaPrestaciones(r2);
                    comparacionRectas();
                break;
                default:break;
            }
            out("\n¿Desea capturar de nuevo? [s/n] ");
            seguir=s.nextLine();
        }while(seguir.equalsIgnoreCase("s"));
    }
    
    public static void main(String[] args) {
        Prueba p=new Prueba();
        p.meta();
        p.navegabilidad();
    }
}
