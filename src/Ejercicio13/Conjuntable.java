package Ejercicio13;

interface Conjuntable {
    public boolean isEmpty();
    public int size();
    public void empty();
    public void add(Object o);
    public void delete(Object o);
    public boolean contains(Object o);
    public Conjunto union(Conjunto c);
    public Conjunto intersection(Conjunto c);
    public Conjunto difference(Conjunto c);
    public boolean isSubSet(Conjunto c);
}
