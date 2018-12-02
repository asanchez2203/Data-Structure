package Ejercicio25;

public class Nodo {
    private Object elemento;
    private Nodo siguiente;        

  Nodo(Object elemento) { 
      this (elemento, null);
  }

  Nodo(Object elemento, Nodo siguiente) {
      this.elemento = elemento;
      this.siguiente = siguiente;
  }

  public Object getElemento () { return elemento; }
  public Nodo getSiguiente() { return siguiente;}
  public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
  public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
  }
}