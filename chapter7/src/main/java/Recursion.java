import org.apache.commons.lang3.StringUtils;

public class Recursion {

  public static int add(int m, int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n must be greater than or equal to 0");
    }

    if (n == 0) {
      return m;
    } else {
      return 1 + add(m, n - 1);
    }
  }

  public static int mul(int m, int n) {
    if (n == 0) {
      return 0;
    } else {
      return m + mul(m, n - 1);
    }
  }

  public static int pow(int m, int n) {
    if (n == 0) {
      return 1;
    } else {
      return m * pow(m, n - 1);
    }
  }

  public static int pow2(int m, int n) {
    if (n == 1) {
      return m;
    } else {
      int powResult = pow(m, n / 2);

      if (n % 2 == 1) {
        return powResult * powResult * m;
      } else {
        return powResult * powResult;
      }
    }
  }

  public static int length(String s) {
    if (StringUtils.EMPTY.equals(s)) {
      return 0;
    } else {
      return 1 + length(s.substring(1));
    }
  }

  public static String reverse(String s) {
    if (s.length() <= 1) {
      return s;
    } else {
      return reverse(s.substring(1)) + s.charAt(0);
    }
  }

  public static int fib(int n) {
    if (n <= 1) {
      return n;
    } else {
      return fib(n - 1) + fib(n - 2);
    }
  }

  public static int gcd(int m, int n) {
    if (n == 0) {
      return m;
    } else {
      return gcd(n, m % n);
    }
  }

  public static String bits(int n) {
    if (n == 0 || n == 1) {
      return String.valueOf(n);
    } else {
      int bit = n % 2;
      int remainingBits = n / 2;

      return bits(remainingBits) + String.valueOf(bit);
    }
  }
}