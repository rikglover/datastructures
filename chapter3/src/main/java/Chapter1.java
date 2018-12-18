public class Chapter1 {

  public static void main(String[] args) {
    Queue queue = new QueueImpl();

    queue.enqueue(5);
    System.out.println(queue.dequeue());

    IntStack s = new IntArrayStack();

    System.out.println("Starts out empty: " + s.isEmpty());
    System.out.println("Size: " + s.size());

    for(int i = 0; i < 5; i++) {
      s.push(i);
    }

    System.out.println("Ends up not empty: " + !s.isEmpty());
    System.out.println("Size: " + s.size());

    while(!s.isEmpty()) {
      System.out.println(s.pop());
    }

    for(int i = 0; i < 1000; i++) {
      s.push(i);
    }

    while(!s.isEmpty()) {
      s.pop();
    }

    System.out.println("Done!!!");
  }

}
