import java.util.Objects;

public class Search {

  public static <T extends Comparable<? super T>> int binarySearch(T[] data, T target) {
    return binarySearch(data, target, 0, data.length - 1);
  }

  private static <T extends Comparable<? super T>>  int binarySearch(T[] data, T target, int low, int high) {
    if (low > high) {
      return -1;
    }

    int midPoint = (low + high) / 2;
    int compareValue = Objects.compare(target, data[midPoint], T::compareTo);

    if(compareValue == 0) {
      return midPoint;
    } else if(compareValue < 0) {
      return binarySearch(data, target, 0, midPoint - 1);
    } else {
      return binarySearch(data, target, midPoint + 1, high);
    }
  }

  public static int linearSearch(Object[] data, Object target) {
    return linearSearch(data, target, 0);
  }

  private static int linearSearch(Object[] data, Object target, int start) {
    if(start >= data.length) {
      return -1;
    }

    if(Objects.equals(data[start], target)) {
      return start;
    }

    return linearSearch(data, target, start + 1);
  }

  public static void main(String[] args) {
    Integer[] intData = { 1, 5, 10, 15, 20, 25, 30, 35 };
    String[] stringData = { "a", "b", "c", "d", "e", "f", "g", "h", "i" };
    Double[] doubleData = { 1.0, 5.0, 10.0, 15.0, 20.0, 25.0, 30.0, 35.0 };

    int intIndex = linearSearch(intData, 15);
    int intIndex2 = binarySearch(intData, 15);

    int stringIndex = linearSearch(stringData, "d");
    int stringIndex2 = binarySearch(stringData, "d");

    int doubleIndex = linearSearch(doubleData, 5.0);
    int doubleIndex2 = binarySearch(doubleData, 5.0);


    System.out.println("Linear Search: The target 5 can be found at index " + intIndex);
    System.out.println("Binary Search: The target 5 can be found at index " + intIndex2);

    System.out.println("The target d can be found at index " + stringIndex);
    System.out.println("The target d can be found at index " + stringIndex2);

    System.out.println("The target 5 can be found at index " + doubleIndex);
    System.out.println("The target 5 can be found at index " + doubleIndex2);
  }
}
