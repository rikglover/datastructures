package postfix;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.stream.Stream;
import stack.ArrayStack;

public class ExpressionEvaluator {

  private static final Set<String> OPERATORS = Stream.of("*", "/", "+", "-").collect(toSet());

  private static String performOperation(String operand1, String operand2, String operator) {
    int operandValue1 = Integer.parseInt(operand1);
    int operandValue2 = Integer.parseInt(operand2);
    int result;

    switch(operator) {
      case "*":
        result = operandValue1 * operandValue2;
        break;

      case "/":
        result = operandValue1 / operandValue2;
        break;

      case "+":
        result = operandValue1 + operandValue2;
        break;

      case "-":
        result = operandValue1 - operandValue2;
        break;

      default:
        throw new RuntimeException("Unknown operator");
    }

    return String.valueOf(result);
  }

  public static String evaluatePostfix(String expression) {
    String[] terms = expression.split("\\s+");

    stack.Stack<String> stack = new ArrayStack<>();

    for (String term : terms) {
      if (OPERATORS.contains(term)) {
        String operand2 = stack.pop();
        String operand1 = stack.pop();
        String result = performOperation(operand1, operand2, term);

        stack.push(result);
      } else {
        stack.push(term);
      }
    }

    if(stack.size() != 1) {
      throw new IllegalStateException("Stack should only have 1 element here");
    }

    return stack.pop();
  }

  public static String convertInfixToPostfix(String expression) {

  }
}
