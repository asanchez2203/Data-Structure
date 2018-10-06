package Tarea2;

public interface Rationalizable {
    public boolean equals(Rational r1);
    public boolean greater(Rational r1);
    public boolean less(Rational r1);
    public boolean greaterEquals(Rational r1);
    public boolean lessEquals(Rational r1);
    public boolean notEquals(Rational r1);
    public void exponentation(int exponent);
    public void negation();
    public void assignment(Rational r);
    public void addition(Rational r1,Rational r2);
    public void addition(Rational r1,int numero);
    public void subtraction(Rational r1,Rational r2);
    public void subtraction(Rational r1,int numero);
    public void multiplication(Rational r1,Rational r2);
    public void multiplication(Rational r1,int numero);
    public void division(Rational r1,Rational r2);
    public void division(Rational r1,int numero);
}
