package queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
  private static final int DEFAULT_CAPACITY = 10;
  private static final int RESIZE_FACTOR = 2;

  private int front = 0;
  private int back = -1;
  private int size = 0;

  private E[] data;

  public ArrayQueue() {
    this(DEFAULT_CAPACITY);
  }

  public ArrayQueue(int capacity) {
    data = allocateArray(capacity);
  }

  @Override
  public E dequeue() {
    if(isEmpty()) {
      throw new NoSuchElementException();
    }

    E result = data[front];

    data[front] = null;
    front = (front + 1) % data.length;
    size -= 1;

    return result;
  }

  @Override
  public void enqueue(E item) {
    if(size == data.length) {
      resizeArray(RESIZE_FACTOR * data.length);
    }

    back = (back + 1) % data.length;
    data[back] = item;
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

    return data[front];
  }

  @Override
  public int size() {
    return size;
  }

  public static void main(String[] args) {
    Queue<Integer> integerQueue = new ArrayQueue<>();

    integerQueue.enqueue(1);
    integerQueue.enqueue(2);
    integerQueue.enqueue(3);

    System.out.println();
    System.out.println("Size: " + integerQueue.size());

    while (!integerQueue.isEmpty()) {
      int peekItem = integerQueue.peek();

      System.out.println(peekItem);

      if (peekItem != integerQueue.dequeue()) {
        throw new IllegalStateException("Peek value should be equal to pop value");
      }
    }

    Queue<Double> doubleQueue = new ArrayQueue<>();

    doubleQueue.enqueue(1.0);
    doubleQueue.enqueue(2.0);
    doubleQueue.enqueue(3.0);

    System.out.println();
    System.out.println("Size: " + doubleQueue.size());

    while (!doubleQueue.isEmpty()) {
      double peekItem = doubleQueue.peek();

      System.out.println(peekItem);

      if (peekItem != doubleQueue.dequeue()) {
        throw new IllegalStateException("Peek value should be equal to pop value");
      }
    }

    Queue<String> stringQueue = new ArrayQueue<>();

    stringQueue.enqueue("Hello ");
    stringQueue.enqueue("world");
    stringQueue.enqueue("!!!");

    System.out.println();
    System.out.println("Size: " + stringQueue.size());

    while (!stringQueue.isEmpty()) {
      String peekItem = stringQueue.peek();

      System.out.println(peekItem);

      if (!peekItem.equals(stringQueue.dequeue())) {
        throw new IllegalStateException("Peek value should be equal to pop value");
      }
    }
  }

  protected int getCapacity() {
    return data.length;
  }

  private void resizeArray(int newCapacity) {
    E[] newData = allocateArray(newCapacity);

    int j = front;

    for(int i = 0; i < size; i++) {
      newData[i] = data[j];
      j = (j + 1) % data.length;
    }

    front = 0;
    back = size - 1;
    data = newData;
  }

  @SuppressWarnings("unchecked")
  private E[] allocateArray(int newCapacity) {
    return (E[]) new Object[newCapacity];
  }
}
