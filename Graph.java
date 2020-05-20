public interface Graph {
    void addNode(String name);
    void addEdge(String origin, String destiny, int weight);
    void removeEdge(String origin, String destiny);
    boolean containsNode(String name);
}
