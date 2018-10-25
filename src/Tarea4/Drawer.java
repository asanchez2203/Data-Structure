package Tarea4;

import java.awt.*;

public class Drawer {

    double x;
    double y;
    double angulo;    //radianes
    Color color;
    private Graphics hoja;
    private int stepSize=10;

    public Drawer(double x, double y, double angulo, Color color) {
        this.x = x;
        this.y = y;
        this.angulo = angulo * Math.PI / 180;
        this.color = color;
    }

    public Drawer() {
        this.x = 0.0;
        this.y = 0.0;
        this.angulo = 0.0;
        this.color = Color.black;
    }

    public void inicia(int x,int y) {
        this.x = x;
        this.y = y;
        angulo = 0.0;
        color = Color.black;
    }

    public void salta(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void salta(double distancia) {
        double xx = x + distancia * Math.cos(angulo);
        double yy = y - distancia * Math.sin(angulo);
        salta(xx, yy);
    }   

    public void traza() {
        double xx = x + stepSize * Math.cos(angulo);
        double yy = y - stepSize * Math.sin(angulo);
        hoja.setColor(color);
        hoja.drawLine((int) xx, (int) yy, (int) x, (int) y);
        salta(xx, yy);
    }
    
    public double turnLeft(double delta){
        angulo-=delta * Math.PI / 180;
        return angulo;
    }
    
    public double turnRight(double delta){
        angulo+=delta * Math.PI / 180;
        return angulo;
    }

    public void setStepSize(int stepSize) {
        this.stepSize = stepSize;
    } 

    public void setHoja(Graphics hoja) {
        this.hoja = hoja;
    }
}
