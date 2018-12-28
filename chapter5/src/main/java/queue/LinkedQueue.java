package queue;

import java.util.NoSuchElementException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class LinkedQueue<E> implements Queue<E> {
  private Node<E> front;
  private Node<E> back;

  private int size;

  @Override
  public E dequeue() {
    if(size == 0) {
      throw new NoSuchElementException();
    } else if(size == 1) {
      Node<E> p = front;

      front = null;
      back = null;
      size -= 1;

      return p.getData();
    } else {
      Node<E> p = front;

      front = front.getNext();
      size -= 1;

      return p.getData();
    }
  }

  @Override
  public void enqueue(E item) {
    Node<E> p = new Node<>(item);

    if(size == 0) {
      front = p;
      back = p;
    } else {
      back.setNext(p);
      back = p;
    }

    size += 1;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public E peek() {
    if(isEmpty()) {
      throw new NoSuchElementException();
    } else {
      return front.getData();
    }
  }

  @Override
  public int size() {
    return size;
  }

  public static void main(String[] args) {
    Queue<Integer> integerQueue = new LinkedQueue<>();

    integerQueue.enqueue(5);
    integerQueue.enqueue(6);
    integerQueue.enqueue(7);

    System.out.println("\n\nFront of queue: " + integerQueue.peek());
    System.out.println("Size of queue: " + integerQueue.size());
    System.out.println();

    while(!integerQueue.isEmpty()) {
      System.out.println("Dequeing " + integerQueue.dequeue());
    }

    System.out.println("\n");

    Queue<Double> doubleQueue = new LinkedQueue<>();

    doubleQueue.enqueue(5.0);
    doubleQueue.enqueue(6.0);
    doubleQueue.enqueue(7.0);

    System.out.println("Front of queue: " + doubleQueue.peek());
    System.out.println("Size of queue: " + doubleQueue.size());
    System.out.println();

    while(!doubleQueue.isEmpty()) {
      System.out.println("Dequeing " + doubleQueue.dequeue());
    }

    System.out.println("\n");

    Queue<String> stringQueue = new LinkedQueue<>();

    stringQueue.enqueue("Five");
    stringQueue.enqueue("Six");
    stringQueue.enqueue("Seven");

    System.out.println("Front of queue: " + stringQueue.peek());
    System.out.println("Size of queue: " + stringQueue.size());
    System.out.println();

    while(!stringQueue.isEmpty()) {
      System.out.println("Dequeing " + stringQueue.dequeue());
    }

    System.out.println("\n");
  }

  @Getter
  @Setter
  @AllArgsConstructor
  private static class Node<T> {
    private T data;
    private Node<T> next;

    Node(T data) {
      this(data, null);
    }
  }
}
