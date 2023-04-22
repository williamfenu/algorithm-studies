package quick_sort;

import java.util.Arrays;

public class Quicksort {

  public static void main(String[] args) {

    Quicksort quicksort = new Quicksort();

    long[] sorted = quicksort.doQuickSort(new long[] {5, 9, 1, 0, 6, 2, 8});

    System.out.println(Arrays.toString(sorted));
  }


  public long[] doQuickSort(long[] unsortedArray) {

    if (unsortedArray.length == 0 || unsortedArray.length == 1) {
      return unsortedArray;
    }

    long pivot = unsortedArray[0];
    long[] mins = new long[unsortedArray.length];
    long[] maxes = new long[unsortedArray.length];

    int minIndex = 0, maxIndex = 0;

    for (int i = 0; i < unsortedArray.length; i++) {
      if (unsortedArray[i] > pivot) {
        maxes[maxIndex] = unsortedArray[i];
        maxIndex++;
      } else if (unsortedArray[i] < pivot) {
        mins[minIndex] = unsortedArray[i];
        minIndex++;
      }
    }

    long[] divided = new long[minIndex + maxIndex + 1];

    System.arraycopy(doQuickSort(Arrays.copyOf(mins, minIndex)), 0, divided, 0, minIndex);
    divided[minIndex] = pivot;
    System.arraycopy(doQuickSort(Arrays.copyOf(maxes, maxIndex)), 0, divided, minIndex + 1, maxIndex);

    return divided;
  }
}
