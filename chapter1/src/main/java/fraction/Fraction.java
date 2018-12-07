package fraction;

public class Fraction {
  private int num;
  private int den;

  public Fraction(int num, int den) {
    this.num = num;
    this.den = den;
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

  @Override
  public String toString() {
    return num  + "/" + den;
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


  }
}
