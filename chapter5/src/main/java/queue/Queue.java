package queue;

public interface Queue<E> {
  E dequeue();
  void enqueue(E item);
  boolean isEmpty();
  E peek();
  int size();
}
