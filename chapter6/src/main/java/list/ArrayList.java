package list;

import java.util.Objects;

public class ArrayList<E> implements List<E> {

  private static final int INITIAL_CAPACITY = 10;
  private static final int RESIZE_FACTOR = 2;

  private E[] data;

  private int size;

  public ArrayList() {
    this(INITIAL_CAPACITY);
  }

  public ArrayList(int capacity) {
    data = allocateArray(capacity);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void add(E item) {
    add(size, item);
  }

  @Override
  public void add(int index, E item) {
    if(index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

    if(size == data.length) {
      resize();
    }

    System.arraycopy(data, index, data, index + 1, size - index);
    data[index] = item;
    size += 1;
  }

  @Override
  public E set(int index, E item) {
    if(index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    E result = data[index];

    data[index] = item;

    return result;
  }

  @Override
  public E get(int index) {
    if(index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    return data[index];
  }

  @Override
  public int indexOf(E item) {
    for(int i = 0; i < size; i++) {
      if(Objects.equals(item, data[i])) {
        return i;
      }
    }

    return -1;
  }

  @Override
  public E remove(E item) {
    int index = indexOf(item);

    return remove(index);
  }

  @Override
  public E remove(int index) {
    if(index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }

    E result = data[index];

    System.arraycopy(data, index + 1, data, index, size - index - 1);
    data[size - 1] = null;
    size -= 1;

    return result;
  }

  private void resize() {
    E[] newData = allocateArray(RESIZE_FACTOR*data.length);

    System.arraycopy(data, 0, newData, 0, data.length);
    data = newData;
  }

  @SuppressWarnings("unchecked")
  private E[] allocateArray(int capacity) {
    return (E[]) new Object[capacity];
  }
}
