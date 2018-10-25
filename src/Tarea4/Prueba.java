package Tarea4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Prueba extends JFrame{

    private JPanel panel;
    Drawer dibujante = new Drawer();
    int orden;
    int opcion;
    Scanner s=new Scanner(System.in);
    
    void meta(){
        out("Mostrar la Curva de Gosper\n");
        out("Usando recursividad\n");
    }  
    int datos(){
        String op;
        
        do{
            out("Teclee el orden que desea ver [1-4] o 5 para Salir");
            op = s.nextLine();
        }while(!isNum(op));
        opcion=Integer.parseInt(op);
        return opcion;
    }
    
    void patronA(int n){ 
        if(n == 0) return;
        patronA(n-1);
        dibujante.traza(); 
        dibujante.turnRight(60); //60
        patronB(n-1);
        dibujante.traza();
        dibujante.turnRight(60);
        dibujante.turnRight(60);
        patronB(n-1);
        dibujante.traza();
        dibujante.turnLeft(60);//120
        patronA(n-1);
        dibujante.traza();
        dibujante.turnLeft(60); //0
        dibujante.turnLeft(60);
        patronA(n-1);
        dibujante.traza();
        patronA(n-1);
        dibujante.traza();
        dibujante.turnLeft(60); //-60
        patronB(n-1);
        dibujante.traza();
        dibujante.turnRight(60);
    }
    
    void patronB(int n){
        if(n == 0) return;
        dibujante.turnLeft(60);
        patronA(n-1);
        dibujante.traza();
        dibujante.turnRight(60); //0
        patronB(n-1);
        dibujante.traza();
        patronB(n-1);
        dibujante.traza();   
        dibujante.turnRight(60);
        dibujante.turnRight(60);//-180
        patronB(n-1);
        dibujante.traza();
        dibujante.turnRight(60);//-120
        patronA(n-1);
        dibujante.traza();
        dibujante.turnLeft(60);
        dibujante.turnLeft(60);//0
        patronA(n-1);
        dibujante.traza();
        dibujante.turnLeft(60); //60
        patronB(n-1);
        dibujante.traza();
        
    }
    
    void navegabilidad(){
        do{
            switch(datos()){
                case 1:
                    escalar(50, 200, 400);   
                    break;
                case 2:
                    escalar(30,100,600);
                    break;
                case 3:
                    escalar(10, 100, 600);
                    break;
                case 4:
                    escalar(5, 200, 1000);
                    break;
                case 5:
                    break;
                default:
                    out("Opción no Válida");
                    break;
            }
        }while(opcion != 5); 
    }
    
    void escalar(int t, int x, int y){
        dibujante.setStepSize(t);
        dibujante.inicia(x, y);
        initializeComponents();
    }
    
    public static void main(String[] args) {
          Prueba p=new Prueba();
          p.navegabilidad();
    }

    void initializeComponents() {
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setSize(800, 800);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        
        setTitle("Gosper Curve");
        setBounds(0,0,800,800);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(panel);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        dibujante.setHoja(g);
        patronA(opcion);       
    }
    
    void out(String s){System.out.println(s);}

    boolean isNum(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Numero no válido");
            return false;
        }
    }
}
