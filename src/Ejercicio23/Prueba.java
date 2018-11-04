package Ejercicio23;

import java.util.Scanner;

public class Prueba {
    
    int n;
    int tablero[][];
    int jugada = 0;
    int xc[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
    int yc[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
    Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        Prueba kt = new Prueba();
        
        kt.meta();
        do{
            kt.datos();
            kt.resultados();
        }while(kt.navegabilidad());
    }
    
    public void meta(){
        System.out.println("Encontrar la forma en que el caballo ");
        System.out.println("Recorre todas las casillas de un tablero ");
        System.out.println("de ajedrez con la condicion de que ");
        System.out.println("visite una cosilla una sola vez.");
    }
    
    public void datos(){
        String s;
        
        do{
            System.out.print("Dame un numero >=4: ");
            s = leer.next();
        }while(!isNum(s));
        n = Integer.parseInt(s);
        tablero = new int[n][n];
    }
    
    public void establecerTablero(){       
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                tablero[i][j] = -1;         
    }
    
    public boolean movValido(int x, int y, int mov[][]){
        return(x >= 0 && x < n && y >= 0 & y < n && mov[x][y] == -1);
    }
    
    boolean theKnightTour(int x, int y, int jugada, 
                               int[][] mov, int[] xc, 
                               int[] yc) { 
        int sx, sy; 
        if (jugada == n * n) 
            return true; 
        for (int i = 0; i < 8; i++) { 
            sx = x + xc[i]; 
            sy = y + yc[i]; 
            if (movValido(sx, sy, mov)) { 
                mov[sx][sy] = jugada; 
                if (theKnightTour(sx, sy, jugada + 1, 
                                mov, xc, yc)) 
                    return true; 
                else
                    mov[sx][sy] = -1;// backtracking 
            } 
        } 
        return false; 
    } 
    
    void resultados(){
        establecerTablero();
        tablero[0][0] = 0;
        if (theKnightTour(0, 0, 1, tablero, xc, yc)) 
            imprimir();  
        else
            System.out.println("No tiene solución");
    }
    
    void imprimir(){
        for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }
    }
    
    boolean navegabilidad(){
        String r; 
        
        System.out.print("Deseas intentar otra vez[s/n]: ");
        r = leer.next();
        return r.equalsIgnoreCase("s");
    }
    
    boolean isNum(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException ex){
            System.err.println("No es numero, Intentelo de nuevo");
            return false;
        }
    }  
}