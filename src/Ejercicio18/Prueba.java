package Ejercicio18;

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

    public int fibonacci(int n) {
        if ((n == 0) || (n == 1))return 1;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public void printSerie(int n) {
        out(n + "");
    }

    public static void main(String[] args) {
        Prueba p = new Prueba();
        p.start();
        for (int i = 0; i < 20; i++) {
            p.printSerie(p.fibonacci(i));
        }
        p.end();
        p.reporta();
    }
}
