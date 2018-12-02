interface Listable {
    public boolean estaVacia();
    public void vaciar();
    public void agregar(Object elem);  //Inserta al inicio de la lista
    public boolean contiene(Object elem);
    public Object primerElemento();
    public void eliminar(Object elem);   //Borra el primer nodo que tenga valor elem
    public void sustituir(Object orig, Object nuevo);
    public java.util.Iterator iterador();
}
