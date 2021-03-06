package Ejercicio34;

public class Stack implements Stackable{
    private Node base, anterior, siguiente;
    
    public Stack(){this.base=null;}

    @Override
    public void push(Object o) {
        base = new Node(o, base);
    }

    @Override
    public Node peek() {
        if(!isEmpty()){
            Node aux = base;
            while(aux!=null)
                if(aux.getNext() == null) break;
                else aux = aux.getNext();
            return aux;
        }
        else return null;   
    }

    @Override
    public Object pop() {
        if (isEmpty())
        return null;

        Object dato = base.getInfo();
        base = base.getNext();
        return dato;
    }

    @Override
    public int size() {
        int c=0;
        if(!isEmpty()){
            Node aux = base;
            while(aux!=null){
                c++;
                aux = aux.getNext();
            }
        }
        return c;
    }

    @Override
    public boolean trace(Object o) {
        if(!isEmpty()){
            Node aux = base;
            while(aux != null && !aux.getInfo().equals(o))
                if(aux.getNext() == null) break;
                else aux = aux.getNext();
            return aux == null;
        }
        else return true;
    }

    @Override
    public boolean isEmpty() {
        return base==null;
    }

    @Override
    public void empty() {
        base=null;
    }

    @Override
    public Node behind(Node n) {
        if (!isEmpty() && !trace(n.getInfo())) {
            Node aux = base;
            while (aux != null) {
                if (aux.getInfo().equals(n.getInfo())) break;
                anterior = aux;
                aux = aux.getNext();
            }
            return anterior;
        }else return null;
    }

    @Override
    public Node next(Node n) {
        if(!isEmpty() && !trace(n.getInfo())){
            Node aux = base;
            while(aux != null){
                if(!aux.getInfo().equals(n.getInfo()))
                    aux = aux.getNext();
                else {
                    siguiente = aux.getNext();
                    break;
                }
            }     
        }
        return siguiente;
    }
    
     public java.util.Iterator iterador() {
       return new MiIterador(); 
    }
  
    private class MiIterador implements java.util.Iterator {
	private Node posicion = base;

	public boolean hasNext() { return posicion != null;}

	public Object next() { 
	    if (hasNext()) {
		Object o = posicion.getInfo();
		posicion = posicion.getNext();
		return o;
	    }
	    return null;
	}

	public void remove() {
	    throw new IllegalStateException();
	}
    }
}
