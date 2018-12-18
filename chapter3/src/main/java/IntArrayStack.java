import java.util.EmptyStackException;

public class IntArrayStack implements IntStack {
  private static final int DEFAULT_CAPACITY = 10;
  private static final int RESIZE_FACTOR = 2;
  private static final int DOWNSIZE_FACTOR = 4;

  private int top = -1;

  private int[] data;

  public IntArrayStack() {
    this(DEFAULT_CAPACITY);
  }

  public IntArrayStack(int capacity) {
    data = new int[capacity];
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    return top + 1;
  }

  @Override
  public void push(int item) {
    if(size() == data.length) {
      int newCapacity = RESIZE_FACTOR * data.length;

      resize(newCapacity);
    }

    data[++top] = item;
  }

  @Override
  public int pop() {
    if(isEmpty()) {
      throw new EmptyStackException();
    }

    if(data.length > DEFAULT_CAPACITY && size() <= data.length / DOWNSIZE_FACTOR) {
      int newCapacity = data.length / RESIZE_FACTOR;

      if(newCapacity < DEFAULT_CAPACITY) {
        newCapacity = DEFAULT_CAPACITY;
      }

      resize(newCapacity);
    }

    return data[top--];
  }

  @Override
  public int peek() {
    if(isEmpty()) {
      throw new EmptyStackException();
    }

    return data[top];
  }

  private void resize(int newCapacity) {
    System.out.println("resizing to " + newCapacity);

    if(newCapacity <= 0) {
      throw new IllegalArgumentException("newCapacity must be greater than zero");
    }

    if(newCapacity == size()) {
      return;
    }

    int[] newData = new int[newCapacity];
    int itemsToCopy = size();

    System.arraycopy(data, 0, newData, 0, itemsToCopy);

    data = newData;
  }
}
