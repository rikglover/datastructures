public class Chapter1 {

  public static void main(String[] args) {
    Queue queue = new QueueImpl();

    queue.enqueue(5);
    System.out.println(queue.dequeue());
  }

}
