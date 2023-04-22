package dijkstra_algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class DijkstraAlghorithm {

  public static void main(String[] args) {

    DijkstraAlghorithm dijkstraAlghorith = new DijkstraAlghorithm();

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
  }

  public Map<Integer, Stack<String>> findShortestPath(Map<String, Map<String, Integer>> graph, String begin, String destiny) {

    if (begin.equals(destiny)) {
      Stack<String> stack = new Stack<>();
      stack.add(begin);
      return Map.of(0, stack);
    }

    Map<String, Integer> weights = constructWeight(graph, begin);
    Map<String, String> parents = constructParents(graph, begin);
    Set<String> verified = new HashSet<>();

    String nodeName = findShortestNeighbourPath(weights, verified);

    while (nodeName != destiny) {

      var innerNodeName = nodeName;
      Map<String, Integer> neighbours = graph.get(nodeName);

      neighbours.entrySet().stream().forEach(entry -> {
        if ((weights.get(entry.getKey())) > (entry.getValue() + weights.get(innerNodeName))) {
          weights.put(entry.getKey(), entry.getValue() + weights.get(innerNodeName));
          parents.put(entry.getKey(), innerNodeName);
        }
      });

      verified.add(nodeName);
      nodeName = findShortestNeighbourPath(weights, verified);
    }

    Stack<String> paths = getPathsFromTo(parents, destiny);

    return Map.of(weights.get(destiny), paths);
  }

  private Map<String, Integer> constructWeight(Map<String, Map<String, Integer>> graph, String begin) {
    HashMap<String, Integer> weights = new HashMap<>(graph.get(begin));
    graph.values().stream().forEach(nodeWithWeight -> nodeWithWeight.keySet().stream().filter(nodeName -> !weights.containsKey(nodeName))
        .forEach(nodeName -> weights.put(nodeName, Integer.MAX_VALUE)));

    return weights;
  }

  private Map<String, String> constructParents(Map<String, Map<String, Integer>> graph, String begin) {
    Map<String, Integer> neighbours = graph.get(begin);
    Map<String, String> parents = new HashMap<>();
    neighbours.keySet().stream().forEach(nodeName -> parents.put(nodeName, begin));

    return parents;
  }

  private String findShortestNeighbourPath(Map<String, Integer> weights, Set<String> verified) {
    return Collections.min(weights.entrySet().stream().filter(weight -> !verified.contains(weight.getKey())).collect(Collectors.toSet()), Map.Entry.comparingByValue())
        .getKey();
  }

  private Stack<String> getPathsFromTo(Map<String, String> parents, String destiny) {
    String parent = parents.get(destiny);
    Stack<String> paths = new Stack<String>();
    paths.add(destiny);

    while (parent != null) {
      paths.add(parent);
      parent = parents.get(parent);
    }

    return paths;

  }
}
