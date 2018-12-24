package postfix;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ExpressionEvaluatorTest {

  private Object[][] getEvaluatePostfixParameters() {
    return new Object[][] {
        { "1 1 +", "2" },
        { "1 6 4 5 * + 2 / -", "-12" },
        { "6 5 * 3 + 4 2 / -", "31" },
        { "5 4 + 3 / 1 - 6 * 2 +", "14" },
        { "6 2 1 + / 9 1 - 4 / -", "0" }
    };
  }

  private Object[][] getConvertInfixToPostfixParameters() {
    return new Object[][] {
        { "1 + 1", "1 1 +" },
        { "a + b + c + d", "a b + c + d +"},
        { "a + b * c - d + e", "a b c * + d - e +"},
        { "a * b + c * d - e * f", "a b * c d * + e f * -"},
        { "a / b / c + d * e * f", "a b / c / d e * f * +" }
    };
  }

  @Test
  @Parameters(method = "getEvaluatePostfixParameters")
  public void evaluatePostfix(String expression, String expectedResult) {

    String actualResult = ExpressionEvaluator.evaluatePostfix(expression);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @Test
  @Parameters(method = "getConvertInfixToPostfixParameters")
  public void convertInfixToPostfix(String expression, String expectedResult) {

    String actualResult = ExpressionEvaluator.convertInfixToPostfix(expression);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}

