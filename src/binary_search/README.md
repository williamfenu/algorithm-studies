

# Binary Search

This code implements binary search algorithm to find the index of a given element in a sorted array.

## How to use

The `BinarySearch` class contains a `findIndex` method that takes in two arguments: 
1. A sorted array of long integers, `sortedArrayToFind`
2. An integer `elementToFind` to be searched for in the array.

```
long index = binarySearch.findIndex(new long[] {2, 4, 6, 8, 16, 24, 45}, 8);
```

The above code will search for the element `8` in the given sorted array and return its index if found. If the element is not found, it will return `-1`.

The `findIndex` method also prints the number of steps taken to find the element. 

## How it works

The algorithm works by repeatedly dividing the sorted array in half, and comparing the middle element to the target element. If the middle element is greater than the target, the search continues in the lower half of the array. If it is less than the target, the search continues in the upper half of the array. This process repeats until the target element is found or the search space is exhausted.

## Contributing

If you find any issues with the code, feel free to create an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
