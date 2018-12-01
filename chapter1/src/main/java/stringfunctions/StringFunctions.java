package stringfunctions;

public class StringFunctions {
  private static int count(String s, String target) {
    int count = 0;
    int n = target.length();

    for(int i = 0; i <= s.length() - n; i++) {
      String piece = s.substring(i, i + n);

      if(piece.equals(target)) {
        count++;
      }
    }

    return count;
  }

  private static int countIgnoreCase(String s, String target) {
    String sUpperCase = s.toUpperCase();
    String targetUpperCase = target.toUpperCase();

    return count(sUpperCase, targetUpperCase);
  }

  private static int count2(String s, String target) {
    int count = 0;
    int n = target.length();
    int i = 0;

    while(i <= s.length() - n) {
      int index = s.indexOf(target, i);

      if(index >= 0) {
        count++;
      }

      i = index + 1;
    }

    return count;
  }

  public static void main(String[] args) {
    int count = count2("this and this and that and this", "this");

    System.out.println("Number of this's: " + count);
  }
}
