package Ejercicio30;

import java.util.Comparator;
/**
 * Listada ligada usando un nodo centinela al inicio y otro al final de la misma
 * @author Amparo L�pez Gaona
 * @version abril 2011
 */
public class Lista implements Listable{
  private Nodo inicio;
  private Nodo fin;
    //  private final Comparator prueba;

  /**  Construye la lista  */
  public Lista() {
    inicio = null;
    fin = null;
    //    prueba = new DefaultComparator();
  }
  /**  Construye la lista con el comparador especificado 
  public Lista(Comparator c) {
    inicio = null;
    fin = null;
    prueba = c;
  }
  */

  /** Prueba que la lista est� vac�a. 
   * @return true si est� vac�a y false en otro caso.
   */
  public boolean estaVacia() {
    return inicio == null && fin == null;
  }
  /** Crea una lista vac�a.  */
  public void vaciar() {
    inicio = fin = null;
  }
  /** Devuelve el primer elemento de la lista **/
  public Object primerElemento() {
    return (estaVacia()) ? null : inicio.elemento;
  }

  /** Devuelve el �ltimo elemento de la lista **/
  public Object ultimoElemento() {
    return (estaVacia()) ? null : fin.elemento;
  }

  /**
   * Determina si un elemento est� contenido en la lista.
   * @param dato el elemento a buscar. 
   * @return boolean - true si el dato est� en la lista y false en otro caso.
   */
  public boolean contiene(Object dato) {
    Nodo pos = inicio;

    while(pos != null && !dato.equals(pos.elemento)) 
      pos = pos.sgte;
    return pos != null;
  }
  /**
   * Sustituye el valor actual de un nodo por otro nuevo.
   * @param orig -- valor original
   * @param nuevo -- nuevo valor
   */
  public void sustituir(Object orig, Object nuevo)  {
    Nodo pos = inicio;

    while(pos != null && !orig.equals(pos.elemento)) {
      pos = pos.sgte;
    }
    if (pos != null)
      pos.elemento = nuevo;
  }
  /**
   * Inserta el primer elemento de la lista.
   * @param dato el dato a agregar.
   */
  public void agregarAlInicio(Object dato) {
      if (estaVacia()) 
	  inicio = fin = new Nodo(dato);
      else 
	  inicio = new Nodo(dato,inicio);

  }

  /**
   * Inserta el �ltimo elemento de la lista.
   * @param dato el dato a agregar.
   */
  public void agregar(Object dato) {
      if (estaVacia())
	  inicio = fin = new Nodo(dato);
      else 
	  fin = fin.sgte = new Nodo(dato);  
  }

  /**
   * Elimina la primera ocurrencia de un dato.
   * @param dato el dato a eliminar.
   */
  public void eliminar(Object dato) {
    Nodo pos = inicio, anterior = null;

    while(pos != null && !dato.equals(pos.elemento)) {
      anterior = pos;
      pos = pos.sgte;
    }
    if (pos == null) return;   // No lo encontr�
    if(pos == inicio) {        // Es el inicio de la lista
	inicio = inicio.sgte;
	if (inicio == null)
	    fin = null;
    }
    else {
      anterior.sgte = pos.sgte; 
      if (anterior.sgte == null)
	  fin = anterior;
    }
  }

    public void eliminarPrimero() {
	if (!estaVacia()) {
	    inicio = inicio.sgte;
	    if (inicio == null) fin = null;
	}
    }

  public java.util.Iterator iterador() { 
    return new MiIterador(); 
  }
	
  /**
   * Clase que implementa el iterador
   */
  private class MiIterador implements java.util.Iterator {
    private Nodo posicion = inicio;

    public boolean hasNext() { return posicion != null;}

    public Object next() { //throws NoSuchElementException {
      if (hasNext()) {
	Object o = posicion.elemento;
	posicion = posicion.sgte;
	return o;
      }
//      throw new NoSuchElementException();
return null;
    }

    public void remove()         {
      throw new IllegalStateException();
    }
  }
    private class DefaultComparator implements Comparator {
	public int compare(Object o1, Object o2) {
	    Comparable oo1 = (Comparable) o1;
	    return oo1.compareTo(o2);
	}
    }
// M�todo para imprimir
public void imprime() {
  if(estaVacia())
    System.out.print("La lista est� vac�a");
  else {
      for( Nodo pos = inicio; pos != null; pos = pos.sgte)
        System.out.print(pos.elemento+ " ");
      System.out.println();
  }
}
}

class PruebaLista {
    public static void main (String [] args) {

	Lista lis = new Lista();
	for(int i = 1; i <= 5; i++) 
	    lis.agregar(i+ " ");
	System.out.print("Lista original: ");
	lis.imprime();
	lis.agregarAlInicio("6 ");
	lis.imprime();
	lis.agregar("45 ");
	lis.imprime();
	lis.agregarAlInicio("40 ");
	lis.imprime();
	lis.eliminarPrimero();
	lis.imprime();
	lis.eliminar("6 ");
	lis.imprime();
	lis.sustituir("4 ","8 ");
	lis.imprime();
	lis.eliminar("8 ");
	lis.imprime();
	lis.eliminar("45 ");
	lis.imprime();

    }
}
