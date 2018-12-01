package arrayfunctions;

public class ArrayFunctions {
  public static int linearSearch(int[] data, int target) {
    for(int i = 0; i < data.length; i++) {
      if(target == data[i]) {
        return i;
      }
    }

    return -1;
  }

  public static int sum(int[] data) {
    int sum = 0;

    for(int datum : data) {
      sum += datum;
    }

    return sum;
  }

  public static int max(int[] data) {
    int max = data[0];

    for(int i = 1; i < data.length; i++) {
      if(data[i] > max) {
        max = data[i];
      }
    }

    return max;
  }

  public static int min(int[] data) {
    int min = data[0];

    for(int i = 1; i < data.length; i++) {
      if(data[i] < min) {
        min = data[i];
      }
    }

    return min;
  }

  public static void displayArray(int[] data) {
    for(int datum : data) {
      System.out.print(datum + " ");
    }

    System.out.println();
  }

  public static void main(String[] args) {
    int[] data = { 3, 14, 7, 22, 45, 12, 19, 42, 6 };

    displayArray(data);

    System.out.println();

    for(int target : data) {
      System.out.println("Search for " + target + " : " + linearSearch(data, target));
    }

    System.out.println("\nSum of data: " + sum(data));
    System.out.println("\nMax of data: " + max(data));
    System.out.println("\nMin of data: " + min(data));
  }
}
