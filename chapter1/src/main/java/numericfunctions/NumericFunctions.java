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
    if(n < 0) {
      throw new IllegalArgumentException("N must be greater than or equal to zero");
    }

    long result = 1;

    for(long i = 0; i < n; i++) {
      result *= m;
    }

    return result;
  }

  public static void main(String[] args) {
    for (int n = 1; n <= 10; n++) {
      System.out.print(n);
      System.out.print(" ");
      System.out.println(factorial(n));
    }

    System.out.println("\n\n");

    for (int i = 1; i <= 9; i++) {
      for(int j = 1; j <= 9; j++) {
        System.out.print(pow(i, j) + "  ");
      }

      System.out.println();
    }
  }
}

