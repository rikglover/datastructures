package list;

import java.util.Objects;
import java.util.StringJoiner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class LinkedListJava<E> implements List<E> {
  private static final String SPACE = " ";
  private static final String OPEN_BRACKET = "[ ";
  private static final String CLOSED_BRACKET = " ]";

  private Node<E> head;
  private Node<E> tail;

  private int size;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public E set(int index, E item) {
    rangeCheck(index);

    Node<E> node = getNode(index);
    E result = node.getData();

    node.setData(item);

    return result;
  }

  @Override
  public E get(int index) {
    rangeCheck(index);

    Node<E> node = getNode(index);

    return node.getData();
  }

  @Override
  public boolean add(E item) {
    Node<E> newNode = new Node<>(item, null, tail);

    if (isEmpty()) {
      head = newNode;
    } else {
      tail.setNext(newNode);
    }

    tail = newNode;
    size += 1;

    return true;
  }

  @Override
  public void add(int index, E item) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

    if (index == size) {
      add(item);
    } else {
      Node<E> currentNode = getNode(index);
      Node<E> prev = currentNode.getPrev();
      Node<E> newNode = new Node<>(item, currentNode, prev);

      if (index == 0) {
        head = newNode;
      } else {
        prev.setNext(newNode);
      }

      currentNode.setPrev(newNode);
      size += 1;
    }
  }

  @Override
  public int indexOf(E item) {
    Node<E> p = head;

    for (int i = 0; i < size; i++) {
      if (Objects.equals(item, p.getData())) {
        return i;
      }

      p = p.getNext();
    }

    return -1;
  }

  @Override
  public E remove(int index) {
    rangeCheck(index);

    Node<E> node = getNode(index);
    Node<E> prev = node.getPrev();
    Node<E> next = node.getNext();
    E result = node.getData();

    if (prev != null) {
      prev.setNext(next);
    } else {
      head = next;
    }

    if (next != null) {
      next.setPrev(prev);
    } else {
      tail = prev;
    }

    size -= 1;

    return result;
  }

  @Override
  public boolean remove(E item) {
    int index = indexOf(item);

    if (index == -1) {
      return false;
    }

    remove(index);

    return true;
  }

  @Override
  public String toString() {
    Node<E> p = head;
    StringJoiner joiner = new StringJoiner(SPACE, OPEN_BRACKET, CLOSED_BRACKET);

    while (p != null) {
      String dataString = p.getData().toString();

      joiner.add(dataString);
      p = p.getNext();
    }

    return joiner.toString();
  }

  private Node<E> getNode(int index) {
    Node<E> p = head;

    for (int i = 0; i < index; i++) {
      p = p.getNext();
    }

    return p;
  }

  private void rangeCheck(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }

  @Setter
  @Getter
  @AllArgsConstructor
  private static class Node<T> {
    private T data;

    private Node<T> next;
    private Node<T> prev;
  }
}
