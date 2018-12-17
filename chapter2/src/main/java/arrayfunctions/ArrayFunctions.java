package arrayfunctions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;


public class ArrayFunctions {

  public static int linearSearch(int[] data, int target) {
    for (int i = 0; i < data.length; i++) {
      if (target == data[i]) {
        return i;
      }
    }

    return -1;
  }

  private static int linearSearch(String[] array, String target) {
    for (int i = 0; i < array.length; i++) {
      if (array[i].equals(target)) {
        return i;
      }
    }

    return -1;
  }

  public static int sum(int[] data) {
    int sum = 0;

    for (int datum : data) {
      sum += datum;
    }

    return sum;
  }

  public static int max(int[] data) {
    int max = data[0];

    for (int i = 1; i < data.length; i++) {
      if (data[i] > max) {
        max = data[i];
      }
    }

    return max;
  }

  public static int min(int[] data) {
    int min = data[0];

    for (int i = 1; i < data.length; i++) {
      if (data[i] < min) {
        min = data[i];
      }
    }

    return min;
  }

  public static void insertionSort(int[] data) {
    for (int i = 1; i < data.length; i++) {
      int key = data[i];
      int j = i - 1;

      while (j >= 0 && key < data[j]) {
        data[j + 1] = data[j];
        j -= 1;
      }

      data[j + 1] = key;
    }
  }

  public static void selectionSort(int[] data) {
    for(int i = 0; i < data.length - 1; i++) {
      int nextSmallestIndex = i;

      for(int j = i + 1; j < data.length; j++) {
        if(data[j] < data[nextSmallestIndex]) {
          nextSmallestIndex = j;
        }
      }

      if(i != nextSmallestIndex) {
        int temp = data[i];

        data[i] = data[nextSmallestIndex];
        data[nextSmallestIndex] = temp;
      }
    }
  }

  public static void displayArray(int[] data) {
    for (int datum : data) {
      System.out.print(datum + " ");
    }

    System.out.println();
  }

  private static void randomFill(int[] data) {
    Random random = new Random();

    for (int i = 0; i < data.length; i++) {
      data[i] = random.nextInt();
    }
  }

  private static void randomFill(int[] data, int max) {
    Random random = new Random();

    for (int i = 0; i < data.length; i++) {
      data[i] = random.nextInt(max);
    }
  }

  private static boolean isSorted(int[] data) {
    for (int i = 0; i < data.length - 1; i++) {
      if (data[i] > data[i + 1]) {
        return false;
      }
    }

    return true;
  }

  private static int binarySearch(int[] data, int target) {
    int left = 0;
    int right = data.length - 1;

    while(left <= right) {
      int mid = (left + right) / 2;

      if(target < data[mid]) {
        right = mid - 1;
      } else if(target > data[mid]) {
        left = mid + 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

  public static void main(String[] args) {

    int[] data = new int[100];

    randomFill(data);

    displayArray(data);

    insertionSort(data);

    boolean sorted = isSorted(data);

    System.out.println("IsSorted = " + sorted);

    System.out.println("\n");

    displayArray(data);

    int arraySize = 100;
    Map<Integer, Double> sortTimes = new LinkedHashMap<>();

    do {
      int[] testData = new int[arraySize];

      randomFill(testData);

      long time1 = System.currentTimeMillis();

      insertionSort(testData);

      long time2 = System.currentTimeMillis();
      double timeDelta = time2 - time1;

      if (!isSorted(data)) {
        throw new IllegalStateException("Should be sorted");
      }

      sortTimes.put(arraySize, timeDelta);

      arraySize *= 2;
    } while (arraySize < 200000);

    sortTimes.entrySet().forEach(entry -> {
      System.out.println("ArraySize = " + entry.getKey() + " -- Time = " + entry.getValue());
    });

    int[] sumData = new int[100];

    randomFill(sumData, 100);
    long sum = Arrays.stream(sumData).mapToLong(x -> x).sum();
    System.out.println("Sum = " + sum(sumData) + " actual Sum = " + sum);

    int[] maxData = new int[100];

    randomFill(maxData, 100);
    long max = Arrays.stream(maxData).mapToLong(x -> x).max()
        .orElseThrow(IllegalStateException::new);
    System.out.println("Max = " + max(maxData) + " actual max = " + max);

    int[] minData = new int[100];

    randomFill(minData, 100);
    long min = Arrays.stream(minData).mapToLong(x -> x).min()
        .orElseThrow(IllegalStateException::new);
    System.out.println("min = " + min(minData) + " actual min = " + min);

    Random random = new Random();

    int selectionSortArraySize = 100;

    while (selectionSortArraySize < 20000000) {

      int[] selectionSortData = new int[selectionSortArraySize];

      randomFill(selectionSortData);

      int randomIndex = random.nextInt(selectionSortArraySize - 1);
      int randomTarget = selectionSortData[randomIndex];

      System.out.println("ArraySize: " + selectionSortArraySize);
      System.out.println("Starting out sorted: " + isSorted(selectionSortData));

      long time1 = System.currentTimeMillis();
      selectionSort(selectionSortData);
      long time2 = System.currentTimeMillis();
      long delta = time2 - time1;
      int indexOfRandomTarget = binarySearch(selectionSortData, randomTarget);

      if(!isSorted(selectionSortData)) {
        throw new IllegalStateException("Array is not sorted");
      }

      if(selectionSortData[indexOfRandomTarget] != randomTarget) {
        throw new IllegalStateException("Index found is not valid");
      }

      System.out.println("done in " + delta + " milliseconds\n\n");

      selectionSortArraySize *= 2;
    }


    int[] lastData = new int[100];

    randomFill(lastData);

    int index = random.nextInt(100);
    int target = lastData[index];

    insertionSort(lastData);

    int result = binarySearch(lastData, target);

    if(lastData[result] != target) {
      throw new IllegalStateException("Value not found");
    }

    System.out.println("Found " + target + " at index " + index);
  }

}
