package stack;

import java.util.EmptyStackException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class LinkedStack<E> implements Stack<E> {
  private Node<E> top = null;

  private int size = 0;

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void push(E item) {
    top = new Node<>(item, top);
    size += 1;
  }

  @Override
  public E pop() {
    if(isEmpty()) {
      throw new EmptyStackException();
    }

    E data = top.getData();

    top = top.getNext();
    size -= 1;

    return data;
  }

  @Override
  public E peek() {
    if(isEmpty()) {
      throw new EmptyStackException();
    }

    return top.getData();
  }

  @AllArgsConstructor
  @Getter
  @Setter
  private static class Node<T> {
    private T data;
    private Node<T> next;
  }

  public static void main(String[] args) {
    Stack<Integer> integerStack = new LinkedStack<>();

    integerStack.push(1);
    integerStack.push(2);
    integerStack.push(3);

    System.out.println("Size: " + integerStack.size());

    while(!integerStack.isEmpty()) {
      int peekItem = integerStack.peek();

      if(peekItem != integerStack.pop()) {
        throw new IllegalStateException("Peek value should be equal to pop value");
      }
    }


    Stack<Double> doubleStack = new LinkedStack<>();

    doubleStack.push(1.0);
    doubleStack.push(2.0);
    doubleStack.push(3.0);

    System.out.println("Size: " + doubleStack.size());

    while(!doubleStack.isEmpty()) {
      double peekItem = doubleStack.peek();

      if(peekItem != doubleStack.pop()) {
        throw new IllegalStateException("Peek value should be equal to pop value");
      }
    }


    Stack<String> stringStack = new LinkedStack<>();

    stringStack.push("Hello ");
    stringStack.push("World");
    stringStack.push("!!!");

    System.out.println("Size: " + stringStack.size());

    while(!stringStack.isEmpty()) {
      String peekItem = stringStack.peek();

      if(!peekItem.equals(stringStack.pop())) {
        throw new IllegalStateException("Peek value should be equal to pop value");
      }
    }
  }
}
