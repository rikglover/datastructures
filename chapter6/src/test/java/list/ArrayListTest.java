package list;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ArrayListTest {

  @Test
  public void testSizeIsEmptyAndAdd() {
    list.List<Integer> list = new ArrayList<>();

    assertThat(list.size()).isZero();
    assertThat(list.isEmpty()).isTrue();

    list.add(1);

    assertThat(list.size()).isOne();

    list.add(2);

    assertThat(list.size()).isEqualTo(2);

    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);
    list.add(10);

    assertThat(list.size()).isEqualTo(10);
    assertThat(list.isEmpty()).isFalse();

    list.remove(9);

    assertThat(list.size()).isEqualTo(9);

    int size = list.size();
    while (!list.isEmpty()) {
      list.remove(0);
      size -= 1;
      assertThat(list.size()).isEqualTo(size);

      if (size != 0) {
        assertThat(list.isEmpty()).isFalse();
      }
    }

    assertThat(list.size()).isZero();
    assertThat(list.isEmpty()).isTrue();
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void setWithIndexOutOfBoundsException() {
    list.List<Integer> list = new ArrayList<>();

    list.set(1, 5);
  }

  @Test
  public void testSetGetAndIndexOf() {
    list.List<Integer> list = new ArrayList<>();

    list.add(10);
    list.add(11);
    list.add(12);

    int result = list.set(0, 0);

    assertThat(result).isEqualTo(10);

    int result2 = list.set(1, 1);

    assertThat(result2).isEqualTo(11);

    int result3 = list.set(2, 2);

    assertThat(result3).isEqualTo(12);

    int getResult1 = list.get(0);
    int getResult2 = list.get(1);
    int getResult3 = list.get(2);

    assertThat(getResult1).isEqualTo(0);
    assertThat(getResult2).isEqualTo(1);
    assertThat(getResult3).isEqualTo(2);
    assertThat(list.size()).isEqualTo(3);
    assertThat(list.indexOf(0)).isEqualTo(0);
    assertThat(list.indexOf(1)).isEqualTo(1);
    assertThat(list.indexOf(2)).isEqualTo(2);

    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);
    list.add(10);
    list.add(11);

    assertThat(list.get(10)).isEqualTo(10);
    assertThat(list.get(11)).isEqualTo(11);
    assertThat(list.size()).isEqualTo(12);
    assertThat(list.indexOf(10)).isEqualTo(10);
    assertThat(list.indexOf(11)).isEqualTo(11);
  }

  @Test
  public void testAddAndRemove() {

    list.List<Integer> list = new ArrayList<>();

    for (int i = 0; i < 22; i++) {
      list.add(i);
    }

    assertThat(list.size()).isEqualTo(22);

    assertThat(list.remove(0)).isEqualTo(0);
    assertThat(list.size()).isEqualTo(21);
    assertThat(list.get(0)).isEqualTo(1);
    assertThat(list.get(20)).isEqualTo(21);

    assertThat(list.remove(20)).isEqualTo(21);
    assertThat(list.size()).isEqualTo(20);
    assertThat(list.get(0)).isEqualTo(1);
    assertThat(list.get(19)).isEqualTo(20);

    for (int i = 0; i < 5; i++) {
      assertThat(list.remove(10)).isEqualTo(11 + i);
    }

    assertThat(list.size()).isEqualTo(15);
    assertThat(list.get(0)).isEqualTo(1);
    assertThat(list.get(1)).isEqualTo(2);
    assertThat(list.get(2)).isEqualTo(3);
    assertThat(list.get(3)).isEqualTo(4);
    assertThat(list.get(4)).isEqualTo(5);
    assertThat(list.get(5)).isEqualTo(6);
    assertThat(list.get(6)).isEqualTo(7);
    assertThat(list.get(7)).isEqualTo(8);
    assertThat(list.get(8)).isEqualTo(9);
    assertThat(list.get(9)).isEqualTo(10);
    assertThat(list.get(10)).isEqualTo(16);
    assertThat(list.get(11)).isEqualTo(17);
    assertThat(list.get(12)).isEqualTo(18);
    assertThat(list.get(13)).isEqualTo(19);
    assertThat(list.get(14)).isEqualTo(20);

    list.add(10, 11);
    list.add(11, 12);
    list.add(12, 13);
    list.add(13, 14);
    list.add(14, 15);

    assertThat(list.size()).isEqualTo(20);
    assertThat(list.get(0)).isEqualTo(1);
    assertThat(list.get(1)).isEqualTo(2);
    assertThat(list.get(2)).isEqualTo(3);
    assertThat(list.get(3)).isEqualTo(4);
    assertThat(list.get(4)).isEqualTo(5);
    assertThat(list.get(5)).isEqualTo(6);
    assertThat(list.get(6)).isEqualTo(7);
    assertThat(list.get(7)).isEqualTo(8);
    assertThat(list.get(8)).isEqualTo(9);
    assertThat(list.get(9)).isEqualTo(10);
    assertThat(list.get(10)).isEqualTo(11);
    assertThat(list.get(11)).isEqualTo(12);
    assertThat(list.get(12)).isEqualTo(13);
    assertThat(list.get(13)).isEqualTo(14);
    assertThat(list.get(14)).isEqualTo(15);
    assertThat(list.get(15)).isEqualTo(16);
    assertThat(list.get(16)).isEqualTo(17);
    assertThat(list.get(17)).isEqualTo(18);
    assertThat(list.get(18)).isEqualTo(19);
    assertThat(list.get(19)).isEqualTo(20);

    list.add(21);
    assertThat(list.get(20)).isEqualTo(21);

    list.add(22);
    assertThat(list.get(21)).isEqualTo(22);
  }

  @Test
  public void testToString() {
    list.List<Integer> list = new ArrayList<>();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    assertThat(list.toString()).isEqualTo("[ 1 2 3 4 5 ]");
  }

  @Test
  public void testToStringWithNulls() {
    list.List<Integer> list = new ArrayList<>();

    list.add(1);
    list.add(2);
    list.add(null);
    list.add(4);
    list.add(5);

    assertThat(list.toString()).isEqualTo("[ 1 2 null 4 5 ]");
  }
}
