package stack;

public class FixedLengthStack<E> extends ArrayStack<E> {
  private int drops;

  public FixedLengthStack(int capacity) {
    super(capacity);
  }

  @Override
  public void push(E item) {
    if (size() == getCapacity()) {
      drops += 1;
    } else {
      super.push(item);
    }
  }

  public int drops() {
    return drops;
  }

  public static void main(String[] args) {
    Stack<Integer> fixedLengthIntegerStack = new FixedLengthStack<>(3);

    fixedLengthIntegerStack.push(1);
    fixedLengthIntegerStack.push(2);
    fixedLengthIntegerStack.push(3);
    fixedLengthIntegerStack.push(4);
    fixedLengthIntegerStack.push(5);

    System.out.println("Drops: " + ((FixedLengthStack<Integer>) fixedLengthIntegerStack).drops());

    Stack<Double> fixedLengthDoubleStack = new FixedLengthStack<>(3);

    fixedLengthDoubleStack.push(1.0);
    fixedLengthDoubleStack.push(2.0);
    fixedLengthDoubleStack.push(3.0);
    fixedLengthDoubleStack.push(4.0);
    fixedLengthDoubleStack.push(5.0);

    System.out.println("Drops: " + ((FixedLengthStack<Double>) fixedLengthDoubleStack).drops());

    Stack<String> fixedLengthStringStack = new FixedLengthStack<>(3);

    fixedLengthStringStack.push("A");
    fixedLengthStringStack.push("B");
    fixedLengthStringStack.push("C");
    fixedLengthStringStack.push("D");
    fixedLengthStringStack.push("E");

    System.out.println("Drops: " + ((FixedLengthStack<String>) fixedLengthStringStack).drops());
  }
}
