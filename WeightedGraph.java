import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Set;

public class WeightedGraph implements Graph{

    LinkedHashMap<String, Integer> citiesMap = new LinkedHashMap<>();
    private Integer graphMatrix[][];
    private int numberOfCities = -1;

    WeightedGraph(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";

            while((line = reader.readLine()) != null) {

                String[] graphElement = line.split(" ");
                String origin = graphElement[0].toLowerCase();
                String destination = graphElement[1].toLowerCase();

                if(!citiesMap.containsKey(origin)) {
                    addNode(origin);
                }
                if (!citiesMap.containsKey(destination)) {
                    addNode(destination);
                }
            }
            graphMatrix = new Integer[numberOfCities + 1][numberOfCities + 1];

            BufferedReader reader2 = new BufferedReader(new FileReader(fileName));
            while((line = reader2.readLine()) != null) {

                String[] graphElement = line.split(" ");
                addEdge(graphElement[0].toLowerCase(), graphElement[1].toLowerCase(), Integer.parseInt(graphElement[2]));
            }

            for(int i = 0; i < citiesMap.size(); i ++) {
                graphMatrix[i][i] = 0;
            }

        } catch (Exception E) {
            System.err.println("El grafo no se ha podido generar, por favor revise el archivo de origen");
        }
    }

    public void addEdge(String origin, String destiny, int weight) {
        if(citiesMap.containsKey(origin) && citiesMap.containsKey(destiny)) {
            graphMatrix[citiesMap.get(origin.toLowerCase())][citiesMap.get(destiny.toLowerCase())] = weight;
        }
    }

    public void print() {

        Set<String> cities = citiesMap.keySet();
        System.out.println("[Numero] representa la posicion de la ciudad en fila y columna de la matriz de adyacencia");

        for(String city : cities) {
            System.out.print(city + "[" + citiesMap.get(city)+ "] ");
        }

        System.out.println("\n");

        for(int i = 0; i < citiesMap.size(); i++) {
            for(int j = 0; j < citiesMap.size(); j++) {
                if(graphMatrix[i][j] == null) {
                    System.out.print("INF ");
                } else {
                    System.out.print(graphMatrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public void removeEdge(String origin, String destiny) {
        if(graphMatrix[citiesMap.get(origin.toLowerCase())][citiesMap.get(destiny.toLowerCase())] != null) {
            graphMatrix[citiesMap.get(origin.toLowerCase())][citiesMap.get(destiny.toLowerCase())] = null;
        }
    }


    public void addNode(String cityName) {
        numberOfCities++;
        citiesMap.put(cityName.toLowerCase(), numberOfCities);
    }

    public boolean containsNode(String name) {
        if(citiesMap.containsKey(name.toLowerCase())) {
            return true;
        }
        return false;
    }

}
