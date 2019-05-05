package Tarea2;

/**
 * Rational.java
 * Instituto Tecnológico de León
 * Clase para Manejar numeros racionales en JAVA
 * @author Alexis Sanchez
 * @version 1.0
 */
public class Rational implements Rationalizable {
  
    private int numerator;
    private int denominator;

    /**
     * Constructor para instanciar una nueva fracción con los valores requeridos.
     * Según sea el valor requerido, la fracción se reducirá a su mínima expresión.
     * En caso de ingresar un valor 0 para el denominador, se cambiará a 1
     * @param numerator  Numerador de la fracción
     * @param denominator  Denominador de la fracción
     */
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = (denominator == 0) ? 1 : denominator;
        reduceRational();
    }

    /**
     * Constructor para instanciar una nueva fracción con los valores por defecto
     * 0/1
     */
    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     * Constructor para copiar una objeto Rational previamente creadio
     * @param r1 Objeto Rational a Copiar
     */
    public Rational(Rational r1) {
        this(r1.getNumerator(), r1.getDenominator());
    }

    /**
     * Método que retorna el numerador de la fracción
     * @return Numerador de la fracción
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Método para asignación de un nuevo numerador a la fracción
     * @param numerator numerador de la fracción
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        reduceRational();
    }
    
    
    /**
     * Método que retorna el denominador de la fracción
     * @return Denominador de la fracción
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Método para asignación de un nuevo denominador distinto de 0 a la fracción
     * @param denominator Denominador de la fracción
     */
    public void setDenominator(int denominator) {
        this.denominator = (denominator == 0) ? 1 : denominator;
        reduceRational();
    }
    
    /**
     * Método para asignar nuevo numerador y denominador a la fracción
     * @param numerator Numerador de la fracción
     * @param denominator Denominador de la fracción
     */
    public void set(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
        reduceRational();
    }

    /**
     * Método que retorna el valor del numero racional en su valor decimal
     * @return valor del numero racional en decimal 
     */
    public float get() {
        return (float) this.numerator / this.denominator;
    }

    /**
     * Método para comparar la igualdad de dos fracciones
     * @param r1 Objeto Rational a comparar con el actual
     * @return TRUE si ambos numeros racionales son iguales, de otra manera FALSE
     */
    @Override
    public boolean equals(Rational r1) {
        return (get() == r1.get());
    }

    /**
     * Método para comparar si la fraccion actual es mayor que una segunda 
     * @param r1 Objeto Rational a comparar con el actual
     * @return TRUE si la fraccion instanciada es mayor que r1, de otra manera FALSE
     */
    @Override
    public boolean greater(Rational r1) {
        return (get() > r1.get());
    }

    /**
     * Método para comparar si la fraccion actual es menor que una segunda 
     * @param r1 Objeto Rational a comparar con el actual
     * @return TRUE si la fraccion instanciada es menor que r1, de otra manera FALSE
     */
    @Override
    public boolean less(Rational r1) {
        return (get() < r1.get());
    }

    /**
     * Método para comparar si la fraccion actual es mayor o igual que una segunda 
     * @param r1 Objeto Rational a comparar con el actual
     * @return TRUE si la fraccion instanciada es mayor o igual que r1, de otra manera FALSE
     */
    @Override
    public boolean greaterEquals(Rational r1) {
        return (get() >= r1.get());
    }

    /**
     * Método para comparar si la fraccion actual es menor o igual que una segunda 
     * @param r1 Objeto Rational a comparar con el actual
     * @return TRUE si la fraccion instanciada es menor o igual que r1, de otra manera FALSE
     */
    @Override
    public boolean lessEquals(Rational r1) {
        return (get() <= r1.get());
    }

    /**
     * Método para comparar la desigualdad de dos fracciones
     * @param r1 Objeto Rational a comparar con el actual
     * @return TRUE si ambos numeros racionales son diferentes de otra manera FALSE
     */
    @Override
    public boolean notEquals(Rational r1) {
        return (get() != r1.get());
    }

    /**
     * Método para elevar una fracción a un exponente entero
     * @param exponent exponente de la fracción
     */
    @Override
    public void exponentation(int exponent) {
        setNumerator((int) Math.pow(getNumerator(), exponent));
        setDenominator((int) Math.pow(getDenominator(), exponent));
        reduceRational();
    }

    /**
     * Método para hacer cambio de signo de la fracción
     */
    @Override
    public void negation() {
        setNumerator(getNumerator() * -1);
    }

    /**
     * Método para la asignación de los valores de un Objeto Rational existente al actual
     * @param r Object Rational Type
     */
    @Override
    public void assignment(Rational r) {
        setNumerator(r.getNumerator());
        setDenominator(r.getDenominator());
    }

    /**
     * Método para la suma de dos numeros fraccionarios
     * Teniendo r1 y r2, se crea una nueva fracción r3 con el resultado
     * @param r1 Rational 1
     * @param r2 Rational 2
     */
    @Override
    public void addition(Rational r1, Rational r2) {
        denominator = r1.getDenominator() * r2.getDenominator();
        int a = denominator / r1.getDenominator();
        int b = denominator / r2.getDenominator();
        numerator = (r1.getNumerator() * a) + (r2.getNumerator() * b);
        reduceRational();
    }

    /**
     * Método para la suma de un numero racional y un número entero
     * Teniendo r1 y number, se crea una nueva fracción r3 con el resultado
     * @param r1 Rational 1
     * @param number Número entero a sumar
     */
    @Override
    public void addition(Rational r1, int number) {
        numerator = r1.getNumerator() + (r1.getDenominator() * number);
        denominator = r1.getDenominator();
        reduceRational();
    }

    /**
     * Método para la resta de dos numeros fraccionarios
     * Teniendo r1 y r2, se crea una nueva fracción r3 con el resultado
     * @param r1 Rational 1
     * @param r2 Rational 2
     */
    @Override
    public void subtraction(Rational r1, Rational r2) {
        denominator = r1.getDenominator() * r2.getDenominator();
        int a = denominator / r1.getDenominator();
        int b = denominator / r2.getDenominator();
        numerator = (r1.getNumerator() * a) - (r2.getNumerator() * b);
        reduceRational();
    }

    /**
     * Método para la resta de un numero racional y un número entero
     * Teniendo r1 y number, se crea una nueva fracción r3 con el resultado
     * @param r1 Rational 1
     * @param number Número entero a restar
     */
    @Override
    public void subtraction(Rational r1, int number) {
        numerator = r1.getNumerator() - (r1.getDenominator() * number);
        denominator = r1.getDenominator();
        reduceRational();
    }

    /**
     * Método para la multiplicación de dos numeros fraccionarios
     * Teniendo r1 y r2, se crea una nueva fracción r3 con el resultado
     * @param r1 Rational 1
     * @param r2 Rational 2
     */
    @Override
    public void multiplication(Rational r1, Rational r2) {
        numerator = r1.getNumerator() * r2.getNumerator();
        denominator = r1.getDenominator() * r2.getDenominator();
        reduceRational();
    }

    /**
     * Método para la multiplicación de un numero racional y un número entero
     * Teniendo r1 y number, se crea una nueva fracción r3 con el resultado
     * @param r1 Rational 1
     * @param number Número entero a multiplicar
     */
    @Override
    public void multiplication(Rational r1, int number) {
        numerator = r1.getNumerator() * number;
        denominator = r1.getDenominator();
        reduceRational();
    }

    /**
     * Método para la división de dos numeros fraccionarios
     * Teniendo r1 y r2, se crea una nueva fracción r3 con el resultado
     * @param r1 Rational 1
     * @param r2 Rational 2
     */
    @Override
    public void division(Rational r1, Rational r2) {
        numerator = r1.getNumerator() * r2.getDenominator();
        denominator = r1.getDenominator() * r2.getNumerator();
        reduceRational();
    }

    /**
     * Método para la división de un numero racional y un número entero
     * Teniendo r1 y number, se crea una nueva fracción r3 con el resultado
     * @param r1 Rational 1
     * @param number Número entero a como divisor
     */
    @Override
    public void division(Rational r1, int number) {
        numerator = r1.getNumerator();
        denominator = r1.getDenominator() * number;
        reduceRational();
    }

    /**
     * Método que retorna el numero racional
     * @return String - Número racional del objecto
     */
    public String print() {
        return getNumerator() + "/" + getDenominator();
    }

    /**
     * Método para reducir a su minima expresión los números racionales
     */
    private void reduceRational() {
        int minimo = mcd();
        this.numerator = getNumerator() / minimo;
        this.denominator = getDenominator() / minimo;
    }

    /**
     * Método para encontrar el mínimo común denominador de una fracción
     * @return 
     */
    private int mcd() {
        int numeratorAbs = Math.abs(this.numerator);
        int denominatorAbs = Math.abs(this.denominator);
        if (denominatorAbs == 0) {
            return numeratorAbs;
        }
        int residue;
        while (denominatorAbs != 0) {
            residue = numeratorAbs % denominatorAbs;
            numeratorAbs = denominatorAbs;
            denominatorAbs = residue;
        }
        return numeratorAbs;
    }
}