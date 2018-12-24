package postfix;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ExpressionEvaluatorTest {

  private Object[][] getParameters() {
    return new Object[][] {
        { "1 1 +", "2" },
        { "1 6 4 5 * + 2 / -", "-12" },
        { "6 5 * 3 + 4 2 / -", "31" },
        { "5 4 + 3 / 1 - 6 * 2 +", "14" },
        { "6 2 1 + / 9 1 - 4 / -", "0" }
    };
  }

  @Test
  @Parameters(method = "getParameters")
  public void evaluatePostfix(String expression, String expectedResult) {

    String actualResult = ExpressionEvaluator.evaluatePostfix(expression);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}

