package arraystack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EmptyStackException;
import org.junit.Test;
import stack.ArrayStack;
import stack.Stack;

public class ArrayStackTest {

  @Test
  public void isEmpty() {
    Stack<String> stack = new ArrayStack<>();

    assertThat(stack.isEmpty()).isTrue();
  }

  @Test
  public void size() {
    Stack<Integer> stack = new ArrayStack<>();

    assertThat(stack.size()).isEqualTo(0);

    stack.push(1);
    stack.push(2);
    stack.push(3);

    assertThat(stack.size()).isEqualTo(3);
  }

  @Test
  public void pushPopPeek() {
    Stack<Double> stack = new ArrayStack<>();

    assertThat(stack.size()).isEqualTo(0);

    stack.push(1.0);

    assertThat(stack.size()).isEqualTo(1);

    stack.push(2.0);

    assertThat(stack.size()).isEqualTo(2);

    Double peekValue = stack.peek();

    assertThat(peekValue).isEqualTo(2.0);

    Double popValue = stack.pop();

    assertThat(popValue).isEqualTo(2.0);
    assertThat(stack.size()).isEqualTo(1);
    assertThat(stack.pop()).isEqualTo(1.0);

    assertThat(stack.size()).isZero();
  }

  @Test
  public void pushWithResize() {
    Stack<Integer> stack = new ArrayStack<>();

    for(int i = 1; i <= 100000; i++) {
      stack.push(i);

      assertThat(stack.size()).isEqualTo(i);
    }

    while(!stack.isEmpty()) {
      stack.pop();
    }

    assertThat(stack.size()).isZero();
  }

  @Test(expected = EmptyStackException.class)
  public void popEmpty() {
    Stack<Float> stack = new ArrayStack<>();

    stack.pop();

    assertThat(true).isFalse();
  }

  @Test(expected = EmptyStackException.class)
  public void peekEmpty() {
    Stack<Float> stack = new ArrayStack<>();

    stack.peek();

    assertThat(true).isFalse();
  }
}