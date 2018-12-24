package stack;

import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {

  private static final int DEFAULT_CAPACITY = 10;
  private static final int EMPTY_INDEX = -1;
  private static final int RESIZE_FACTOR = 2;
  private static final int DOWNSIZE_FACTOR = 4;

  private E[] data = null;

  private int top = EMPTY_INDEX;

  public ArrayStack() {
    this(DEFAULT_CAPACITY);
  }

  public ArrayStack(int capacity) {
    data = allocateData(capacity);
  }

  @Override
  public boolean isEmpty() {
    return top == EMPTY_INDEX;
  }

  @Override
  public int size() {
    return top + 1;
  }

  @Override
  public void push(E item) {
    if (size() == data.length) {
      resize(RESIZE_FACTOR * data.length);
    }

    top += 1;
    data[top] = item;
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    E item = data[top];

    data[top] = null;
    top -= 1;

    if (data.length > DEFAULT_CAPACITY && size() < data.length / DOWNSIZE_FACTOR) {
      resize(data.length / RESIZE_FACTOR);
    }

    return item;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    return data[top];
  }

  @SuppressWarnings("unchecked")
  private E[] allocateData(int size) {
    return (E[]) new Object[size];
  }

  private void resize(int newCapacity) {
    if (newCapacity <= size()) {
      throw new IllegalArgumentException("newCapacity cannot be smaller that current size");
    }

    E[] newData = allocateData(newCapacity);

    System.arraycopy(data, 0, newData, 0, size());

    data = newData;
  }

  public static void main(String[] args) {
    Stack<Integer> integerStack = new ArrayStack<>();

    integerStack.push(1);
    integerStack.push(2);
    integerStack.push(3);

    System.out.println("Size: " + integerStack.size());

    while (!integerStack.isEmpty()) {
      int peekItem = integerStack.peek();

      if (peekItem != integerStack.pop()) {
        throw new IllegalStateException("Peek value should be equal to pop value");
      }
    }

    Stack<Double> doubleStack = new ArrayStack<>();

    doubleStack.push(1.0);
    doubleStack.push(2.0);
    doubleStack.push(3.0);

    System.out.println("Size: " + doubleStack.size());

    while (!doubleStack.isEmpty()) {
      double peekItem = doubleStack.peek();

      if (peekItem != doubleStack.pop()) {
        throw new IllegalStateException("Peek value should be equal to pop value");
      }
    }

    Stack<String> stringStack = new ArrayStack<>();

    stringStack.push("Hello ");
    stringStack.push("World");
    stringStack.push("!!!");

    System.out.println("Size: " + stringStack.size());

    while (!stringStack.isEmpty()) {
      String peekItem = stringStack.peek();

      if (!peekItem.equals(stringStack.pop())) {
        throw new IllegalStateException("Peek value should be equal to pop value");
      }
    }
  }
}
