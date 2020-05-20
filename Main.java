import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        DirectedGraph grafoGuate = new DirectedGraph("guategrafo.txt");
        Scanner input = new Scanner(System.in);
        String userSelection = "";
        WeightedGraph guategrafo = new WeightedGraph("guategrafo.txt");
        guategrafo.print();
        System.out.println("******************************************\n           Matriz de adyacencia" +
                "\n******************************************\n ||Ciudad de origen|| destino [distancia]\n");

        Set<Node> nodesWithAdjacency = grafoGuate.getNodes();

        for (Node node : nodesWithAdjacency) {
            System.out.println("||" +node.getName() + "||");
            System.out.println(node.getAdjacentString());
        }
        System.out.println("\n*****************************************************************************************\n" +
                "Bienvenido al navegador de ciudades, utilice la matriz de adyacencia impresa en la parte\n" +
                "           de arriba para identificar las ciudades a las que puede viajar\n" +
                "*****************************************************************************************");

        while(!userSelection.toLowerCase().equals("x")) {

                System.out.print("Introduzca la ciudad de origen:\n>> ");
                String origin = input.nextLine();

                System.out.println("Introduzca la ciudad de destino:\n>> ");
                String destiny = input.nextLine();

                Node originCity = grafoGuate.getCity(origin.toLowerCase());
                Node destinationCity = grafoGuate.getCity(destiny.toLowerCase());

                if (originCity == null) {
                    System.err.println("La ciudad de origen no es correcta");
                    continue;

                } else if (destinationCity == null) {
                    System.err.println("La ciudad de destino no es correcta");
                    continue;
                }

            System.out.print("Presione enter para continuar o introduzca 'x' para salir\n>> ");
            userSelection = input.nextLine();
        }
    }
}
