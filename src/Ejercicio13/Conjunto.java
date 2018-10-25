package Ejercicio13;

public class Conjunto implements Conjuntable {

    private Object objects[];

    public Conjunto(Conjunto c1) {
        objects=new Object[c1.objects.length];
        for(int i=0;i<c1.objects.length;i++)
            objects[i]=c1.objects[i];
    }

    public Conjunto(int size) {
        objects = new Object[size <= 0 ? 20 : size];
        for (int i = 0; i < objects.length; i++)
            objects[i] = null;   
    }

    public Conjunto() {
        this(20);
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < objects.length; i++)
            if(objects[i]!=null) return false;
        return false;
    }

    @Override
    public int size() {
       int tam = 0;
	for (int i = 0; i < objects.length; i++)
	    if (objects[i] != null) tam++;
	return tam;
    }

    @Override
    public void empty() {
        for (int i = 0; i < objects.length; i++)
            objects[i] = null;  
    }

    @Override
    public void add(Object o) {
        if(size()==objects.length)
            increaseObjects();
        if(!contains(o))
            for(int i=0;i<objects.length;i++)
                if(objects[i]==null){
                    objects[i]=o;
                    return;
                }
    }

    @Override
    public void delete(Object o) {
        for (int i = 0; i < objects.length; i++) {
            if(objects[i]!=null && o!=null){
                if (o.equals(objects[i])) {
                objects[i] = null;
                return; } 
            }
        }              
    }

    @Override
    public boolean contains(Object o) {
        if(!isEmpty())
            for (Object object : objects)
                if (object!=null && o!=null) 
                    if (o.equals(object)) 
                        return true;		           
        return false;
    }

    @Override
    public Conjunto union(Conjunto c) {
        Conjunto n=new Conjunto(this);
            for(Object o:c.getObjects())
                if(!n.contains(o))
                    n.add(o);                  
        return n;
    }

    @Override
    public Conjunto intersection(Conjunto c) {
        Conjunto n = new Conjunto(this);
        for(Object o:n.getObjects()){
                if(!c.contains(o))
                    n.delete(o);  
        }
        return n;
    }

    @Override
    public Conjunto difference(Conjunto c) {
        Conjunto n = new Conjunto(this);
        for(Object o:n.getObjects()){
            if(c.contains(o))
                n.delete(o);  
        }                   
        return n;
    }

    @Override
    public boolean isSubSet(Conjunto c) {
        for(Object o: c.getObjects())
                if(o!=null)
                    if(!contains(o))
                        return false;
        return true;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }
    
    private void increaseObjects(){
        int newSize =objects.length + 10;
	Object[] noobjects = new Object[newSize];
	
	for (int i = 0; i < objects.length; i++)
	    noobjects[i] = objects[i];
	objects = noobjects;
    }
}
