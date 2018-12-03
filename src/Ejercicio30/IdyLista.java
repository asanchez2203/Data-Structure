package Ejercicio30;

class IdyLista {

    public String nombre;
    public Lista lista;

    public IdyLista(String n) {
        nombre = n;
        lista = new Lista();
    }

    public IdyLista(String n, Lista l) {
        nombre = n;
        lista = l;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public Lista obtenerLista() {
        return lista;
    }

}
