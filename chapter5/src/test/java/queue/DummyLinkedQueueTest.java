package queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import org.junit.Test;

public class DummyLinkedQueueTest {

  @Test(expected = NoSuchElementException.class)
  public void testPeekEmptyQueue() {
    Queue<Integer> queue = new DummyLinkedQueue<>();

    queue.peek();

    assertThat(true).isFalse();
  }

  @Test(expected = NoSuchElementException.class)
  public void testDequeueEmptyQueue() {
    Queue<Integer> queue = new DummyLinkedQueue<>();

    queue.dequeue();

    assertThat(true).isFalse();
  }

  @Test
  public void testQueue() {
    Queue<Integer> queue = new DummyLinkedQueue<>();

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
}