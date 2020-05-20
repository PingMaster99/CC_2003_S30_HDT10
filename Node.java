
import java.util.*;

public class Node {

    private String name;

    private LinkedList<Node> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    private Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node destination, int distance) {
        Set<Node> nodes = adjacentNodes.keySet();
        int elements = 1;

        if (adjacentNodes.size() == 0) {
            adjacentNodes.put(destination, distance);
        }

        for (Node node : nodes) {

            if(destination.getName().equals(node.getName())) {
                break;
            } else if (elements == adjacentNodes.size()) {
                adjacentNodes.put(destination, distance);
            }
            elements ++;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public String getAdjacentString() {
        StringBuilder adjacentString = new StringBuilder("   ");

        if(adjacentNodes.keySet().size() == 0) {
            return "    Sin destinos directos disponibles";
        }
        Set<Node> nodes = adjacentNodes.keySet();
        for(Node node : nodes) {
            adjacentString.append(" ").append(node.getName()).append(" [").append(adjacentNodes.get(node)).append("] ");
        }

        return adjacentString.toString();
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

}