package queue;

public class FixedLengthQueue<E> extends ArrayQueue<E> {
  private int drops;

  public FixedLengthQueue(int capacity) {
    super(capacity);
  }

  @Override
  public void enqueue(E item) {
    if(size() == getCapacity()) {
      drops += 1;
    } else {
      super.enqueue(item);
    }
  }

  public int drops() {
    return drops;
  }

  public static void main(String[] args) {
    Queue<Integer> fixedLengthIntegerQueue = new FixedLengthQueue<>(3);

    fixedLengthIntegerQueue.enqueue(1);
    fixedLengthIntegerQueue.enqueue(2);
    fixedLengthIntegerQueue.enqueue(3);
    fixedLengthIntegerQueue.enqueue(4);
    fixedLengthIntegerQueue.enqueue(5);

    System.out.println("Drops: " + ((FixedLengthQueue<Integer>) fixedLengthIntegerQueue).drops());


    Queue<Double> fixedLengthDoubleQueue = new FixedLengthQueue<>(3);

    fixedLengthDoubleQueue.enqueue(1.0);
    fixedLengthDoubleQueue.enqueue(2.0);
    fixedLengthDoubleQueue.enqueue(3.0);
    fixedLengthDoubleQueue.enqueue(4.0);
    fixedLengthDoubleQueue.enqueue(5.0);

    System.out.println("Drops: " + ((FixedLengthQueue<Double>) fixedLengthDoubleQueue).drops());


    Queue<String> fixedLengthStringQueue = new FixedLengthQueue<>(3);

    fixedLengthStringQueue.enqueue("A");
    fixedLengthStringQueue.enqueue("B");
    fixedLengthStringQueue.enqueue("C");
    fixedLengthStringQueue.enqueue("D");
    fixedLengthStringQueue.enqueue("E");

    System.out.println("Drops: " + ((FixedLengthQueue<String>) fixedLengthStringQueue).drops());
  }
}
