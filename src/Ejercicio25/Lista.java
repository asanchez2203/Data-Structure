package Ejercicio25;

public class Lista implements Listable {

    private Nodo inicio;

    public Lista() {
        inicio = null;
    }

    public Lista(Lista lista) {
        inicio = new Nodo(lista.inicio);
        Nodo lis = lista.inicio;
        Nodo pos = inicio;
        while (lis != null) {
            pos = new Nodo(lis);
            lis = lis.getSiguiente();
        }
    }

    @Override
    public void listaVacia() {
        inicio = null;
    }

    @Override
    public boolean esVacia() {
        return inicio == null;
    }

    @Override
    public int tamaño() {
        return 0;
    }

    @Override
    public void insertar(Object elemento) {
        inicio = new Nodo(elemento, inicio);
    }

    @Override
    public boolean contiene(Object elemento) {
        Nodo pos = inicio;

        while (pos != null && !pos.getElemento().equals(elemento)) 
            if(pos.getElemento()!=null)
                if(pos.getElemento().equals(elemento)) return true; 
        return false;
    }

    @Override
    public void eliminar(Object n) {
        Nodo pos = inicio, anterior = null;

        while (pos != null && !pos.getElemento().equals(n)) {
            anterior = pos;
            pos = pos.getSiguiente();
        }
        if (pos != null) 
            if (pos == inicio) inicio = inicio.getSiguiente();
            else anterior.setSiguiente(pos.getSiguiente());     
    }

    @Override
    public void sustituir(Object actual, Object nuevo) {
        Nodo n = Buscar(actual);
        if (n != null) {
            n.setElemento(nuevo);
        }
    }

    @Override
    public Object primerElemento() {
        if (!esVacia()) return inicio.getElemento();
        return null;
    }

    @Override
    public Nodo Buscar(Object elemento) {
        Nodo pos = inicio;

        while (pos != null && !pos.getElemento().equals(elemento)) {
            pos = pos.getSiguiente();
        }
        return pos;
    }

}
