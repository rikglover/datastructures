package numericfunctions;

public class NumericFunctions {

  private static int factorial(int n) {
    int result = 1;

    for (int i = 2; i <= n; i++) {
      result *= i;
    }

    return result;
  }

  private static long pow(long m, long n) {
    if (n < 0) {
      throw new IllegalArgumentException("N must be greater than or equal to zero");
    }

    long result = 1;

    for (long i = 0; i < n; i++) {
      result *= m;
    }

    return result;
  }

  private static long gcd(long m, long n) {
    while (n > 0) {
      long previousN = n;

      n = m % n;
      m = previousN;
    }

    return m;
  }
/*
  public static void main(String[] args) {

    // test factorial
    for (int n = 1; n <= 10; n++) {
      System.out.print(n);
      System.out.print(" ");
      System.out.println(factorial(n));
    }

    // test pow
    System.out.println("\n\n");
    System.out.print("n:  ");

    for (int i = 1; i < 10; i++) {
      System.out.printf("%11d", i);
    }

    System.out.println("\n");

    for (int i = 1; i <= 9; i++) {
      System.out.print("m: " + i);

      for (int j = 1; j <= 9; j++) {
        System.out.printf("%11d", pow(i, j));
      }

      System.out.println();
    }

    // test gcd
    System.out.println("\n\n");
    System.out.print("n:   ");

    for (int i = 2; i <= 20; i++) {
      System.out.printf("%5d", i);
    }

    System.out.println("\n");

    for (int i = 2; i <= 20; i++) {
      System.out.printf("m: %2d", i);

      for (int j = 2; j <= 20; j++) {
        System.out.printf("%5d", gcd(i, j));
      }

      System.out.println();
    }
  }
  */
}

