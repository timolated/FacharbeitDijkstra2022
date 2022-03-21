import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Dijkstra
{
    List<Edge> edges = new ArrayList<Edge>();
    static List<Node> nodes = new ArrayList<Node>();
        
    static HashMap<Node, Node> previous; // Vorgänger, um später den Weg nachzuvollziehen; I.
    static List<Edge> markedEdges; // I. und II.
    
    static List<Node> adjacentNodes; // B
    static List<Node> visitedNodes; // A
    
    static Node currentNode;
    static HashMap<Node, Integer> dist;
    
    static Visualisation visualisation;

    public Dijkstra(Visualisation vis)
    {
        visualisation = vis;
        
        Data data = new Data();
        edges = Arrays.asList(data.getEdges());
        nodes = Arrays.asList(data.getNodes());
        
        initVariableProperties();
        initDist();
        initGraphVisualisation();
    }
    
    public Dijkstra()
    {
        Data data = new Data();
        edges = Arrays.asList(data.getEdges());
        nodes = Arrays.asList(data.getNodes());
        visualisation = new Visualisation();
        
        initVariableProperties();
        initDist();
        visualisation.displayIndependent();
        initGraphVisualisation();
    }
    
    private void initVariableProperties()
    {
        previous = new HashMap<Node, Node>();
        markedEdges = new ArrayList<Edge>();
        adjacentNodes = new ArrayList<Node>();
        visitedNodes = new ArrayList<Node>();
        currentNode = null;
        dist = new HashMap<Node, Integer>();
    }
    
    private void initDist()
    {
        for(Node node: nodes)
        {
            dist.put(node, Integer.MAX_VALUE);
        }
    }
    
    private void initGraphVisualisation()
    {
        for(Node node: nodes)
        {
            visualisation.addNode(node);
        }
        for(Edge edge: edges)
        {
            visualisation.addEdge(edge);
        }
    }
    
    public void findeDenKürzestenWeg(String start, String end)
    {
        Node startNode = null;
        Node endNode = null;
        for(Node node: nodes)
        {
            if(node.getLabel().equals(start))
            {
                startNode = node;
            }
            if(node.getLabel().equals(end))
            {
                endNode = node;
            }
        }
        if(startNode == null || endNode == null)
        {
            System.out.println("Mindestens einer der Knoten existiert nicht:");
            System.out.println("\tEs wurden " + nodes.size() + " Knoten durchsucht.");
            if(startNode == null) System.out.println("\tDer Startknoten " + start + " existiert nicht.");
            if(endNode == null) System.out.println("\tDer Endknoten " + end + " existiert nicht.");
            return;
        }
        executeAlgorithm(startNode, endNode);
    }

    private void executeAlgorithm(Node start, Node end)
    {
        adjacentNodes.add(start);
        dist.put(start, 0);
        System.out.println("Kürzester Weg zu " + start.getLabel() + ": \t0");
        while (adjacentNodes.size() > 0 && !visitedNodes.contains(end))
        {
            delay(100); // visualisation
            currentNode = lowestDist(adjacentNodes); // Knoten aus B mit geringster Distanz
            visitedNodes.add(currentNode); // currentNode -> A
            adjacentNodes.remove(currentNode); // currentNode -/> B
            visualisation.setNodeClass(currentNode, "A"); // visualisation
            if(dist.get(currentNode) > 0)
            {
                visualisation.setEdgeClass(getPreviousEdge(currentNode), "i"); // visualisation
            }
            //TODO? neighbour -> node umbenennen
            for(Node neighbour: getNeighbours(currentNode)) // für alle benachbarten Knoten
            {
                delay(50); // visualisation
                Edge edge = getEdge(currentNode, neighbour);
                int distance = dist.get(currentNode) + edge.getWeight(); // Distanz vom Startknoten zum Nachbarknoten berechnen
                if(!visitedNodes.contains(neighbour) && !adjacentNodes.contains(neighbour)) // Nachbarknoten weder A noch B
                {
                    adjacentNodes.add(neighbour); // Nachbarknoten -> B
                    visualisation.setNodeClass(neighbour, "B"); // visualisation
                    markedEdges.add(edge); // Betrachtete Kante -> II.
                    visualisation.setEdgeClass(edge, "ii"); // visualisation
                    dist.put(neighbour, distance); // Distanz speichern
                    System.out.println("Kürzester Weg zu " + neighbour.getLabel() + ": \t" + distance);
                    previous.put(neighbour, currentNode); // Hinführenden Knoten speichern
                }
                else if(adjacentNodes.contains(neighbour)) // Nachbarknoten bereits B?
                {
                    if(dist.get(neighbour) > distance) // Ist dieser Weg kürzer?
                    {
                        markedEdges.add(edge); // Betrachtete Kante -> II.
                        visualisation.setEdgeClass(edge, "ii"); // visualisation
                        markedEdges.remove(getPreviousEdge(neighbour)); // Vorherige Kante -/> II.; (-> III.)
                        visualisation.setEdgeClass(getPreviousEdge(neighbour), "iii"); // visualisation
                        dist.put(neighbour, distance); // Distanz überschreiben
                        System.out.println("Kürzester Weg zu " + neighbour.getLabel() + ": \t" + distance);
                        previous.put(neighbour, currentNode); // Hinführenden Knoten speichern
                    }
                    else // der vorherige Weg ist kürzer
                    {
                        markedEdges.remove(edge); // Betrachtete Kante -> III.
                        visualisation.setEdgeClass(edge, "iii"); // visualisation
                    }
                }
                else // Nachbarknoten ist A
                {
                    markedEdges.remove(edge); // Betrachtete Kante -> III.
                    visualisation.setEdgeClass(edge, "iii"); // visualisation
                }
            }
        }
        delay(100); // visualisation
        // previous vom Zielknoten aus reversen, dafür ist ein Stack geeignet
        Stack<Node> route = new Stack<Node>();
        Node previousNode = previous.get(end);
        makePath(previousNode, end); // visualisation
        visualisation.setNodeClass(end, "path"); // visualisation
        while(previousNode != null) {
            delay(200); // visualisation
            route.add(previousNode);
            visualisation.setNodeClass(previousNode, "path"); // visualisation
            Node endOfEdge = previousNode;
            Node startOfEdge = previous.get(previousNode);
            makePath(startOfEdge, endOfEdge); // visualisation
            previousNode = startOfEdge;
        }
        //  visualisation.setNodeClass(start, "path"); // visualisation
        
        // Konsolenausgabe
        System.out.print("\nDie optimale Route: ");
        while(!route.isEmpty())
        {
            System.out.print(route.pop().getLabel() + " -> ");
        }
        System.out.print(end.getLabel());
    }
    
    private Node lowestDist(List<Node> nodeList)
    {
        Node[] nodes = nodeList.toArray(new Node[nodeList.size()]);
        Node smallest = nodes[0];
        for(Node node: nodes)
        {
            // todo: wenn mind. eins null ist
            if(dist.get(node) < dist.get(smallest))
            {
                smallest = node;
            }
        }
        return smallest;
    }
    
    private Node[] getNeighbours(Node node)
    {
        List<Node> neighbours = new ArrayList<Node>();
        for(Edge edge: edges)
        {
            if(edge.getStart() == node)
            {
                neighbours.add(edge.getEnd());
            }
        }
        return neighbours.toArray(new Node[neighbours.size()]);
    }
    
    private Edge getEdge(Node start, Node end)
    {
        for(Edge edge: edges)
        {
            if(edge.getStart() == start && edge.getEnd() == end)
            {
                return edge;
            }
        }
        // Dieser Fall kann/darf nicht eintreten
        System.out.println("Es konnte keine Kante zwischen " + start.getLabel() + " und " + end.getLabel() + " gefunden werden!");
        return new Edge(start, end, Integer.MAX_VALUE);
    }
    
    private Edge getPreviousEdge(Node end)
    {
        for(Edge edge: markedEdges)
        {
            if(edge.getEnd() == end)
            {
                return edge;
            }
        }
        // Dieser Fall kann/darf nicht eintreten
        System.out.println("Es konnte keine vorherige Kante zu " + end.getLabel() + " gefunden werden!");
        return new Edge(new Node("temp"), end, Integer.MAX_VALUE);
    }
    
    private void makePath(Node start, Node end)
    {
        if(start != null)
        {
            visualisation.setEdgeClass(getEdge(start, end), "path"); // visualisation
        }
    }
    
    private void delay(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void reset()
    {
        for(Edge edge: edges)
        {
            visualisation.setEdgeClass(edge, "");
        }
        for(Node node: nodes)
        {
            visualisation.setNodeClass(node, "");
        }
        initVariableProperties();
    }
}
