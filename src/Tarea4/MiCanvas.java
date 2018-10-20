package Tarea4;

import java.awt.*;

public class MiCanvas extends Canvas {
//anchura y altura del canvas
     int wAncho, wAlto;
//parámetros
     int orden=0;
     int nCurva=0;
     Drawer tortuga=new Drawer();

  public MiCanvas() {
    setBackground(Color.white);
  }
  void origenEscalas(Graphics g){
     wAncho=getSize().width;
     wAlto=getSize().height;
  }
  void setNuevo(int orden, int nCurva){
    this.orden=orden;
    this.nCurva=nCurva;
    borra();
    repaint();
  }
  void borra(){
    Graphics g=getGraphics();
     g.setColor(getBackground());
     g.fillRect(0,0, wAncho, wAlto);
     g.dispose();
  }
  void titulo(Graphics g){
//título
    String s = "Fractales";
    Font oldFont=g.getFont();
    g.setFont(new Font("Helvetica", Font.BOLD, 20));
    int myx = (wAncho - (g.getFontMetrics()).stringWidth(s))/2;
    int myy = g.getFontMetrics().getHeight()+12;
    g.setColor(Color.blue);
    g.drawString(s, myx - 1, myy - 1);
    g.drawString(s, myx - 1, myy + 1);
    g.drawString(s, myx + 1, myy - 1);
    g.drawString(s, myx + 1, myy + 1);
    g.setColor(Color.cyan);
    g.drawString(s, myx, myy);
    g.setFont(oldFont);
  }
  void generaKoch(int nivel, double distancia){
    if(nivel==0){
        tortuga.traza(distancia);
    }else{
        generaKoch(nivel-1, distancia/3);
        tortuga.gira(60.0);
        generaKoch(nivel-1, distancia/3);
        tortuga.gira(-120.0);
        generaKoch(nivel-1, distancia/3);
        tortuga.gira(60.0);
        generaKoch(nivel-1, distancia/3);
    }
  }
  void curvaKoch(){
        double distancia=(double)(3*wAlto-30)/(2*1.732);      //raíz de tres    //10 de margen
        double x=wAncho/2-distancia/2;
        double y=(distancia/3)*1.732/2+5;    // 5 de margen
        tortuga.salta(x, y);
        generaKoch(orden, distancia);
        tortuga.gira(-120);
        generaKoch(orden, distancia);
        tortuga.gira(-120);
        generaKoch(orden, distancia);
  }

 void generaHilbert(int nivel, int direccion, double distancia){
  	if(nivel>0){
		tortuga.gira(-90*direccion);
		generaHilbert(nivel-1, -direccion, distancia);
		tortuga.traza(distancia);
		tortuga.gira(90*direccion);
		generaHilbert(nivel-1, direccion, distancia);
		tortuga.traza(distancia);
		generaHilbert(nivel-1, direccion, distancia);
		tortuga.gira(90*direccion);
		tortuga.traza(distancia);
		generaHilbert(nivel-1, -direccion, distancia);
		tortuga.gira(-90*direccion);
   	}
 }
 void curvaHilbert(){
    double distancia=wAlto-10;
    double x=wAncho/2-wAlto/2;
    double y=5.0;    // 5 de margen
	tortuga.salta(x, y);
	generaHilbert(orden+1, 1, distancia/(potencia2(orden+1)-1));
 }
 private long potencia2(int n){
    long resultado=1;
    for(int i=1; i<=n; i++){
        resultado*=2;
    }
    return resultado;
 }
 void generaPeano(int nivel, double distancia){
	if(nivel==0)
		tortuga.traza(distancia);
	else{
		generaPeano(nivel-1, distancia/3);
		tortuga.gira(-90.0);
		generaPeano(nivel-1, distancia/3);
		tortuga.gira(90.0);
		generaPeano(nivel-1, distancia/3);
		tortuga.gira(90.0);
		generaPeano(nivel-1, distancia/3);
		generaPeano(nivel-1, distancia/3);
		tortuga.gira(90.0);
		generaPeano(nivel-1, distancia/3);
		tortuga.gira(90.0);
		generaPeano(nivel-1, distancia/3);
		tortuga.gira(90.0);
		generaPeano(nivel-1, distancia/3);
		generaPeano(nivel-1, distancia/3);
	}
 }
 void curvaPeano(){
    double distancia=wAlto;
    double x=wAncho/2-wAlto/2;
    double y=wAlto/2;
    tortuga.salta(x, y);
	generaPeano(orden, distancia);
 }

  public void paint(Graphics g){
    origenEscalas(g);
    g.setColor(getBackground());
    g.fillRect(0,0, wAncho, wAlto);
    titulo(g);
  }
  public void update(Graphics g){
    tortuga.inicia(g);
    switch(nCurva){
        case 0:
            curvaKoch();
            break;
        case 1:
            curvaPeano();
            break;
        case 2:
            curvaHilbert();
            break;
        default:
            break;
    }
 }
}
