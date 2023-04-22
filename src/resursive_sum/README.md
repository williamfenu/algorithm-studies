# Recursive Sum

This program implements a recursive algorithm to calculate the sum of an array of long integers.

## How to use

The `RecursiveSum` class contains a `doSum` method that takes in an array of long integers `numbers` as input and returns the sum of all the integers in the array.

```
RecursiveSum sum = new RecursiveSum();
long[] numbers = {25l, 25l, 10l};
long result = sum.doSum(numbers);
System.out.println("The sum is: " + result);
```

The above code will calculate the sum of the numbers in the `numbers` array and print the result.

## How it works

The `doSum` method works by recursively dividing the array into smaller subarrays until the subarray contains only one element. At that point, the method returns the value of the element. The recursive calls then add up the values of the elements returned by the previous recursive calls until the entire array has been summed.

For example, given the array `{25l, 25l, 10l}`, the algorithm will recursively divide it into the subarrays `{25l, 25l}` and `{10l}`. The subarray `{25l, 25l}` will then be divided into `{25l}` and `{25l}`, and each of these subarrays will return their respective values. These values are then added together to obtain the sum of the original array.

## Contributing

If you find any issues with the code, feel free to create an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.