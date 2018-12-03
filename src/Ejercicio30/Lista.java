package Ejercicio30;

import java.util.Comparator;

public class Lista implements Listable {

    private Nodo inicio;
    private Nodo fin;

    public Lista() {
        inicio = null;
        fin = null;
    }

    public boolean estaVacia() {
        return inicio == null && fin == null;
    }

    public void vaciar() {
        inicio = fin = null;
    }

    public Object primerElemento() {
        return (estaVacia()) ? null : inicio.elemento;
    }

    public Object ultimoElemento() {
        return (estaVacia()) ? null : fin.elemento;
    }

    public boolean contiene(Object dato) {
        Nodo pos = inicio;

        while (pos != null && !dato.equals(pos.elemento)) {
            pos = pos.sgte;
        }
        return pos != null;
    }

    public void sustituir(Object orig, Object nuevo) {
        Nodo pos = inicio;

        while (pos != null && !orig.equals(pos.elemento)) {
            pos = pos.sgte;
        }
        if (pos != null) {
            pos.elemento = nuevo;
        }
    }

    public void agregarAlInicio(Object dato) {
        if (estaVacia()) {
            inicio = fin = new Nodo(dato);
        } else {
            inicio = new Nodo(dato, inicio);
        }

    }

    public void agregar(Object dato) {
        if (estaVacia()) {
            inicio = fin = new Nodo(dato);
        } else {
            fin = fin.sgte = new Nodo(dato);
        }
    }

    public void eliminar(Object dato) {
        Nodo pos = inicio, anterior = null;

        while (pos != null && !dato.equals(pos.elemento)) {
            anterior = pos;
            pos = pos.sgte;
        }
        if (pos == null) {
            return;   // No lo encontr�
        }
        if (pos == inicio) {        // Es el inicio de la lista
            inicio = inicio.sgte;
            if (inicio == null) {
                fin = null;
            }
        } else {
            anterior.sgte = pos.sgte;
            if (anterior.sgte == null) {
                fin = anterior;
            }
        }
    }

    public void eliminarPrimero() {
        if (!estaVacia()) {
            inicio = inicio.sgte;
            if (inicio == null) {
                fin = null;
            }
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

        public boolean hasNext() {
            return posicion != null;
        }

        public Object next() { //throws NoSuchElementException {
            if (hasNext()) {
                Object o = posicion.elemento;
                posicion = posicion.sgte;
                return o;
            }
//      throw new NoSuchElementException();
            return null;
        }

        public void remove() {
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
        if (estaVacia()) {
            System.out.print("La lista est� vac�a");
        } else {
            for (Nodo pos = inicio; pos != null; pos = pos.sgte) {
                System.out.print(pos.elemento + " ");
            }
            System.out.println();
        }
    }
}
