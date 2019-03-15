import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SearchTest {

  @Test
  public void binarySearchInteger() {
    Integer[] data = { 1, 2, 5, 7, 8, 9, 10, 12 };
    Integer target = 5;

    int index = Search.binarySearch(data, target);

    assertThat(index).isEqualTo(2);
  }

  @Test
  public void binarySearchIntegerNotFound() {
    Integer[] data = { 1, 2, 5, 7, 8, 9, 10, 12 };
    Integer target = 0;

    int index = Search.binarySearch(data, target);

    assertThat(index).isEqualTo(-1);
  }

  @Test
  public void binarySearchDouble() {
    Double[] data = { 1.0, 2.0, 5.0, 7.0, 8.0, 9.0, 10.0, 12.0 };
    Double target = 5.0;

    int index = Search.binarySearch(data, target);

    assertThat(index).isEqualTo(2);
  }

  @Test
  public void binarySearchDoubleNotFound() {
    Double[] data = { 1.0, 2.0, 5.0, 7.0, 8.0, 9.0, 10.0, 12.0 };
    Double target = 0.0;

    int index = Search.binarySearch(data, target);

    assertThat(index).isEqualTo(-1);
  }

  @Test
  public void linearSearch() {
    Integer[] data = { 1, 5, 10, 12, 15, 20, 25, 30 };

    int actualResult = Search.linearSearch(data, 12);

    assertThat(actualResult).isEqualTo(3);
  }

  @Test
  public void linearSearchNotFound() {
    Integer[] data = { 1, 32, 2, 21, 15, 23, 25, 3 };

    int actualResult = Search.linearSearch(data, 31);

    assertThat(actualResult).isEqualTo(-1);
  }

  @Test
  public void linearSearchEmptyArray() {
    Integer[] data = { };

    int actualResult = Search.linearSearch(data, 31);

    assertThat(actualResult).isEqualTo(-1);
  }

  @Test
  public void linearSearchNullFound() {
    Integer[] data = { 1, 32, 2, 21, 15, null, 25, 3 };

    int actualResult = Search.linearSearch(data, null);

    assertThat(actualResult).isEqualTo(5);
  }

  @Test
  public void linearSearchNullNotFound() {
    Integer[] data = { 1, 32, 2, 21, 15, 16, 25, 3 };

    int actualResult = Search.linearSearch(data, null);

    assertThat(actualResult).isEqualTo(-1);
  }
}
