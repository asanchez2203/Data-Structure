package Ejercicio15;

public class Prueba {

    long start, end;

    public long executeTime() {
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
        out("El tiempo de ejecucion es " + tiempo);
    }

    private void out(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Prueba p = new Prueba();
        p.start();
        p.end();
        p.reporta();
    }
}
