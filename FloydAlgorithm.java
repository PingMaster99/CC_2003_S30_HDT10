import java.util.ArrayList;
import java.util.LinkedHashMap;

public class FloydAlgorithm {
    private ArrayList<String> route = new ArrayList<>();
    public int shortestPath(WeightedGraph graph, String origin, String destination) {

        Integer[][] shortestMatrix = shortestPathMatrix(graph);
        if(shortestMatrix[graph.getNode(origin)][graph.getNode(destination)] != null) {
            return shortestMatrix[graph.getNode(origin)][graph.getNode(destination)];
        } else {
            return -99999999;
        }
    }

    public String getCenter(WeightedGraph graph) {
        Integer[][] shortestPathMatrix = shortestPathMatrix(graph);
        int graphCenter = 0;
        int columnSum = 99999999;
        LinkedHashMap<Integer, String> integerMap = graph.getIntegerMap();
        for(int i = 0; i < shortestPathMatrix.length; i++) {
            int currentSum = 0;
            for(int j = 0; j < shortestPathMatrix.length; j++){
                currentSum += shortestPathMatrix[j][i];
            }

            if(columnSum > currentSum) {
                graphCenter = i;
            }
        }
        route.clear();
        return integerMap.get(graphCenter);
    }

    private Integer[][] shortestPathMatrix(WeightedGraph graph) {
        LinkedHashMap<Integer, String> integerToCity = graph.getIntegerMap();

        Integer[][] originalMatrix= graph.getGraphMatrix();
        Integer[][] adjacencyMatrix = new Integer[originalMatrix.length][originalMatrix.length];
        for(int i = 0; i < originalMatrix.length; i ++) {
            for(int j = 0; j < originalMatrix.length; j ++) {
                adjacencyMatrix[i][j] = originalMatrix[i][j];
            }
        }
        for(int k = 0; k < adjacencyMatrix.length; k++) {
            for(int i = 0; i < adjacencyMatrix.length; i++) {
                for(int j = 0; j < adjacencyMatrix.length; j++) {
                        if(adjacencyMatrix[i][j] > adjacencyMatrix[i][k] + adjacencyMatrix[k][j]) {
                            adjacencyMatrix[i][j] = adjacencyMatrix[i][k] + adjacencyMatrix[k][j];
                            if(!route.contains(integerToCity.get(k))) {
                                route.add(integerToCity.get(k));
                            }
                        }
                }
            }
        }
        return adjacencyMatrix;
    }

    public String getRoute(String origin, String destination) {
        StringBuilder stringRoute = new StringBuilder();
        stringRoute.append("La ruta es: ").append(origin + "-");
        for(String city : route) {
            stringRoute.append(city + "-");
        }

        if(!destination.toLowerCase().equals(route.get(route.size()-1).toLowerCase())) {
            stringRoute.append(destination);
        } else {
            stringRoute.deleteCharAt(stringRoute.length() -1);
        }

        route.clear();
        return stringRoute.toString();
    }
}
