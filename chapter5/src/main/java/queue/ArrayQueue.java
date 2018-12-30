package queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
  private static final int DEFAULT_CAPACITY = 10;
  private static final int RESIZE_FACTOR = 2;

  private int capacity = DEFAULT_CAPACITY;
  private int size = 0;
  private int front = -1;
  private int back = -1;

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
    } else {
      E result = data[front];

      data[front] = null;
      front = (front + 1) % capacity;
      size -= 1;

      if(isEmpty()) {
        front = -1;
        back = -1;
      }

      return result;
    }
  }

  @Override
  public void enqueue(E item) {
    if(isEmpty()) {
      front = 0;
      back = 0;
      size += 1;
      data[0] = item;
    } else {
      if(isFull()) {
        resizeArray();
      }

      back = (back + 1) % capacity;
      data[back] = item;
      size += 1;
    }
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

  private boolean isFull() {
    return size() == capacity;
  }

  private void resizeArray() {
    int j = front;
    int oldCapacity = capacity;

    E[] newData = allocateArray(RESIZE_FACTOR * oldCapacity);

    for(int i = 0; i < size; i++) {
      newData[i] = data[j];
      j = (j + 1) % oldCapacity;
    }

    data = newData;

    front = 0;
    back = size - 1;
  }

  @SuppressWarnings("unchecked")
  private E[] allocateArray(int newCapacity) {
    capacity = newCapacity;

    return (E[]) new Object[newCapacity];
  }
}
