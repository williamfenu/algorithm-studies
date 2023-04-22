package breadth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BreadthFirstSearch {

  public static void main(String[] args) {
    //@formatter:off
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
    
    //@formatter:on

    BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
    System.out.println(breadthFirstSearch.findShortestPath(graph, new Node("end"))); // 2
  }

  public int findShortestPath(Node graph, Node destiny) {
    List<Node> verified = new ArrayList<>();
    ArrayList<Node> graphState = new ArrayList<>(graph.getNeighbours());
    int levelSize = graphState.size();
    int steps = 1;

    if (!verified.contains(graph) && graph.equals(destiny)) {
      return 0;
    }

    for (int i = 0; i < graphState.size(); i++) {
      if (!verified.contains(graphState.get(i)) && graphState.get(i).equals(destiny)) {
        return steps;
      } else {
        graphState.addAll(graphState.get(i).getNeighbours());
        verified.add(graphState.get(i));
        if (i == levelSize - 1) {
          steps++;
          levelSize = graphState.size();
        }
      }
    }

    return -1;
  }
}


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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Node> getNeighbours() {
    return neighbours;
  }

  public void setNeighbours(List<Node> neighbours) {
    this.neighbours = neighbours;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Node other = (Node) obj;
    return Objects.equals(name, other.name);
  }
}
