package arrayfunctions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.Random;
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

  @Test
  public void testSelectionSort() {
    Random random = new Random();

    for (int i = 0; i < 100; i++) {
      int arraySize = Math.abs(random.nextInt(1000));

      Integer[] data = new Integer[arraySize];

      randomFill(data);

      ArrayFunctions.selectionSort(data);

      assertThat(isSorted(data)).isTrue();
    }

    Integer[] sortedReverse = { 1000, 900, 800, 700, 600, 500, 300, 200, 100, 0 };

    ArrayFunctions.selectionSort(sortedReverse);

    assertThat(isSorted(sortedReverse)).isTrue();

    Integer[] sortedIncreasing = { 0, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };

    ArrayFunctions.selectionSort(sortedReverse);

    assertThat(isSorted(sortedIncreasing)).isTrue();


    Integer[] allTheSame = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
    Integer[] expectedResult = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };

    ArrayFunctions.selectionSort(allTheSame);

    assertThat(allTheSame).isEqualTo(expectedResult);
  }

  @Test
  public void testInsertionSort() {
    Random random = new Random();

    for (int i = 0; i < 100; i++) {
      int arraySize = Math.abs(random.nextInt(1000));

      Integer[] data = new Integer[arraySize];

      randomFill(data);

      ArrayFunctions.insertionSort2(data);

      assertThat(isSorted(data)).isTrue();
    }

    Integer[] sortedReverse = { 1000, 900, 800, 700, 600, 500, 300, 200, 100, 0 };

    ArrayFunctions.insertionSort2(sortedReverse);

    assertThat(isSorted(sortedReverse)).isTrue();

    Integer[] sortedIncreasing = { 0, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };

    ArrayFunctions.insertionSort2(sortedReverse);

    assertThat(isSorted(sortedIncreasing)).isTrue();


    Integer[] allTheSame = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
    Integer[] expectedResult = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };

    ArrayFunctions.insertionSort2(allTheSame);

    assertThat(allTheSame).isEqualTo(expectedResult);
  }

  @Test
  public void testBubbleSort() {
    Random random = new Random();

    for (int i = 0; i < 100; i++) {
      int arraySize = Math.abs(random.nextInt(1000));

      Integer[] data = new Integer[arraySize];

      randomFill(data);

      ArrayFunctions.bubbleSort(data);

      assertThat(isSorted(data)).isTrue();
    }

    Integer[] sortedReverse = { 1000, 900, 800, 700, 600, 500, 300, 200, 100, 0 };

    ArrayFunctions.bubbleSort(sortedReverse);

    assertThat(isSorted(sortedReverse)).isTrue();

    Integer[] sortedIncreasing = { 0, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };

    ArrayFunctions.bubbleSort(sortedReverse);

    assertThat(isSorted(sortedIncreasing)).isTrue();


    Integer[] allTheSame = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
    Integer[] expectedResult = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };

    ArrayFunctions.bubbleSort(allTheSame);

    assertThat(allTheSame).isEqualTo(expectedResult);
  }

  private static void randomFill(Integer[] data) {
    Random random = new Random();

    for (int i = 0; i < data.length; i++) {
      data[i] = random.nextInt();
    }
  }

  private static <T extends Comparable<T>> boolean isSorted(T[] data) {
    for (int i = 0; i < data.length - 1; i++) {
      if (Objects.compare(data[i], data[i + 1], T::compareTo) > 0) {
        return false;
      }
    }

    return true;
  }
}
