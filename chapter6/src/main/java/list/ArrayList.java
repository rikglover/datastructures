package list;

import java.util.Objects;

public class ArrayList<E> implements List<E> {

  private static final int INITIAL_CAPACITY = 10;
  private static final int RESIZE_FACTOR = 2;
  private static final int DOWNSIZE_FACTOR = 4;

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
  public boolean add(E item) {
    add(size, item);

    return true;
  }

  @Override
  public void add(int index, E item) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

    if (size == data.length) {
      resize(RESIZE_FACTOR * data.length);
    }

    System.arraycopy(data, index, data, index + 1, size - index);
    data[index] = item;
    size += 1;
  }

  @Override
  public E set(int index, E item) {
    rangeCheck(index);

    E result = data[index];

    data[index] = item;

    return result;
  }

  @Override
  public E get(int index) {
    rangeCheck(index);

    return data[index];
  }

  @Override
  public int indexOf(E item) {
    for (int i = 0; i < size; i++) {
      if (Objects.equals(item, data[i])) {
        return i;
      }
    }

    return -1;
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
  public E remove(int index) {
    rangeCheck(index);

    E result = data[index];

    System.arraycopy(data, index + 1, data, index, size - index - 1);
    data[size - 1] = null;
    size -= 1;

    if(size <= data.length / DOWNSIZE_FACTOR && size > INITIAL_CAPACITY) {
      resize(data.length / RESIZE_FACTOR);
    }

    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("[ ");

    for(int i = 0; i < size; i++) {
      String itemString = Objects.toString(data[i]);

      builder.append(itemString);

      if(i < size - 1) {
        builder.append(" ");
      }
    }

    builder.append(" ]");

    return builder.toString();
  }

  private void rangeCheck(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }

  private void resize(int newCapacity) {
    if(newCapacity < size || newCapacity < INITIAL_CAPACITY) {
      throw new IllegalArgumentException("newCapacity too small");
    }

    E[] newData = allocateArray(newCapacity);

    System.arraycopy(data, 0, newData, 0, size);
    data = newData;
  }

  @SuppressWarnings("unchecked")
  private E[] allocateArray(int capacity) {
    return (E[]) new Object[capacity];
  }

  public static void main(String[] args) {
    List<Integer> integerList = new ArrayList<>();

    for(int i = 0; i < 5; i++) {
      integerList.add(i);
      System.out.println("item i: " + integerList.get(i));
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


    List<Double> doubleList = new ArrayList<>();

    for(int i = 0; i < 5; i++) {
      doubleList.add((double) i);
      System.out.println("item i: " + doubleList.get(i));
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


    List<String> stringList = new ArrayList<>();

    for(int i = 0; i < 5; i++) {
      stringList.add(String.valueOf(i));
      System.out.println("item i: " + stringList.get(i));
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
