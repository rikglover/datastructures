import java.util.EmptyStackException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class IntLinkedStack implements IntStack {
  private Node top = null;

  private int size = 0;

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void push(int item) {
    top = new Node(item, top);
    size += 1;
  }

  @Override
  public int pop() {
    if(isEmpty()) {
      throw new EmptyStackException();
    }

    int data = top.getData();

    top = top.getNext();
    size -= 1;

    return data;
  }

  @Override
  public int peek() {
    if(isEmpty()) {
      throw new EmptyStackException();
    }

    return top.getData();
  }

  @Setter
  @Getter
  @AllArgsConstructor
  private static class Node {
    private int data;
    private Node next;
  }

  public static void main(String[] args) {
    IntStack s = new IntLinkedStack();

    for(int i = 0; i < 5; i++) {
      s.push(i);
    }

    while(!s.isEmpty()) {
      System.out.println(s.pop());
    }

    for(int i = 0; i < 1000000; i++) {
      s.push(i);
    }

    System.out.println("Size: " + s.size());

    while(!s.isEmpty()) {
      int peekValue = s.peek();
      int popValue = s.pop();

      if(peekValue != popValue) {
        System.out.println("Peek Value: " + peekValue + "   Popped Value: " + popValue);
      }
    }

    System.out.println("Size: " + s.size());
  }
}


