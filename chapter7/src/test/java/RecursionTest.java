import static org.assertj.core.api.Assertions.assertThat;

import com.sun.javaws.exceptions.InvalidArgumentException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RecursionTest {

  Object[][] getAddParameters() {
    return new Object[][] {
        { 0, 0, 0 },
        { 1, 0, 1 },
        { 2, 0, 2 },
        { 16, 1, 17 },
        { 16, 2, 18 },
        { 16, 3, 19 },
        { 500, 500, 1000 },
        { -1, 5, 4 },
        { -10, 10, 0 }
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
        { 0, 0, 0 },
        { 1, 0, 0 },
        { 2, 0, 0 },
        { 16, 1, 16 },
        { 16, 2, 32 },
        { 16, 3, 48 },
        { 500, 500, 250000 },
        { -1, 5, -5 },
        { -10, 10, -100 }
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
        { 0, 0, 1 },
        { 1, 0, 1 },
        { 2, 0, 1 },
        { 16, 1, 16 },
        { 16, 2, 256 },
        { 16, 3, 4096 },
        { 5, 5, 3125 },
        { -1, 5, -1 },
        { -10, 5, -100000}
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
        { "", 0 },
        { "a", 1},
        { "ab", 2},
        { "abc", 3 },
        { "abcd", 4 }
    };
  }

  @Test
  @Parameters(method = "getLengthParameters")
  public void length(String s, int expectedLength) {
    int actualLength = Recursion.length(s);

    assertThat(actualLength).isEqualTo(expectedLength);
  }
}