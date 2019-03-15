import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class FractionTest {


  Object[][] getCompareToParameters() {
    return new Object[][] {
        {1, 1, 1, 1, 0},
        {0, 0, 0, 0, 0},
        {1, 2, 1, 2, 0},
        {2, 2, 2, 2, 0},
        {2, 1, 2, 1, 0},
        {1, 2, 1, 3, 1},
        {1, 3, 1, 2, -1},
        {-1, 3, 1, 3, -2},
        {1, 3, -1, 3, 2},
        {-1, 1, 1, 1, -2},
        {1, 1, -1, 1, 2}
    };
  }

  @Test
  @Parameters(method = "getCompareToParameters")
  public void testCompareTo(int num1, int den1, int num2, int den2, int expectedCompareToValue) {
    Fraction fraction1 = new Fraction(num1, den1);
    Fraction fraction2 = new Fraction(num2, den2);

    int actualCompareToValue = fraction1.compareTo(fraction2);

    assertThat(actualCompareToValue).isEqualTo(expectedCompareToValue);
  }
}
