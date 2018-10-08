package Ejercicio16;

public class Prueba {
    long start, end;
    int[] serieFibonacci;

    private long executeTime() {
        return end - start;
    }

    public void start() {
        start = System.currentTimeMillis();
    }

    public void end() {
        end = System.currentTimeMillis();
    }

    public void reporta() {
        long tiempo = executeTime();
        out("El tiempo de ejecucion es " + tiempo + " ms");
    }

    private void out(String s) {
        System.out.println(s);
    }
    
    public int[] serieFibonacci(){
        serieFibonacci=new int[20];
        for (int i = 0; i < serieFibonacci.length; i++) {
            try {
                serieFibonacci[i]=i;
                serieFibonacci[i]=serieFibonacci[i-1]+serieFibonacci[i-2];
            } catch (Exception e) {}
        }
        return serieFibonacci;
    }
    
    public void printSerie(int[] serie){
        for (int i = 0; i < serie.length; i++) {
            out(serie[i]+"");
        }
    }
    
    public static void main(String[] args) {
        Prueba p = new Prueba();
        p.start();
        p.printSerie(p.serieFibonacci());
        p.end();
        p.reporta();
    }
}
