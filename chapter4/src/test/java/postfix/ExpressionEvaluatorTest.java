package postfix;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ExpressionEvaluatorTest {

  @Test
  @Parameters(method = "getEvaluatePostfixParameters")
  public void evaluatePostfix(String expression, String expectedResult) {

    String actualResult = ExpressionEvaluator.evaluatePostfix(expression);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @Test
  @Parameters(method = "getEvaluateInfixParameters")
  public void evaluateInfix(String expression, String expectedResult) {

    String actualResult = ExpressionEvaluator.evaluateInfix(expression);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @Test
  @Parameters(method = "getConvertInfixToPostfixParameters")
  public void convertInfixToPostfix(String expression, String expectedResult) {

    String actualResult = ExpressionEvaluator.convertInfixToPostfix(expression);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  private Object[][] getEvaluatePostfixParameters() {
    return new Object[][] {
      {"1 1 +", "2"},
      {"1 6 4 5 * + 2 / -", "-12"},
      {"6 5 * 3 + 4 2 / -", "31"},
      {"5 4 + 3 / 1 - 6 * 2 +", "14"},
      {"6 2 1 + / 9 1 - 4 / -", "0"},
      {"5 2 1 + / 9 1 - 4 / -", "-1"}
    };
  }

  private Object[][] getEvaluateInfixParameters() {
    return new Object[][] {
      {"1 + 2 * 3", "7"},
      {"1 ^ 0 + 1", "2"},
      {"1 + 2 + 3 + 4", "10"},
      {"3 + 1 * 2 - 1 + 4", "8"},
      {"1 * 2 + 3 * 4 - 1 * 5", "9"},
      {"10 / 5 / 2 + 3 * 2 * 4", "25"},
      {"11 / 2 / 1 + 2 ^ 3 * 2 * 3", "53"},
      {"( 24 - 22 ) * ( 12 - 3 ) + 3 * 4 - 1 * 5", "25"},
      {"20 / ( 8 - 3 ) / ( 1 + 1 ) + 3 * ( 2 + 2 ) * 4", "50"},
      {"( 11 - 1 + 1 ) / 2 / 1 + ( 1 + 1 - 0 ) ^ ( 4 - 1 ) * 2 * 3", "53"},
      {"( 20 / ( 8 - 3 ) + 4 ) / ( 1 + 1 ) + 3 * ( 2 + 2 ) * 4", "52"},
    };
  }

  private Object[][] getConvertInfixToPostfixParameters() {
    return new Object[][] {
      {"1 + 1", "1 1 +"},
      {"1 ^ 0 + 1", "1 0 ^ 1 +"},
      {"a + b + c + d", "a b + c + d +"},
      {"a + b * c - d + e", "a b c * + d - e +"},
      {"a * b + c * d - e * f", "a b * c d * + e f * -"},
      {"a / b / c + d * e * f", "a b / c / d e * f * +"},
      {"a / b / c + d ^ n * e * f", "a b / c / d n ^ e * f * +"},
      {"( a + b ) / c", "a b + c /"},
      {"( a / ( a + b ) + c ) * d", "a a b + / c + d *"},
      {"( a + b ) * ( c + d )", "a b + c d + *"},
      {"( a / ( a + b ) + c ) * d - e * ( x + y )", "a a b + / c + d * e x y + * -"},
      {"a / ( x + y + z ) / c + d ^ n * e * f", "a x y + z + / c / d n ^ e * f * +"},
      {"a / ( x + y + z ) / c + d ^ ( p - q ) * e * f", "a x y + z + / c / d p q - ^ e * f * +"},
      {"a + ( b + c + ( x / ( y - z ) ) ) - d", "a b c + x y z - / + + d -" },
      {"a + ( a / ( b + c ) ) + d", "a a b c + / + d +"},
      {"( a + b ) * ( c + d )", "a b + c d + *"},
      {"( ( a + b ) / c + d ) / ( e - f )", "a b + c / d + e f - /"},
      {"b / ( ( x - y - z ) * c + d )", "b x y - z - c * d + /"}
    };
  }
}
