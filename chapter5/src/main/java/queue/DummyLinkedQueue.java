package queue;

import java.util.NoSuchElementException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class DummyLinkedQueue<E> implements Queue<E> {
  private Node<E> dummy = new Node<>();
  private Node<E> back = dummy;

  private int size;

  @Override
  public E dequeue() {
    if(isEmpty()) {
      throw new NoSuchElementException();
    }

    Node<E> front = dummy.getNext();

    dummy.setNext(front.getNext());
    size -= 1;

    if(isEmpty()) {
      back = dummy;
    }

    return front.getData();
  }

  @Override
  public void enqueue(E item) {
    Node<E> newNode = new Node<>(item);

    back.setNext(newNode);
    back = newNode;
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
    }

    return dummy.getNext().getData();
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
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Node<T> {
    private T data;
    private Node<T> next;

    Node(T data) {
      this(data, null);
    }
  }
}
