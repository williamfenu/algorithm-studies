# Breadth First Search

This is a Java implementation of the Breadth First Search algorithm. It finds the shortest path between a starting node and a destination node in a graph.

## Usage

To use this implementation, simply create a `Node` graph and call the `findShortestPath` method with the `Node` graph and a `Node` destination. The method will return the length of the shortest path between the starting node and the destination node. 

```java
Node graph = new Node("start",
    Arrays.asList(
        new Node("a",
            Arrays.asList(new Node("c",
                Arrays.asList(new Node("d", 
                    Arrays.asList(new Node("e", 
                        Arrays.asList(new Node("f"), new Node("g", 
                                            Arrays.asList(new Node("h", 
                                                Arrays.asList(new Node("end")))))
                    ))))))))
        ,
        new Node("b", Arrays.asList(new Node("end")))
        )
    );

BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
System.out.println(breadthFirstSearch.findShortestPath(graph, new Node("end"))); // 2
```

## Node Class

The `Node` class represents a node in a graph. Each node has a name and a list of neighbours. 

```java
class Node {
  private String name;
  private List<Node> neighbours;

  public Node(String name) {
    this(name, Collections.emptyList());
  }

  public Node(String name, List<Node> neighbours) {
    this.name = name;
    this.neighbours = neighbours;
  }

  // getters and setters
}
```