package list;

import java.util.StringJoiner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class LinkedList<E> implements List<E> {
  private static final String SPACE = " ";
  private static final String OPEN_BRACKET = "[";
  private static final String CLOSED_BRACKET = "]";

  private Node<E> head = new Node<>();

  private int size = 0;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int indexOf(E item) {
    int i = 0;

    Node<E> p = head.getNext();

    while (p != null) {
      if (p.getData().equals(item)) {
        return i;
      }

      p = p.getNext();
      i += 1;
    }

    return -1;
  }

  @Override
  public E get(int index) {
    rangeCheck(index);

    Node<E> p = getNode(index);

    return p.getData();
  }

  @Override
  public E set(int index, E item) {
    rangeCheck(index);

    Node<E> p = getNode(index);

    E result = p.getData();

    p.setData(item);

    return result;
  }

  @Override
  public boolean add(E item) {
    add(size, item);

    return true;
  }

  @Override
  public void add(int index, E item) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

    Node<E> prev = getNode(index - 1);
    Node<E> newNode = new Node<>(item, prev.getNext(), prev);

    if (prev.getNext() != null) {
      prev.getNext().setPrev(newNode);
    }

    prev.setNext(newNode);
    size += 1;
  }

  @Override
  public E remove(int index) {
    rangeCheck(index);

    Node<E> p = getNode(index);
    E result = p.getData();

    p.getPrev().setNext(p.getNext());

    if (p.getNext() != null) {
      p.getNext().setPrev(p.getPrev());
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
    Node<E> p = head.getNext();

    StringJoiner joiner = new StringJoiner(SPACE);

    joiner.add(OPEN_BRACKET);

    while(p != null) {
      String dataString = p.getData().toString();

      joiner.add(dataString);
      p = p.getNext();
    }

    joiner.add(CLOSED_BRACKET);

    return joiner.toString();
  }

  private void rangeCheck(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }

  private Node<E> getNode(int index) {
    Node<E> p = head;

    for (int i = -1; i < index; i++) {
      p = p.getNext();
    }

    return p;
  }

  @Setter
  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Node<T> {
    private T data;

    private Node<T> next;
    private Node<T> prev;
  }

  public static void main(String[] args) {
    List<Integer> integerList = new LinkedList<>();

    for(int i = 0; i < 5; i++) {
      integerList.add(i);
      System.out.println("item " + i + ": " + integerList.get(i));
    }

    System.out.println();
    System.out.println(integerList);
    System.out.println();

    while(!integerList.isEmpty()) {
      System.out.println(integerList.remove(0));
    }

    System.out.println();
    System.out.println("Size: " + integerList.size());
    System.out.println();

    List<Double> doubleList = new LinkedList<>();

    for(int i = 0; i < 5; i++) {
      doubleList.add((double) i);
      System.out.println("item " + i + ": " + doubleList.get(i));
    }

    System.out.println();
    System.out.println(doubleList);
    System.out.println();

    while(!doubleList.isEmpty()) {
      System.out.println(doubleList.remove(0));
    }

    System.out.println();
    System.out.println("Size: " + doubleList.size());
    System.out.println();


    List<String> stringList = new LinkedList<>();

    for(int i = 0; i < 5; i++) {
      stringList.add(String.valueOf(i));
      System.out.println("item " + i + ": " + stringList.get(i));
    }

    System.out.println();
    System.out.println(stringList);
    System.out.println();

    while(!stringList.isEmpty()) {
      System.out.println(stringList.remove(0));
    }

    System.out.println();
    System.out.println("Size: " + stringList.size());
    System.out.println();
  }
}
