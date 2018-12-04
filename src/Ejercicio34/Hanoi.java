package Ejercicio34;

import java.util.Scanner;

public class Hanoi {
    Stack [] palo;             
    int nDiscos;        
    Scanner leer = new Scanner(System.in);
    
    void meta(){
        System.out.println("Problema de aplicacion de Pilas(Stack)");
        System.out.println("Utilizando las torres de Hanoi");
    }

    int numeroDiscos(){
        System.out.print("Ingresa Numero de Discos: ");
        nDiscos = leer.nextInt();
        return nDiscos;
    }

    void resultados (int n) {
	palo = new Stack[4]; 
	for (int i = 1; i < 4; i++)
	    palo[i] = new Stack();
	for (int i = n; i > 0; i--)
	    palo[1].push(i);
	System.out.println("Las torres inicialmente tienen ");
	pinta();
	solucion(nDiscos, 1, 2, 3);
    }

    public void pinta () {
	java.util.Iterator it1 = palo[1].iterador();
	java.util.Iterator it2 = palo[2].iterador();
	java.util.Iterator it3 = palo[3].iterador();

	System.out.println("Palo1 \t\t Palo2 \t\t Palo3");
	for(int i = 0; i < nDiscos; i++) {
	    if (it1.hasNext())
		pintaDisco(((Integer)it1.next()));
	    else System.out.print("  \t\t");

	    if (it2.hasNext())
		pintaDisco(((Integer)it2.next()));
	    else System.out.print("  \t\t");

	    if (it3.hasNext())
		pintaDisco(((Integer)it3.next()));
	    System.out.println();
	}
    }

    private void pintaDisco(int n){
	for (int i=0; i < n; i++)
	    System.out.print("*");
	System.out.print("\t\t");
    }

    private void solucion (int n, int p1, int p2, int p3) {
	if (n > 0) {
	    solucion(n-1, p1, p3, p2);
	    Object disco = palo[p1].pop();
	    palo[p2].push(disco);
	    pinta();
	    solucion(n-1, p3, p2, p1);
	}
    }
    
    public void navegabilidad(){
        String op;
        
        do{
            resultados(numeroDiscos());
            System.out.print("Quieres intentar de nuevo?[s/n]: ");
            op = leer.next();
        }while(op.equalsIgnoreCase("s"));
    }

    public static void main (String [] pps) {
        Hanoi h = new Hanoi();
        
        h.meta();
        h.navegabilidad();
    }
}
