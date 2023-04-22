package simple_search;

public class SimpleSearch {
  
  public static void main(String[] args) {
    
    SimpleSearch simpleSearch = new SimpleSearch();
    
    System.out.println(simpleSearch.findIndex(new long[] {2, 4, 6, 8, 16, 24, 45}, 6));
  }
  
  public long findIndex(long[] sortedArrayToFind, long elementToFind) {
    
    long steps = 0;
    
    for (int i = 0; i < sortedArrayToFind.length; i++, ++steps) {
      if(sortedArrayToFind[i] == elementToFind) {
        System.out.println("steps taken: " + steps);
        return i;
      }
    }
    
    System.out.println("steps taken: " + steps);
    return -1;

  }
}
