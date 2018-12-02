package Ejercicio25;

public interface Listable {
    void listaVacia();
    boolean esVacia();
    int tamaño();
    void insertar(Object n);
    boolean contiene(Object n);   
    void eliminar(Object n);
    void sustituir(Object actual, Object nuevo);
    Object primerElemento();
    Nodo Buscar(Object n);
}
