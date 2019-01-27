import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RecursionTest {

  Object[][] getAddParameters() {
    return new Object[][] {
      {0, 0, 0},
      {1, 0, 1},
      {2, 0, 2},
      {16, 1, 17},
      {16, 2, 18},
      {16, 3, 19},
      {500, 500, 1000},
      {-1, 5, 4},
      {-10, 10, 0}
    };
  }

  @Test
  @Parameters(method = "getAddParameters")
  public void add(int m, int n, int expectedResults) {
    int actualResults = Recursion.add(m, n);

    assertThat(expectedResults).isEqualTo(actualResults);
  }

  @Test(expected = IllegalArgumentException.class)
  public void add() {
    Recursion.add(5, -1);
  }

  Object[][] getMulParameters() {
    return new Object[][] {
      {0, 0, 0},
      {1, 0, 0},
      {2, 0, 0},
      {16, 1, 16},
      {16, 2, 32},
      {16, 3, 48},
      {500, 500, 250000},
      {-1, 5, -5},
      {-10, 10, -100}
    };
  }

  @Test
  @Parameters(method = "getMulParameters")
  public void mul(int m, int n, int expectedResults) {
    int actualResults = Recursion.mul(m, n);

    assertThat(expectedResults).isEqualTo(actualResults);
  }

  Object[][] getPowParameters() {
    return new Object[][] {
      {0, 0, 1},
      {1, 0, 1},
      {2, 0, 1},
      {16, 1, 16},
      {16, 2, 256},
      {16, 3, 4096},
      {5, 5, 3125},
      {-1, 5, -1},
      {-10, 5, -100000}
    };
  }

  @Test
  @Parameters(method = "getPowParameters")
  public void pow(int m, int n, int expectedResults) {
    int actualResults = Recursion.pow(m, n);

    assertThat(expectedResults).isEqualTo(actualResults);
  }

  Object[][] getLengthParameters() {
    return new Object[][] {
      {"", 0},
      {"a", 1},
      {"ab", 2},
      {"abc", 3},
      {"abcd", 4}
    };
  }

  @Test
  @Parameters(method = "getLengthParameters")
  public void length(String s, int expectedLength) {
    int actualLength = Recursion.length(s);

    assertThat(actualLength).isEqualTo(expectedLength);
  }

  Object[][] getReverseParameters() {
    return new Object[][] {
      {"", ""},
      {"a", "a"},
      {"ab", "ba"},
      {"abc", "cba"},
      {"abcd", "dcba"},
      {"abcde", "edcba"},
      {
        "The only thing we have to fear is fear itself",
        "flesti raef si raef ot evah ew gniht ylno ehT"
      }
    };
  }

  @Test
  @Parameters(method = "getReverseParameters")
  public void reverse(String s, String expectedReverseOfS) {
    String actualReverseOfS = Recursion.reverse(s);

    assertThat(actualReverseOfS).isEqualTo(expectedReverseOfS);
  }

  Object[][] getFibParameters() {
    return new Object[][] {
      {0, 1},
      {1, 1},
      {2, 2},
      {3, 3},
      {4, 5},
      {5, 8},
      {6, 13},
      {7, 21},
      {8, 34}
    };
  }

  @Test
  @Parameters(method = "getFibParameters")
  public void fib(int term, int expectedValue) {
    int actualValue = Recursion.fib(term);

    assertThat(actualValue).isEqualTo(expectedValue);
  }

  private Object[][] getGcdParameters() {
    return new Object[][] {
      {12, 8, 4},
      {16, 24, 8},
      {11, 3, 1},
      {99, 33, 33},
      {151, 27, 1}
    };
  }

  @Parameters(method = "getGcdParameters")
  @Test
  public void gcd(int m, int n, int expectedResult) {
    int actualResult = Recursion.gcd(m, n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @Test
  public void bits() {
    for (int i = 0; i < 1000000; i++) {
      String actualBits = Recursion.bits(i);
      String expectedBits = Integer.toBinaryString(i);

      assertThat(actualBits).isEqualTo(expectedBits);
    }
  }
}
