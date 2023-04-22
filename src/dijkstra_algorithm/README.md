# Dijkstra Algorithm

This project contains a Java implementation of the Dijkstra algorithm for finding the shortest path in a graph. 

## Usage

To use the Dijkstra algorithm, simply create an instance of the `DijkstraAlghorithm` class and call the `findShortestPath` method, passing in the graph as a `Map` and the starting and ending nodes as `String`s. 

```
DijkstraAlghorithm dijkstraAlghorith = new DijkstraAlghorithm();

Map<String, Map<String, Integer>> graph = new HashMap<>();
// populate the graph

Map<Integer, Stack<String>> shortestPath = dijkstraAlghorith.findShortestPath(graph, "begin", "end");
```

The `findShortestPath` method returns a `Map` containing the shortest path as a `Stack` of `String`s, and the total weight of the path as an `Integer`. 

## Example

An example graph is provided in the `main` method of the `DijkstraAlghorithm` class. The graph is defined using `HashMap`s and `Integer`s. 

```
Map<String, Map<String, Integer>> graph = new HashMap<>();
HashMap<String, Integer> beginNeighboursAndWeights = new HashMap<>();
HashMap<String, Integer> aNeighboursAndWeights = new HashMap<>();
HashMap<String, Integer> bNeighboursAndWeights = new HashMap<>();
HashMap<String, Integer> cNeighboursAndWeights = new HashMap<>();
HashMap<String, Integer> dNeighboursAndWeights = new HashMap<>();
HashMap<String, Integer> eNeighboursAndWeights = new HashMap<>();

beginNeighboursAndWeights.put("a", 3);
beginNeighboursAndWeights.put("b", 4);
beginNeighboursAndWeights.put("c", 1);
aNeighboursAndWeights.put("d", 2);
bNeighboursAndWeights.put("c", 7);
bNeighboursAndWeights.put("a", 3);
bNeighboursAndWeights.put("e", 5);
cNeighboursAndWeights.put("end", 16);
dNeighboursAndWeights.put("e", 4);
eNeighboursAndWeights.put("end", 9);
eNeighboursAndWeights.put("c", 3);

graph.put("begin", beginNeighboursAndWeights);
graph.put("a", aNeighboursAndWeights);
graph.put("b", bNeighboursAndWeights);
graph.put("c", cNeighboursAndWeights);
graph.put("d", dNeighboursAndWeights);
graph.put("e", eNeighboursAndWeights);
graph.put("end", new HashMap<>());

Map<Integer, Stack<String>> shortestPath = dijkstraAlghorith.findShortestPath(graph, "begin", "end");

shortestPath.entrySet().stream().forEach(entry -> {
  System.out.println("Shortest path: " + entry.getKey());
  System.out.print("Paths: ");
  while (!entry.getValue().isEmpty()) {
    System.out.print(" " + entry.getValue().pop() + " ");
  }
});
```

This will output the shortest path and its weight:

```
Shortest path: 13
Paths:  begin  a  d  e  end
```