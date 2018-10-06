package Tarea2;

public class Rational implements Rationalizable {

    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = (denominator == 0) ? 1 : denominator;
        reduceRational();
    }

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(Rational r1) {
        this(r1.getNumerator(), r1.getDenominator());
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        reduceRational();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = (denominator == 0) ? 1 : denominator;
        reduceRational();
    }

    public void set(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
        reduceRational();
    }

    public float get() {
        return (float) this.numerator / this.denominator;
    }

    @Override
    public boolean equals(Rational r1) {
        return (get() == r1.get());
    }

    @Override
    public boolean greater(Rational r1) {
        return (get() > r1.get());
    }

    @Override
    public boolean less(Rational r1) {
        return (get() < r1.get());
    }

    @Override
    public boolean greaterEquals(Rational r1) {
        return (get() >= r1.get());
    }

    @Override
    public boolean lessEquals(Rational r1) {
        return (get() <= r1.get());
    }

    @Override
    public boolean notEquals(Rational r1) {
        return (get() != r1.get());
    }

    @Override
    public void exponentation(int exponent) {
        setNumerator((int) Math.pow(getNumerator(), exponent));
        setDenominator((int) Math.pow(getDenominator(), exponent));
        reduceRational();
    }

    @Override
    public void negation() {
        setNumerator(getNumerator() * -1);
    }

    @Override
    public void assignment(Rational r) {
        setNumerator(r.getNumerator());
        setDenominator(r.getDenominator());
    }

    @Override
    public void addition(Rational r1, Rational r2) {
        denominator = r1.getDenominator() * r2.getDenominator();
        int a = denominator / r1.getDenominator();
        int b = denominator / r2.getDenominator();
        numerator = (r1.getNumerator() * a) + (r2.getNumerator() * b);
        reduceRational();
    }

    @Override
    public void addition(Rational r1, int number) {
        numerator = r1.getNumerator() + (r1.getDenominator() * number);
        denominator = r1.getDenominator();
        reduceRational();
    }

    @Override
    public void subtraction(Rational r1, Rational r2) {
        denominator = r1.getDenominator() * r2.getDenominator();
        int a = denominator / r1.getDenominator();
        int b = denominator / r2.getDenominator();
        numerator = (r1.getNumerator() * a) - (r2.getNumerator() * b);
        reduceRational();
    }

    @Override
    public void subtraction(Rational r1, int number) {
        numerator = r1.getNumerator() - (r1.getDenominator() * number);
        denominator = r1.getDenominator();
        reduceRational();
    }

    @Override
    public void multiplication(Rational r1, Rational r2) {
        numerator = r1.getNumerator() * r2.getNumerator();
        denominator = r1.getDenominator() * r2.getDenominator();
        reduceRational();
    }

    @Override
    public void multiplication(Rational r1, int number) {
        numerator = r1.getNumerator() * number;
        denominator = r1.getDenominator();
        reduceRational();
    }

    @Override
    public void division(Rational r1, Rational r2) {
        numerator = r1.getNumerator() * r2.getDenominator();
        denominator = r1.getDenominator() * r2.getNumerator();
        reduceRational();
    }

    @Override
    public void division(Rational r1, int number) {
        numerator = r1.getNumerator();
        denominator = r1.getDenominator() * number;
        reduceRational();
    }

    public String print() {
        return getNumerator() + "/" + getDenominator();
    }

    private void reduceRational() {
        int minimo = mcd();
        this.numerator = getNumerator() / minimo;
        this.denominator = getDenominator() / minimo;
    }

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
