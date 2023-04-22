# Simple Search

This code implements a simple linear search algorithm to find the index of a given element in a sorted array.

## How to use

The `SimpleSearch` class contains a `findIndex` method that takes in two arguments:
1. A sorted array of long integers, `sortedArrayToFind`
2. An integer `elementToFind` to be searched for in the array.

```
long index = simpleSearch.findIndex(new long[] {2, 4, 6, 8, 16, 24, 45}, 6);
```

The above code will search for the element `6` in the given sorted array and return its index if found. If the element is not found, it will return `-1`.

The `findIndex` method also prints the number of steps taken to find the element.

## How it works

The algorithm works by iterating through the sorted array and comparing each element to the target element. If a match is found, the index of the element is returned. If the entire array is searched and no match is found, `-1` is returned.

## Contributing

If you find any issues with the code, feel free to create an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.