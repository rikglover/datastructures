package fraction;

import numericfunctions.NumericFunctions;

public class Fraction {
  private int num;
  private int den;

  public Fraction(int num, int den) {
    this.num = num;
    this.den = den;

    reduce();
  }

  public Fraction(int n) {
    this(n, 1);
  }

  public void addOn(Fraction f) {
    num = num * f.den + den * f.num;
    den *= f.den;
  }

  public static Fraction add(Fraction f1, Fraction f2) {
    int n = f1.num * f2.den + f1.den * f2.num;
    int d = f1.den * f2.den;

    return new Fraction(n, d);
  }

  public void addOn(int n) {
    Fraction f = new Fraction(n);

    addOn(f);
  }

  public void subtractOff(Fraction f) {
    num = num * f.den - den * f.num;
    den *= f.den;
  }

  public void multiplyBy(Fraction f) {
    num *= f.num;
    den *= f.den;
  }

  public void divideBy(Fraction f) {
    num *= f.den;
    den *= f.num;
  }

  public static Fraction subtract(Fraction f1, Fraction f2) {
    int n = f1.num * f2.den - f1.den * f2.num;
    int d = f1.den * f2.den;

    return new Fraction(n, d);
  }

  public static Fraction multiply(Fraction f1, Fraction f2) {
    int num = f1.num * f2.num;
    int den = f1.den * f2.den;

    return new Fraction(num, den);
  }

  public static Fraction divide(Fraction f1, Fraction f2) {
    int num = f1.num * f2.den;
    int den = f1.den * f2.num;

    return new Fraction(num, den);
  }

  @Override
  public String toString() {
    return num  + "/" + den;
  }

  public void reduce() {
    if(den < 0) {
      num *= -1;
      den *= -1;
    }

    long gcd = NumericFunctions.gcd(Math.abs(num), den);


    num /= gcd;
    den /= gcd;
  }

  public static void main(String[] args) {
    Fraction f1 = new Fraction(3, 4);
    Fraction f2 = new Fraction(1, 3);

    System.out.print(f1 + " + " + f2 + " = ");
    System.out.println(add(f1, f2));

    f1.addOn(f2);

    System.out.println("Using addOn() changes f1 to " + f1);

    Fraction f = new Fraction(5, 8);
    System.out.println("f = " + f);

    Fraction g = new Fraction(17, 3);
    System.out.println("g = " + g);

    Fraction h = Fraction.add(f, g);
    System.out.println("h = " + h);

    Fraction j = new Fraction(5);
    System.out.println("j = " + j);

    g.addOn(j);
    System.out.println("new g after adding on 5 = " + g);

    System.out.println(j + " - " + f + " = " + subtract(j, f));
    System.out.println(j + " * " + f + " = " + multiply(j, f));
    System.out.println(j + " / " + f + " = " + divide(j, f));

    Fraction x = new Fraction(16, 4);
    Fraction y = new Fraction(4, 16);
    Fraction z = new Fraction(6, 63);

    x.reduce();
    y.reduce();
    z.reduce();

    System.out.println("16/4 = " + x);
    System.out.println("4/16 = " + y);
    System.out.println("6/10 = " + z);

    Fraction a = new Fraction(-3, 4);
    Fraction b = new Fraction(3, -4);
    Fraction c = new Fraction(-3, -4);

    System.out.println("-3/4 - (3/-4) = " + subtract(a, b));
    System.out.println("-3/4 + (3/-4) = " + add(a, b));
    System.out.println("-3/4 * (3/-4) = " + multiply(a, b));
    System.out.println("-3/4 / (3/-4) = " + divide(a, b));

    System.out.println("3/(-4) - (-3/(-4)) = " + subtract(b, c));
    System.out.println("3/(-4) + (-3/(-4)) = " + add(b, c));
    System.out.println("3/(-4) * (-3/(-4)) = " + multiply(b, c));
    System.out.println("3/(-4) / (-3/(-4)) = " + divide(b, c));

    System.out.println("-3/4 - (-3/(-4)) = " + subtract(a, c));
    System.out.println("-3/4 + (-3/(-4)) = " + add(a, c));
    System.out.println("-3/4 * (-3/(-4)) = " + multiply(a, c));
    System.out.println("-3/4 / (-3/(-4)) = " + divide(a, c));

  }
}
