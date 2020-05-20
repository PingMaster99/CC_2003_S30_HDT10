import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class DirectedGraph {
    private Set<Node> nodes = new HashSet<>();
    private HashMap<String, Node> cities = new HashMap<>();


    DirectedGraph(String fileName) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;
            ArrayList<Node> nodesArray = new ArrayList<>();

            while((line = reader.readLine()) != null) {
                String[] graphElement = line.split(" ");

                String origin = graphElement[0].toLowerCase();
                String destiny = graphElement[1].toLowerCase();

                if(!cities.containsKey(origin)) {
                    cities.put(origin, new Node(origin));
                }

                if(!cities.containsKey(destiny)) {
                    cities.put(destiny, new Node(destiny));
                }

                cities.get(origin).addDestination(cities.get(destiny), Integer.parseInt(graphElement[2]));
            }

            ArrayList<Node> travelCities = new ArrayList<>(cities.values());
            nodes.addAll(travelCities);


        } catch (Exception E) {
            System.err.println("El grafo no se ha podido generar, por favor revise el archivo de origen");
        }
    }


    public Node getCity(String city) {
        return cities.getOrDefault(city.toLowerCase(), null);
    }

    public void addNode(Node nodeA) {
        int setSize = 0;
        if (nodes.size() == 0) {
            nodes.add(nodeA);
        } else {
            for (Node node : nodes) {
                setSize++;
                if (node.getName().equals(nodeA.getName())) {
                    break;
                } else if (setSize == nodes.size()) {
                    nodes.add(nodeA);
                }
            }
        }
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void removeNode(Node node) {
        nodes.remove(node);
    }

    public boolean containsNode(Node node) {
        if(nodes.contains(node)) {
            return true;
        }
        return false;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}