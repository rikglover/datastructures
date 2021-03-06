package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class LinkedQueue<E> implements Queue<E> {

  private Node<E> front;
  private Node<E> back;
  private int size;

  public static void main(String[] args) {
    Queue<Integer> integerQueue = new LinkedQueue<>();

    integerQueue.enqueue(5);
    integerQueue.enqueue(6);
    integerQueue.enqueue(7);

    System.out.println("\n\nFront of queue: " + integerQueue.peek());
    System.out.println("Size of queue: " + integerQueue.size());
    System.out.println();

    while (!integerQueue.isEmpty()) {
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

    while (!doubleQueue.isEmpty()) {
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

    while (!stringQueue.isEmpty()) {
      System.out.println("Dequeing " + stringQueue.dequeue());
    }

    System.out.println("\n");

    Deque<Integer> deque = new ArrayDeque<>();

    deque.push(3);
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    E result = front.getData();

    front = front.getNext();
    size -= 1;

    if (isEmpty()) {
      back = null;
    }

    return result;
  }

  @Override
  public void enqueue(E item) {
    Node<E> newNode = new Node<>(item);

    if (isEmpty()) {
      front = newNode;
    } else {
      back.setNext(newNode);
    }

    back = newNode;
    size += 1;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return front.getData();
  }

  @Override
  public int size() {
    return size;
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
