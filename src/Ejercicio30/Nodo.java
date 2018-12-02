package Ejercicio30;
/*
 * Clase para manejar los nodos de la lista
 */
class Nodo { //implements Cloneable {
  public Object   elemento;
  public Nodo sgte;

  /**
   * Crea un nodo con elemento igual a valor y apuntando al vac�o.
   * @param valor el Objeto que es el valor de nodo
   */
  Nodo(Object valor) { 
      this (valor, null);
  }
  /**
   * Crea un nodo despu�s del indicado, con elemento igual a valor.
   * @param valor el Objeto que es el valor de nodo
   * @param n el nodo anterior al reci�n creado
   */
    /**
  Nodo(Object valor, Nodo n) {
      elemento = valor;
      sgte = (n != null) ? (Nodo) n.clone() : null;
  }
    **/
  Nodo(Object valor, Nodo n) {
      elemento = valor;
      sgte = n;
  }

    /**
    Nodo(Nodo n) {
	this (n.elemento, n.sgte);
    }

    public Object clone() {
	Object obj = null;
	try {
	    obj = super.clone();
	}catch (CloneNotSupportedException e) {}
	return obj;
    }
    **/
  /*
   * Devuelve el valor de un nodo
   * @return Object el valor del nodo
   */
  public Object obtenerElemento () { return elemento; }

  /**
   * Devuelve la referencia del siguiente nodo
   * @return NOdo el siguietne nodo
   */
  public Nodo obtenerSgte() { return sgte;}
}


