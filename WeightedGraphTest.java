import org.junit.Test;

import static org.junit.Assert.*;
/**
 * <h1>WeightedGraphTest</h1>
 * Junit tests for WeightedGraph
 * <p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-05-20
 **/
public class WeightedGraphTest {

    WeightedGraph graph = new WeightedGraph("testGraph.txt");
    Integer[][] graphMatrix = graph.getGraphMatrix();
    @Test
    public void addEdge() {
        graph.addEdge("centercity","secondcity",9);
        int weight = graphMatrix[2][1];
        assertEquals(weight, 9);
    }

    @Test
    public void removeEdge() {
        graph.removeEdge("mycity","secondcity");
        int weight = graphMatrix[0][1];
        assertEquals(weight, 9999999);
    }

    @Test
    public void containsNode() {
        assertTrue(graph.containsNode("mycity"));
    }
}