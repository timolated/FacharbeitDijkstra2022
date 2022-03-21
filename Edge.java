public class Edge
{
    private Node start;
    private Node end;
    private int weight;

    public Edge(Node start, Node end, int weight)
    {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    
    public Node getStart()
    {
        return this.start;
    }
    
    public Node getEnd()
    {
        return this.end;
    }
    
    public int getWeight()
    {
        return this.weight;
    }
}
