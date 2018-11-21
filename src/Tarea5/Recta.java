package Tarea5;

import java.util.Objects;

public class Recta implements Rectable{
    private double a;
    private double b;
    private double c;
    
    public Recta(){
        this(1,1,0);
    }
    
    public Recta(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    
    public Recta(Recta r2){
        r2.setA(this.a);
        r2.setB(this.b);
        r2.setC(this.c);
    }

    public double getA() { return a; }
    public void setA(double a) {this.a = a;}
    public double getB() {return b;}
    public void setB(double b) { this.b = b;}
    public double getC() {return c; }
    public void setC(double c) {this.c = c;}
    public void get(){
        System.out.println("Su Recta: "+a+"X+"+b+"Y+"+c+"=0");
    }

    @Override
    public Double intersectionX() {return(a!=0)?-c/a:null;}

    @Override
    public Double intersectionY() {return(b!=0)? -c/b:null;}

    @Override
    public Double pendiente() {return(b!=0)? -a/b : null;}

    @Override
    public Boolean esParalelo(Recta r2) {
        return (Objects.equals(pendiente(), r2.pendiente()));
    }

    @Override
    public Boolean esPerpendicular(Recta r2) {return !(esParalelo(r2));}

    @Override
    public Double anguloInclinacion() { 
        return (pendiente()!=null)?Math.toDegrees(Math.atan(pendiente())):90; 
    }
   
}
