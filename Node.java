public class Node
{
    private String label;
    private int[] layout;

    public Node(String label)
    {
        this.label = label;
        this.layout = new int[0];
    }
    public Node(String label, int[] layout)
    {
        this.label = label;
        this.layout = layout;
    }
    
    public String getLabel()
    {
        return this.label;
    }
    
    public int[] getLayout()
    {
        return this.layout;
    }
}
