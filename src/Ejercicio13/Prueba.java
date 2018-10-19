package Ejercicio13;

public class Prueba {

    public static void main(String[] args) {
        Conjunto c1 = new Conjunto();
        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.add(4);
        c1.add(5);
        Conjunto c2 = new Conjunto();
        c2.add(4);
        c2.add(5);
        c2.add(6);
        c2.add(7);
        c2.add(8);
        c2.add(9);
        
        Conjunto test;
        test=c2.intersection(c1);
       
        
        for(Object o: test.getObjects())
            if(o!=null) System.out.println(o);
    }
}
