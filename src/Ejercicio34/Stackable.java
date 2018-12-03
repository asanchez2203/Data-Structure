
package Ejercicio34;

public interface Stackable {
    
    public void push(Object o);
    public Node peek();
    public Object pop();
    public int size();
    public boolean trace(Object o);
    public boolean isEmpty();
    public void empty();
    public Node behind(Node n);
    public Node next(Node n);
}
