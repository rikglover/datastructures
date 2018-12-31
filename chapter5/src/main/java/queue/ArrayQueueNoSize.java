package queue;

import java.util.NoSuchElementException;

public class ArrayQueueNoSize<E> implements Queue<E> {
  private static final int DEFAULT_CAPACITY = 10;
  private static final int RESIZE_FACTOR = 2;

  private int front = 0;
  private int back = -1;

  private E[] data;

  public ArrayQueueNoSize() {
    this(DEFAULT_CAPACITY);
  }

  public ArrayQueueNoSize(int capacity) {
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

    return result;
  }

  @Override
  public void enqueue(E item) {
    if(size() == data.length - 1) {
      resizeArray();
    }

    back = (back + 1) % data.length;
    data[back] = item;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
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
    if(front > back) {
      return (data.length + back - front + 1) % data.length;
    } else {
      return back - front + 1;
    }
  }

  public static void main(String[] args) {
    Queue<Integer> integerQueue = new ArrayQueueNoSize<>();

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

    Queue<Double> doubleQueue = new ArrayQueueNoSize<>();

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

    Queue<String> stringQueue = new ArrayQueueNoSize<>();

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

  private void resizeArray() {
    E[] newData = allocateArray(RESIZE_FACTOR * data.length);

    int j = front;

    for(int i = 0; i < size(); i++) {
      newData[i] = data[j];
      j = (j + 1) % data.length;
    }

    front = 0;
    back = size() - 1;
    data = newData;
  }

  @SuppressWarnings("unchecked")
  private E[] allocateArray(int capacity) {
    return (E[]) new Object[capacity];
  }
}
