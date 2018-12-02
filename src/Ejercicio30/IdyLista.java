package Ejercicio30;
/**
 * Clase para almacenar una pareja constituida por un nombre y una lista
 * asociada a �l.
 * @author Amparo L�pez Gaona
 * @version 1.
 */
class IdyLista {
  public String nombre;
  public Lista lista;

  /** Constructor que recibe una cadena
   * @param n - Cadena que ser� el nombre de la lista
   */
  public IdyLista (String n)     {
    nombre = n;
    lista = new Lista();
  }

  /** Constructor que recibe una cadena y una lista
   * @param n - Cadena que ser� el nombre de la lista
   * @param l - Lista asociada al nombre dado
   */
  public IdyLista (String n, Lista l)     {
    nombre=n;
    lista=l;
  }

  /**
   * M�todo para obtener el nombre del objeto
   * @String nombre asociado al objeto
   */
    public String obtenerNombre() {
	return nombre;
    }

  /**
   * M�todo para obtener la lista del objeto
   * @Lista -- lista del objeto
   */
    public Lista obtenerLista() {
	return lista;
    }

}
