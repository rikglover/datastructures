package postfix;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toSet;

import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import stack.ArrayStack;

public class ExpressionEvaluator {

  private static final String SPACE = " ";

  public static String evaluatePostfix(String expression) {
    String[] terms = expression.split("\\s+");

    stack.Stack<String> stack = new ArrayStack<>();

    for (String term : terms) {
      if (Operator.isOperator(term)) {
        Operator operator = Operator.fromSymbol(term);

        String operand2 = stack.pop();
        String operand1 = stack.pop();
        String result = performOperation(operand1, operand2, operator);

        stack.push(result);
      } else {
        stack.push(term);
      }
    }

    if (stack.size() != 1) {
      throw new IllegalStateException("Stack should only have 1 element here");
    }

    return stack.pop();
  }

  public static String evaluateInfix(String infixExpression) {
    String postfixExpression = convertInfixToPostfix(infixExpression);

    return evaluatePostfix(postfixExpression);
  }

  public static String convertInfixToPostfix(String expression) {
    String[] terms = expression.split("\\s+");

    stack.Stack<Operator> stack = new ArrayStack<>();

    StringJoiner output = new StringJoiner(SPACE);

    for (String term : terms) {
      if (Operator.LEFT_PARENTHESIS.getSymbol().equals(term)) {
        stack.push(Operator.LEFT_PARENTHESIS);
      } else if (Operator.RIGHT_PARENTHESIS.getSymbol().equals(term)) {
        Operator operatorFromStack = stack.pop();

        while (Operator.LEFT_PARENTHESIS != operatorFromStack) {
          output.add(operatorFromStack.getSymbol());
          operatorFromStack = stack.pop();
        }
      } else if (Operator.isOperator(term)) {
        Operator operator = Operator.fromSymbol(term);

        while (!stack.isEmpty() && stack.peek().getRank() >= operator.getRank()) {
          String operatorFromStack = stack.pop().getSymbol();

          output.add(operatorFromStack);
        }

        stack.push(operator);
      } else {
        output.add(term);
      }
    }

    while (!stack.isEmpty()) {
      String stackTerm = stack.pop().getSymbol();

      output.add(stackTerm);
    }

    return output.toString();
  }

  public static boolean isBalanced(String expression) {
    stack.Stack<Operator> stack = new ArrayStack<>();

    String[] terms = expression.split("\\s+");

    for(String term : terms) {
      if(Operator.LEFT_PARENTHESIS.getSymbol().equals(term)) {
        stack.push(Operator.LEFT_PARENTHESIS);
      } else if(Operator.RIGHT_PARENTHESIS.getSymbol().equals(term)) {
        if(stack.isEmpty()) {
          return false;
        }

        stack.pop();
      }
    }

    return stack.isEmpty();
  }

  public static boolean isBalancedGeneral(String expression) {
    stack.Stack<String> stack = new ArrayStack<>();

    String[] terms = expression.split("\\s+");

    Set<String> validClosers = Stream.of(")", "]", "}").collect(toSet());

    for(String term : terms) {
      if(term.equals("(")) {
        stack.push(")");
      } else if(term.equals("[")) {
        stack.push("]");
      } else if(term.equals("{")) {
        stack.push("}");
      } else if(validClosers.contains(term)) {
        if(stack.isEmpty() || !stack.peek().equals(term)) {
          return false;
        }

        stack.pop();
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String infixExpression = "a / b / c + d * e * f";
    String postfixExpression = convertInfixToPostfix(infixExpression);

    System.out.println("Infix: " + infixExpression);
    System.out.println("Postfix: " + postfixExpression);
  }

  private static String performOperation(String operand1, String operand2, Operator operator) {
    int operandValue1 = Integer.parseInt(operand1);
    int operandValue2 = Integer.parseInt(operand2);
    int result;

    switch (operator) {
      case EXPONENTIATION:
        result = (int) Math.pow(operandValue1, operandValue2);
        break;

      case MULTIPLICATION:
        result = operandValue1 * operandValue2;
        break;

      case DIVISION:
        result = operandValue1 / operandValue2;
        break;

      case ADDITION:
        result = operandValue1 + operandValue2;
        break;

      case SUBTRACTION:
        result = operandValue1 - operandValue2;
        break;

      default:
        throw new RuntimeException("Unknown operator");
    }

    return String.valueOf(result);
  }

  @Getter
  @AllArgsConstructor
  private enum Operator {
    LEFT_PARENTHESIS("(", 0),
    RIGHT_PARENTHESIS(")", 0),
    ADDITION("+", 1),
    SUBTRACTION("-", 1),
    MULTIPLICATION("*", 2),
    DIVISION("/", 2),
    EXPONENTIATION("^", 3);

    private static final Map<String, Operator> OPERATOR_MAP =
        Stream.of(Operator.values()).collect(Collectors.toMap(Operator::getSymbol, identity()));

    private final String symbol;
    private final int rank;

    public static Operator fromSymbol(String symbol) {
      if (!isOperator(symbol)) {
        throw new IllegalArgumentException("Invalid operator");
      }

      return OPERATOR_MAP.get(symbol);
    }

    public static boolean isOperator(String input) {
      return OPERATOR_MAP.containsKey(input);
    }
  }
}
