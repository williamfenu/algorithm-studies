package binary_search;

public class BinarySearch {

  public static void main(String[] args) {
    
    BinarySearch binarySearch = new BinarySearch();

    System.out.println(binarySearch.findIndex(new long[] {2, 4, 6, 8, 16, 24, 45}, 8));
  }

  public long findIndex(long[] sortedArrayToFind, long elementToFind) {

    int begin = 0;
    int end = sortedArrayToFind.length;
    int middle = (begin + end) / 2;
    long steps = 0;

    while (begin <= end) {
      ++steps;
      if (elementToFind > sortedArrayToFind[middle]) {
        begin = middle + 1;
      } else if (elementToFind < sortedArrayToFind[middle]) {
        end = middle - 1;
      } else {
        System.out.println("steps taken: " + steps);
        return middle;
      }

      middle = (begin + end) / 2;
    }

    System.out.println("steps taken: " + steps);
    return -1;

  }
}
