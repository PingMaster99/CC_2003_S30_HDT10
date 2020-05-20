import static org.junit.Assert.*;
/**
 * <h1>FloydAlgorithmTest</h1>
 * Junit tests of FloydAlgorithm
 * <p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-05-20
 **/
public class FloydAlgorithmTest {
    WeightedGraph graph = new WeightedGraph("guategrafo.txt");
    FloydAlgorithm operations = new FloydAlgorithm();
    @org.junit.Test
    public void shortestPath() {

        assertEquals(22,operations.shortestPath(graph,"Antigua","Escuintla"));
    }

    @org.junit.Test
    public void getCenter() {
        WeightedGraph graph = new WeightedGraph("testGraph.txt");
        assertEquals("centercity",operations.getCenter(graph));
    }

    @org.junit.Test
    public void getRoute() {
        operations.shortestPath(graph,"Antigua","SantaLucia");
        assertEquals("La ruta es: antigua-escuintla-santalucia", operations.getRoute("Antigua","SantaLucia"));
    }
}