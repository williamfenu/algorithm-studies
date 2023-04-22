# Quick Sort

This code implements Quick Sort algorithm, which is an efficient sorting algorithm that works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively.

## How to use

The `Quicksort` class contains a `doQuickSort` method that takes in an unsorted array of long integers, `unsortedArray`, and returns a sorted array.

```
long[] sorted = quicksort.doQuickSort(new long[] {5, 9, 1, 0, 6, 2, 8});
```

The above code will sort the given array using the Quick Sort algorithm and store the sorted array in the `sorted` variable.

## How it works

The `doQuickSort` method first checks if the length of the array is 0 or 1, in which case it returns the array as it is. Otherwise, it selects the first element of the array as the pivot element and creates two new arrays, `mins` and `maxes`, to hold the elements less than and greater than the pivot element respectively.

The method then iterates over the array, placing each element in either the `mins` or `maxes` array based on whether it is less than or greater than the pivot element.

Once the elements have been partitioned, the method creates a new array called `divided` with enough space to hold all the elements of `mins`, `maxes`, and the pivot element. It then recursively calls itself with the `mins` and `maxes` arrays, and copies the resulting sorted arrays into the `divided` array, placing the pivot element in the middle.

## Contributing

If you find any issues with the code, feel free to create an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.