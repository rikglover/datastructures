package list;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LinkedListTest {

  @Test
  public void testSizeAndIsEmpty() {
    List<Integer> list = new LinkedList<>();

    assertThat(list.isEmpty()).isTrue();
    assertThat(list.size()).isZero();

    list.add(1);

    assertThat(list.isEmpty()).isFalse();
    assertThat(list.size()).isOne();

    list.add(2);

    assertThat(list.isEmpty()).isFalse();
    assertThat(list.size()).isEqualTo(2);

    list.add(3);

    assertThat(list.isEmpty()).isFalse();
    assertThat(list.size()).isEqualTo(3);

    list.add(4);

    assertThat(list.isEmpty()).isFalse();
    assertThat(list.size()).isEqualTo(4);

    list.remove(0);

    assertThat(list.isEmpty()).isFalse();
    assertThat(list.size()).isEqualTo(3);

    list.remove(0);

    assertThat(list.isEmpty()).isFalse();
    assertThat(list.size()).isEqualTo(2);

    list.remove(0);

    assertThat(list.isEmpty()).isFalse();
    assertThat(list.size()).isEqualTo(1);

    list.remove(0);

    assertThat(list.isEmpty()).isTrue();
    assertThat(list.size()).isEqualTo(0);
  }

  @Test
  public void testIndexOf() {
    List<Integer> list = new LinkedList<>();

    assertThat(list.indexOf(5)).isEqualTo(-1);

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    assertThat(list.indexOf(1)).isZero();
    assertThat(list.indexOf(2)).isEqualTo(1);
    assertThat(list.indexOf(3)).isEqualTo(2);
    assertThat(list.indexOf(4)).isEqualTo(3);
    assertThat(list.indexOf(5)).isEqualTo(4);
    assertThat(list.indexOf(0)).isEqualTo(-1);
  }

  @Test
  public void testGetAndSet() {
    List<Integer> list = new LinkedList<>();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    assertThat(list.get(0)).isEqualTo(1);
    assertThat(list.get(1)).isEqualTo(2);
    assertThat(list.get(2)).isEqualTo(3);
    assertThat(list.get(3)).isEqualTo(4);
    assertThat(list.get(4)).isEqualTo(5);

    list.set(0, 51);
    list.set(1, 52);
    list.set(2, 53);
    list.set(3, 54);
    list.set(4, 55);

    assertThat(list.get(0)).isEqualTo(51);
    assertThat(list.get(1)).isEqualTo(52);
    assertThat(list.get(2)).isEqualTo(53);
    assertThat(list.get(3)).isEqualTo(54);
    assertThat(list.get(4)).isEqualTo(55);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetWithIndexOutOfBounds() {
    List<Integer> list = new LinkedList<>();

    list.get(0);

    assertThat(true).isFalse();
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetWithIndexOutOfBoundsAtIndex1() {
    List<Integer> list = new LinkedList<>();

    list.add(1);

    assertThat(list.get(0)).isEqualTo(1);

    list.get(1);

    assertThat(true).isFalse();
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testSetWithIndexOutOfBounds() {
    List<Integer> list = new LinkedList<>();

    list.set(0, 1);

    assertThat(true).isFalse();
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testSetWithIndexOutOfBoundsAtIndex1() {
    List<Integer> list = new LinkedList<>();

    list.add(1);
    list.set(0, 5);

    assertThat(list.get(0)).isEqualTo(5);

    list.get(1);

    assertThat(true).isFalse();
  }

  @Test
  public void testAddAndRemove() {
    List<Integer> list = new LinkedList<>();

    list.add(1);

    assertThat(list.toString()).isEqualTo("[ 1 ]");

    list.add(2);

    assertThat(list.toString()).isEqualTo("[ 1 2 ]");

    list.add(3);

    assertThat(list.toString()).isEqualTo("[ 1 2 3 ]");

    list.add(4);

    assertThat(list.toString()).isEqualTo("[ 1 2 3 4 ]");

    list.add(5);

    assertThat(list.toString()).isEqualTo("[ 1 2 3 4 5 ]");

    list.remove(2);

    assertThat(list.toString()).isEqualTo("[ 1 2 4 5 ]");

    list.remove(3);

    assertThat(list.toString()).isEqualTo("[ 1 2 4 ]");

    list.remove(0);

    assertThat(list.toString()).isEqualTo("[ 2 4 ]");

    list.remove(1);

    assertThat(list.toString()).isEqualTo("[ 2 ]");

    list.remove(0);

    assertThat(list.toString()).isEqualTo("[ ]");

    list.add(1);

    assertThat(list.toString()).isEqualTo("[ 1 ]");

    list.add(2);

    assertThat(list.toString()).isEqualTo("[ 1 2 ]");

    list.add(3);

    assertThat(list.toString()).isEqualTo("[ 1 2 3 ]");

    list.remove(2);

    assertThat(list.toString()).isEqualTo("[ 1 2 ]");

    list.add(5);

    assertThat(list.toString()).isEqualTo("[ 1 2 5 ]");
  }

  @Test
  public void testAddWithIndexAndRemove() {
    List<Integer> list = new LinkedList<>();

    list.add(list.size(), 0);
    list.add(list.size(), 2);
    list.add(list.size(), 4);
    list.add(list.size(), 6);
    list.add(list.size(), 8);

    assertThat(list.toString()).isEqualTo("[ 0 2 4 6 8 ]");

    list.add(1, 1);

    assertThat(list.toString()).isEqualTo("[ 0 1 2 4 6 8 ]");

    list.add(3, 3);

    assertThat(list.toString()).isEqualTo("[ 0 1 2 3 4 6 8 ]");

    list.add(5, 5);

    assertThat(list.toString()).isEqualTo("[ 0 1 2 3 4 5 6 8 ]");

    list.add(7, 7);

    assertThat(list.toString()).isEqualTo("[ 0 1 2 3 4 5 6 7 8 ]");

    list.add(0, -1);

    assertThat(list.toString()).isEqualTo("[ -1 0 1 2 3 4 5 6 7 8 ]");

    list.add(list.size(), 9);

    assertThat(list.toString()).isEqualTo("[ -1 0 1 2 3 4 5 6 7 8 9 ]");

    list.remove(0);

    assertThat(list.toString()).isEqualTo("[ 0 1 2 3 4 5 6 7 8 9 ]");

    list.remove(5);

    assertThat(list.toString()).isEqualTo("[ 0 1 2 3 4 6 7 8 9 ]");

    list.remove(6);

    assertThat(list.toString()).isEqualTo("[ 0 1 2 3 4 6 8 9 ]");

    list.remove(5);

    assertThat(list.toString()).isEqualTo("[ 0 1 2 3 4 8 9 ]");

    list.remove(0);

    assertThat(list.toString()).isEqualTo("[ 1 2 3 4 8 9 ]");

    list.remove(5);

    assertThat(list.toString()).isEqualTo("[ 1 2 3 4 8 ]");
    assertThat(list.size()).isEqualTo(5);
    assertThat(list.isEmpty()).isFalse();
  }

  @Test
  public void testRemoveByItem() {
    List<Integer> list = new LinkedList<>();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    assertThat(list.remove(Integer.valueOf(6))).isFalse();
    assertThat(list.remove(Integer.valueOf(1))).isTrue();
    assertThat(list.toString()).isEqualTo("[ 2 3 4 5 ]");
    assertThat(list.remove(Integer.valueOf(5))).isTrue();
    assertThat(list.toString()).isEqualTo("[ 2 3 4 ]");
    assertThat(list.remove(Integer.valueOf(3))).isTrue();
    assertThat(list.toString()).isEqualTo("[ 2 4 ]");
  }
}