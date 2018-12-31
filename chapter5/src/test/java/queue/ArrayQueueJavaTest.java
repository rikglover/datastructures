package queue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.NoSuchElementException;
import org.junit.Test;

public class ArrayQueueJavaTest {

  @Test(expected = NoSuchElementException.class)
  public void testPeekEmptyQueue() {
    Queue<Integer> queue = new ArrayQueueJava<>();

    queue.peek();

    assertThat(true).isFalse();
  }

  @Test(expected = NoSuchElementException.class)
  public void testDequeueEmptyQueue() {
    Queue<Integer> queue = new ArrayQueueJava<>();

    queue.dequeue();

    assertThat(true).isFalse();
  }

  @Test
  public void testQueue() {
    Queue<Integer> queue = new ArrayQueueJava<>();

    assertThat(queue.isEmpty()).isTrue();
    assertThat(queue.size()).isZero();

    queue.enqueue(5);

    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isOne();
    assertThat(queue.peek()).isEqualTo(5);
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isOne();
    assertThat(queue.dequeue()).isEqualTo(5);
    assertThat(queue.isEmpty()).isTrue();
    assertThat(queue.size()).isZero();

    queue.enqueue(5);
    queue.enqueue(6);

    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.peek()).isEqualTo(5);
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo(5);
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isOne();
    assertThat(queue.peek()).isEqualTo(6);
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isOne();
    assertThat(queue.dequeue()).isEqualTo(6);
    assertThat(queue.isEmpty()).isTrue();
    assertThat(queue.size()).isZero();

    queue.enqueue(5);
    queue.enqueue(6);
    queue.enqueue(7);

    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.peek()).isEqualTo(5);
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(5);
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.peek()).isEqualTo(6);
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo(6);
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isOne();
    assertThat(queue.peek()).isEqualTo(7);
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isOne();
    assertThat(queue.dequeue()).isEqualTo(7);
    assertThat(queue.isEmpty()).isTrue();
    assertThat(queue.size()).isZero();
  }

  @Test
  public void testQueueManyItems() {

    Queue<Integer> queue = new ArrayQueueJava<>();

    assertThat(queue.isEmpty()).isTrue();

    for (int i = 0; i < 100000; i++) {
      if (i != 0) {
        assertThat(queue.peek()).isEqualTo(0);
      }

      assertThat(queue.size()).isEqualTo(i);

      queue.enqueue(i);

      assertThat(queue.peek()).isEqualTo(0);
      assertThat(queue.size()).isEqualTo(i + 1);
    }

    for (int i = 0; i < 100000; i++) {
      if (i != 0) {
        assertThat(queue.peek()).isEqualTo(i);
      }

      assertThat(queue.size()).isEqualTo(100000 - i);
      assertThat(queue.dequeue()).isEqualTo(i);
      assertThat(queue.size()).isEqualTo(100000 - i - 1);
    }
  }

  @Test
  public void testDrift() {
    Queue<Integer> queue = new ArrayQueueJava<>();

    assertThat(queue.size()).isZero();
    assertThat(queue.isEmpty()).isTrue();

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(1);
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo(2);
    assertThat(queue.size()).isEqualTo(1);

    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);

    assertThat(queue.size()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(3);
    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(4);
    assertThat(queue.size()).isEqualTo(2);

    queue.enqueue(7);
    queue.enqueue(8);
    queue.enqueue(9);

    assertThat(queue.size()).isEqualTo(5);
    assertThat(queue.dequeue()).isEqualTo(5);
    assertThat(queue.size()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(6);
    assertThat(queue.size()).isEqualTo(3);

    queue.enqueue(10);
    queue.enqueue(11);
    queue.enqueue(12);

    assertThat(queue.size()).isEqualTo(6);
    assertThat(queue.dequeue()).isEqualTo(7);
    assertThat(queue.size()).isEqualTo(5);
    assertThat(queue.dequeue()).isEqualTo(8);
    assertThat(queue.size()).isEqualTo(4);

    queue.enqueue(13);
    queue.enqueue(14);
    queue.enqueue(15);

    assertThat(queue.size()).isEqualTo(7);
    assertThat(queue.dequeue()).isEqualTo(9);
    assertThat(queue.size()).isEqualTo(6);
    assertThat(queue.dequeue()).isEqualTo(10);
    assertThat(queue.size()).isEqualTo(5);

    queue.enqueue(16);
    queue.enqueue(17);
    queue.enqueue(18);
    queue.enqueue(19);
    queue.enqueue(20);

    assertThat(queue.isEmpty()).isFalse();

    queue.enqueue(21);

    assertThat(queue.size()).isEqualTo(11);
    assertThat(queue.dequeue()).isEqualTo(11);
    assertThat(queue.size()).isEqualTo(10);
    assertThat(queue.dequeue()).isEqualTo(12);
    assertThat(queue.size()).isEqualTo(9);
    assertThat(queue.dequeue()).isEqualTo(13);
    assertThat(queue.size()).isEqualTo(8);
    assertThat(queue.dequeue()).isEqualTo(14);
    assertThat(queue.size()).isEqualTo(7);
    assertThat(queue.dequeue()).isEqualTo(15);
    assertThat(queue.size()).isEqualTo(6);
    assertThat(queue.dequeue()).isEqualTo(16);
    assertThat(queue.size()).isEqualTo(5);
    assertThat(queue.dequeue()).isEqualTo(17);
    assertThat(queue.size()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(18);
    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(19);
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo(20);
    assertThat(queue.size()).isEqualTo(1);
    assertThat(queue.dequeue()).isEqualTo(21);
    assertThat(queue.size()).isEqualTo(0);

    assertThat(queue.isEmpty()).isTrue();


    // repeat process for better test!
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(1);
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo(2);
    assertThat(queue.size()).isEqualTo(1);

    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);

    assertThat(queue.size()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(3);
    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(4);
    assertThat(queue.size()).isEqualTo(2);

    queue.enqueue(7);
    queue.enqueue(8);
    queue.enqueue(9);

    assertThat(queue.size()).isEqualTo(5);
    assertThat(queue.dequeue()).isEqualTo(5);
    assertThat(queue.size()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(6);
    assertThat(queue.size()).isEqualTo(3);

    queue.enqueue(10);
    queue.enqueue(11);
    queue.enqueue(12);

    assertThat(queue.size()).isEqualTo(6);
    assertThat(queue.dequeue()).isEqualTo(7);
    assertThat(queue.size()).isEqualTo(5);
    assertThat(queue.dequeue()).isEqualTo(8);
    assertThat(queue.size()).isEqualTo(4);

    queue.enqueue(13);
    queue.enqueue(14);
    queue.enqueue(15);

    assertThat(queue.size()).isEqualTo(7);
    assertThat(queue.dequeue()).isEqualTo(9);
    assertThat(queue.size()).isEqualTo(6);
    assertThat(queue.dequeue()).isEqualTo(10);
    assertThat(queue.size()).isEqualTo(5);

    queue.enqueue(16);
    queue.enqueue(17);
    queue.enqueue(18);
    queue.enqueue(19);
    queue.enqueue(20);
    queue.enqueue(21);

    assertThat(queue.size()).isEqualTo(11);
    assertThat(queue.dequeue()).isEqualTo(11);
    assertThat(queue.size()).isEqualTo(10);
    assertThat(queue.dequeue()).isEqualTo(12);
    assertThat(queue.size()).isEqualTo(9);
    assertThat(queue.dequeue()).isEqualTo(13);
    assertThat(queue.size()).isEqualTo(8);
    assertThat(queue.dequeue()).isEqualTo(14);
    assertThat(queue.size()).isEqualTo(7);
    assertThat(queue.dequeue()).isEqualTo(15);
    assertThat(queue.size()).isEqualTo(6);
    assertThat(queue.dequeue()).isEqualTo(16);
    assertThat(queue.size()).isEqualTo(5);
    assertThat(queue.dequeue()).isEqualTo(17);
    assertThat(queue.size()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(18);
    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(19);
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo(20);
    assertThat(queue.size()).isEqualTo(1);
    assertThat(queue.dequeue()).isEqualTo(21);
    assertThat(queue.size()).isEqualTo(0);

    assertThat(queue.isEmpty()).isTrue();
  }

  @Test
  public void testFullQueueWithFrontGreaterThanBack() {
    Queue<Integer> queue = new ArrayQueueJava<>();

    assertThat(queue.isEmpty()).isTrue();
    assertThat(queue.size()).isZero();

    queue.enqueue(3);
    queue.enqueue(2);
    queue.enqueue(1);

    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isEqualTo(3);

    assertThat(queue.dequeue()).isEqualTo(3);
    assertThat(queue.size()).isEqualTo(2);
    assertThat(queue.isEmpty()).isFalse();

    assertThat(queue.dequeue()).isEqualTo(2);
    assertThat(queue.size()).isEqualTo(1);
    assertThat(queue.isEmpty()).isFalse();

    // So now the front and back of the queue are at index 2, with value 1
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    queue.enqueue(7);
    queue.enqueue(8);
    queue.enqueue(9);
    queue.enqueue(10);

    assertThat(queue.size()).isEqualTo(10);
    assertThat(queue.isEmpty()).isFalse();
  }

  @Test
  public void testFullQueueWithBackGreaterThanFront() {
    Queue<Integer> queue = new ArrayQueueJava<>();

    assertThat(queue.isEmpty()).isTrue();
    assertThat(queue.size()).isZero();

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    queue.enqueue(7);
    queue.enqueue(8);
    queue.enqueue(9);
    queue.enqueue(10);

    assertThat(queue.size()).isEqualTo(10);
    assertThat(queue.isEmpty()).isFalse();
  }
}
