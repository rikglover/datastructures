package arrayfunctions;

import static org.assertj.core.api.Assertions.assertThat;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ArrayFunctionsTest {

  @Test
  public void testBinarySearchEvenSizeArray() {
    Integer[] data = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    for (int i = 0; i < data.length; i++) {
      int expectedResult = i;
      int actualResult = ArrayFunctions.binarySearch(data, data[i]);

      assertThat(actualResult).isEqualTo(expectedResult);
    }
  }

  @Test
  public void testBinarySearchEvenSizeArrayNotFoundSmall() {
    Integer[] data = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    int expectedResult = -1;
    int actualResult = ArrayFunctions.binarySearch(data, 0);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @Test
  public void testBinarySearchEvenSizeArrayNotFoundBig() {
    Integer[] data = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

    int expectedResult = -1;
    int actualResult = ArrayFunctions.binarySearch(data, 20);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @Test
  public void testBinarySearchOddSizeArray() {
    Integer[] data = {1, 3, 5, 7, 9, 11, 13, 15, 17};

    for (int i = 0; i < data.length; i++) {
      int expectedResult = i;
      int actualResult = ArrayFunctions.binarySearch(data, data[i]);

      assertThat(actualResult).isEqualTo(expectedResult);
    }
  }

  @Test
  public void testBinarySearchOddSizeArrayNotFoundSmall() {
    Integer[] data = {1, 3, 5, 7, 9, 11, 13, 15, 17};

    int expectedResult = -1;
    int actualResult = ArrayFunctions.binarySearch(data, 0);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @Test
  public void testBinarySearchOddSizeArrayNotFoundBig() {
    Integer[] data = {1, 3, 5, 7, 9, 11, 13, 15, 17};

    int expectedResult = -1;
    int actualResult = ArrayFunctions.binarySearch(data, 20);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
