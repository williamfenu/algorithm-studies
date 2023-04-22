package resursive_sum;

public class RecursiveSum {
  
  public static void main(String[] args) {
    RecursiveSum sum = new RecursiveSum();
    long[] newNumbers = {10l};
    newNumbers[0]= 10l;

    System.out.println("the sum is: " + sum.doSum(new long[] {25l, 25l, 10l}));
    
  }
  
  private long doSum(long[] numbers) {
    if(numbers.length == 0) {
      return 0;
    }else if(numbers.length == 1) {
      return numbers[0];
    }
    
    long[] newNumbers = new long[numbers.length -1];
    System.arraycopy(numbers, 1, newNumbers, 0, numbers.length-1);
    return numbers[0] + doSum(newNumbers);
  }

}
