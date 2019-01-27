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

  public static int length(String s) {
    if (StringUtils.EMPTY.equals(s)) {
      return 0;
    } else {
      return 1 + length(s.substring(1));
    }
  }
}
