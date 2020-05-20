/**
 * <h1>Graph</h1>
 * Interface used to get weighted
 * digraph operations.
 * <p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-05-20
 **/
public interface Graph {
    // Adds a node
    void addNode(String name);

    // Gets a node
    int getNode(String name);

    // Checks if the graph contains a node
    boolean containsNode(String name);

    // Adds/edits an edge
    void addEdge(String origin, String destiny, int weight);

    // Removes an edge
    void removeEdge(String origin, String destiny);

}
