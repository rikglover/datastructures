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
