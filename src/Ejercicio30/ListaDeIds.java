package Ejercicio30;

import java.io.*;
import java.util.Iterator;

/**
 * Clase que permite tener una lista donde cada elemento a su vez es una
 * lista.
 * @author Amparo L�pez Gaona
 * @version Febrero 2010 
 */
class ListaDeIds {
  Lista ids;

  /** Constructor por omisi�n */
  ListaDeIds()    {
      ids = new Lista();
  }

  /** 
   * M�todo que permite insertar en una lista, cuyo nombre es dado,  el
   * elemento especificado
   * @param identificador - nombre de la lista en la que se har� la inserci�n
   * @param elementoLista - elemento que se insertar�
   */
  public void insertar(String identificador, Integer linea) {
      boolean encontre = false;
	Iterator it = ids.iterador();
	while (it.hasNext() && !encontre) {
	    IdyLista id = (IdyLista) it.next();
	    if (id.obtenerNombre().equals(identificador)) {
		Lista lis = id.obtenerLista();
		lis.agregar(linea);
		encontre = true;
	    }
	}
	//No est� este identificador
	if (!encontre) {
	    Lista lis = new Lista();
	    lis.agregar(linea);
	    ids.agregar(new IdyLista(identificador, lis));
	}
    }

/**
 * M�todo para imprimir la lista
 */
/**
 * M�todo para imprimir la lista
 */
public void imprimir() {
  for(Iterator it = ids.iterador(); it.hasNext(); ) {
    IdyLista idLista = (IdyLista) it.next();
    System.out.print(idLista.obtenerNombre() + ": ");
    Lista lista = idLista.obtenerLista();
    for (Iterator ilista = lista.iterador(); ilista.hasNext(); ) { 
      System.out.print(ilista.next()+ ", ");
    }
    System.out.println();
  }
}

    private class ComparadorNyL implements java.util.Comparator {
	public int compare(Object o1, Object o2) {
	    String oo1 = ((IdyLista) o1).obtenerNombre();
	    String oo2 = (String) o2;
	    return oo1.compareToIgnoreCase(oo2);
	}
    }

}

class Main  {
    private static String [] reservadas = {
	"abstract", "else", "interface", "static", "boolean", "extends", "long",
	"super", "break", "false", "main", "switch","byte", "final", "native",
	"synchronized", "case", "finally", "new", "this", "catch", "float",
	"null", "throw", "char", "for", "package", "throws", "class", "if",
	"private", "true", "continue", "implements", "protected", "try",
	"default", "import", "public", "void", "do", "instanceof", "return",
	"volatile", "double", "int", "short", "while"};

    private static boolean palRes(String palabra) {
	for (int i = 0; i< reservadas.length; i++)
	    if (palabra.compareTo(reservadas[i]) == 0) {
		return true;
	    }
	return false;
    }

  public static void main (String [] args) {
      ListaDeIds lisId = new ListaDeIds();
      int tipoTok;

      // Paso 1. Leer los datos y formar las listas.
    try {
      BufferedReader in = new BufferedReader (new FileReader(args[0]));
      StreamTokenizer tok = new StreamTokenizer(in);
       	tok.ordinaryChar('.');
	//	tok.lowerCaseMode(true);
       	tipoTok = tok.nextToken();
       	while (tipoTok != StreamTokenizer.TT_EOF) {
	    if (tipoTok == StreamTokenizer.TT_WORD) 
		if (! palRes(tok.sval))
		    lisId.insertar(tok.sval, new Integer(tok.lineno()));
	    tipoTok = tok.nextToken();
       	}

      // Paso 2. Imprime las listas

      lisId.imprimir();
    } catch(IOException e) {
      System.out.println("Se genero IOException "+e);
    }
  }
}
