import java.util.List;
import java.util.ArrayList;

public class Data
{
    private List<Node> n = new ArrayList<Node>();
    private List<Edge> e = new ArrayList<Edge>();
    
    public Data()
    {
        addNode("R. 1", new int[]{85,100});
        addNode("R. 6");
        addNode("R. 10");
        addNode("R. 12");
        addNode("R. 13");
        addNode("R. 14");
        addNode("R. 20");
        addNode("R. 22");
        addNode("R. 24");
        addNode("R. 25");
        addNode("R. 26");
        addNode("R. 27");
        addNode("R. 28", new int[]{120,115});
        addNode("R. 29", new int[]{120,105});
        addNode("R. 30");
        addNode("R. 31");
        addNode("R. 32");
        addNode("R. 33", new int[]{50,120});
        addNode("R. 34");
        addNode("R. 35");
        addNode("R. 36");
        addNode("R. 37");
        addNode("R. 38", new int[]{130,130});
        addNode("R. 39", new int[]{130,120});
        addNode("R. 43");
        addNode("R. 45", new int[]{80,50});
        addNode("R. 50", new int[]{100,50});
        addNode("R. 51");
        addNode("R. 52");
        addNode("R. 53");
        addNode("R. 60", new int[]{120,50});
        addNode("R. 61");
        addNode("R. 62");
        addNode("R. 63");
        addNode("R. 64");
        addNode("R. 70");
        addNode("R. 73");
        addNode("R. 75");
        addNode("R. 76", new int[]{30,20});
        addNode("R. 80");
        addNode("R. 81");
        addNode("R. 85", new int[]{30,10});
        addNode("R. 91");
        addNode("R. 92");
        addNode("R. 93");
        addNode("R. 94");
        addNode("R. 101");
        addNode("R. 102");
        addNode("R. 103");
        addNode("R. 104");
        addNode("E1", new int[]{60,90}); // Haupteingang
        addNode("E2", new int[]{60,105});
        addNode("E3", new int[]{60,120});
        addNode("F1", new int[]{120,60});
        addNode("F2", new int[]{130,60});
        addNode("F3", new int[]{140,60});
        addNode("GTH", new int[]{50,30});
        addNode("GTH (Jungs)", new int[]{0,30});
        addNode("G1", new int[]{30,90});
        addNode("G2", new int[]{20,90});
        addNode("G3", new int[]{10,90});
        addNode("H1", new int[]{120,90});
        addNode("H2", new int[]{130,105});
        addNode("H3", new int[]{140,120});
        addNode("Kiosk", new int[]{90,60});
        addNode("KTH", new int[]{40,60});
        addNode("Ku");
        addNode("Lehrerzimmer", new int[]{75,65});
        addNode("Mu", new int[]{40,105});
        addNode("M1", new int[]{20,20});
        addNode("M2", new int[]{10,10});
        addNode("M3", new int[]{0,0}); // Dach
        addNode("N3", new int[]{100,30});
        addNode("O1", new int[]{60,30});
        addNode("O2", new int[]{70,20});
        addNode("O3", new int[]{80,10});
        addNode("Parkplatz", new int[]{0,100});
        addNode("Pausenhalle", new int[]{80,70});
        addNode("Sekreteriat", new int[]{85,90});
        addNode("SLZ", new int[]{50,80});
        addNode("WC90", new int[]{20,40});
        addNode("WC100", new int[]{10,40});
        
        addEdge("R. 1", "Sekreteriat", 0);
        //addEdge("R. 1", "R. 14", ?);

        addEdge("R. 6", "R. 13", 10);
        addEdge("R. 6", "H1", 7);

        addEdge("R. 10", "R. 12", 11);
        addEdge("R. 10", "F1", 11);

        addEdge("R. 12", "R. 10", 11);
        addEdge("R. 12", "H1", 5);

        addEdge("R. 13", "R. 6", 10);
        addEdge("R. 13", "Sekreteriat", 5);

        addEdge("R. 14", "E1", 10);
        addEdge("R. 14", "Sekreteriat", 1);

        addEdge("R. 20", "R. 22", 11);
        addEdge("R. 20", "F2", 8);

        addEdge("R. 22", "R. 20", 11);
        addEdge("R. 22", "H2", 11);

        addEdge("R. 24", "R. 26", 5);
        addEdge("R. 24", "R. 27", 2);

        addEdge("R. 25", "R. 26", 1);
        addEdge("R. 25", "E2", 3);

        addEdge("R. 26", "R. 24", 5);
        addEdge("R. 26", "R. 25", 3);
        
        addEdge("R. 27", "R. 24", 2);
        addEdge("R. 27", "R. 29", 3);

        addEdge("R. 28", "R. 29", 0);

        addEdge("R. 29", "R. 27", 3);
        addEdge("R. 29", "R. 28", 0);
        addEdge("R. 29", "H2", 7);

        addEdge("R. 30", "R. 31", 7);
        addEdge("R. 30", "F3", 10);

        addEdge("R. 31", "R. 30", 7);
        addEdge("R. 31", "R. 32", 6);

        addEdge("R. 32", "R. 31", 6);
        addEdge("R. 32", "H3", 6);

        addEdge("R. 33", "E3", 0);

        addEdge("R. 34", "R. 36", 4);
        addEdge("R. 34", "R. 37", 3);

        addEdge("R. 35", "R. 36", 4);
        addEdge("R. 35", "E3", 2); // ?

        addEdge("R. 36", "R. 34", 4);
        addEdge("R. 36", "R. 35", 4);

        addEdge("R. 37", "R. 34", 3);
        addEdge("R. 37", "R. 39", 4);

        addEdge("R. 38", "R. 39", 0);

        addEdge("R. 39", "R. 37", 4);
        addEdge("R. 39", "R. 38", 0);
        addEdge("R. 39", "H3", 7);

        addEdge("R. 43", "R. 45", 11);
        addEdge("R. 43", "O1", 11);

        addEdge("R. 45", "Kiosk", 13);
        //addEdge("R. 45", "Lehrerzimmer", -);
        addEdge("R. 45", "R. 43", 11);

        addEdge("R. 50", "Kiosk", 22);
        addEdge("R. 50", "R. 51", 11);
        addEdge("R. 50", "N3", 24);

        addEdge("R. 51", "R. 50", 11);
        addEdge("R. 51", "R. 52", 8);

        addEdge("R. 52", "R. 51", 8);
        addEdge("R. 52", "R. 53", 6);

        addEdge("R. 53", "R. 52", 6);
        addEdge("R. 53", "O2", 9);

        addEdge("R. 60", "R. 61", 2);

        addEdge("R. 61", "R. 60", 2);
        addEdge("R. 61", "R. 62", 4);

        addEdge("R. 62", "R. 61", 4);
        addEdge("R. 62", "N3", 9);

        addEdge("R. 63", "R. 64", 5);
        addEdge("R. 63", "N3", 6);

        addEdge("R. 64", "R. 63", 5);
        addEdge("R. 64", "O3", 8);

        addEdge("R. 70", "R. 73", 18);
        addEdge("R. 70", "O2", 10);

        addEdge("R. 73", "R. 70", 18);
        addEdge("R. 73", "R. 75", 13);

        addEdge("R. 75", "R. 73", 13);
        addEdge("R. 75", "R. 76", 4);

        addEdge("R. 76", "R. 75", 4);
        addEdge("R. 76", "M2", 16);
        addEdge("R. 76", "M1", 16);

        addEdge("R. 80", "R. 81", 6);
        addEdge("R. 80", "O3", 12);

        addEdge("R. 81", "R. 80", 6);
        addEdge("R. 81", "R. 85", 26);

        addEdge("R. 85", "R. 81", 26);
        addEdge("R. 85", "M2", 18);
        addEdge("R. 85", "M3", 18);
        
        addEdge("R. 91", "G2", 11);
        addEdge("R. 91", "R. 92", 7);

        addEdge("R. 92", "R. 91", 7);
        addEdge("R. 92", "R. 93", 9);

        addEdge("R. 93", "R. 92", 9);
        addEdge("R. 93", "R. 94", 9);

        addEdge("R. 94", "R. 93", 9);
        addEdge("R. 94", "WC90", 13);

        addEdge("R. 101", "G3", 12);
        addEdge("R. 101", "R. 102", 10);

        addEdge("R. 102", "R. 101", 10);
        addEdge("R. 102", "R. 103", 9);

        addEdge("R. 103", "R. 102", 9);
        addEdge("R. 103", "R. 104", 10);

        addEdge("R. 104", "R. 103", 10);
        addEdge("R. 104", "WC100", 10);

        addEdge("E1", "R. 14", 10);
        addEdge("E1", "Pausenhalle", 20);
        addEdge("E1", "SLZ", 14);
        addEdge("E1", "G1", 37);
        addEdge("E1", "E2", 25);
        addEdge("E1", "Parkplatz", 35);

        addEdge("E2", "R. 25", 3);
        addEdge("E2", "Ku", 14);
        addEdge("E2", "E1", 25);
        addEdge("E2", "E3", 20);

        addEdge("E3", "R. 35", 4);
        addEdge("E3", "R. 33", 0);
        addEdge("E3", "E2", 20);

        addEdge("F1", "Pausenhalle", 25);
        //addEdge("F1", "(Toiletten außen)", 0);

        addEdge("F2", "F1", 23);

        addEdge("F3", "F2", 23);
        
        addEdge("GTH", "Kiosk", 83);
        addEdge("GTH", "KTH", 35);
        addEdge("GTH", "GTH (Jungs)", 28);
        addEdge("GTH", "O1", 25);

        addEdge("GTH (Jungs)", "GTH", 28);
        addEdge("GTH (Jungs)", "Parkplatz", 68);

        addEdge("G1", "E1", 37);
        addEdge("G1", "G2", 27);
        addEdge("G1", "KTH", 19);
        addEdge("G1", "Parkplatz", 15);

        addEdge("G2", "R. 91", 11);
        addEdge("G2", "G1", 27);
        addEdge("G2", "G3", 18);

        addEdge("G3", "R. 101", 12);
        addEdge("G3", "G2", 18);

        addEdge("H1", "R. 6", 7);
        addEdge("H1", "R. 12", 5);
        addEdge("H1", "H2", 22); // ?

        addEdge("H2", "R. 22", 11);
        addEdge("H2", "R. 29", 7);
        addEdge("H2", "H1", 22); // ?
        addEdge("H2", "H3", 23);

        addEdge("H3", "R. 32", 6);
        addEdge("H3", "R. 39", 7);
        addEdge("H3", "H2", 23);

        addEdge("Kiosk", "R. 45", 13);
        addEdge("Kiosk", "R. 50", 22);
        addEdge("Kiosk", "GTH", 83);
        //addEdge("Kiosk", "F1", ?);
        addEdge("Kiosk", "Pausenhalle", 19);

        addEdge("KTH", "GTH", 35);
        addEdge("KTH", "G1", 19);
        addEdge("KTH", "O1", 35);

        addEdge("Ku", "E2", 14);
        addEdge("Ku", "Mu", 5);

        addEdge("Lehrerzimmer", "R. 45", 0);
        addEdge("Lehrerzimmer", "KTH", 33);
        addEdge("Lehrerzimmer", "Pausenhalle", 0);
        addEdge("Lehrerzimmer", "O1", 22);
        
        addEdge("Mu", "Ku", 5);
        addEdge("Mu", "G1", 40);

        addEdge("M1", "R. 76", 16);
        addEdge("M1", "WC90", 14);
        addEdge("M1", "M2", 19);
        addEdge("M1", "GTH (Jungs)", 23);
        //addEdge("M1", "Parkplatz", ?);

        addEdge("M2", "R. 76", 16);
        addEdge("M2", "R. 85", 18);
        addEdge("M2", "WC90", 15);
        addEdge("M2", "WC100", 20);
        addEdge("M2", "M1", 19);
        addEdge("M2", "M3", 18);

        addEdge("M3", "R. 85", 18);
        addEdge("M3", "M2", 18);
        
        addEdge("N3", "R. 50", 24);
        addEdge("N3", "R. 62", 9);
        addEdge("N3", "R. 63", 6);

        addEdge("O1", "R. 43", 11);
        addEdge("O1", "O2", 26);
        //addEdge("O1", "Lehrerzimmer", -);
        addEdge("O1", "KTH", 35);
        addEdge("O1", "GTH", 25);

        addEdge("O2", "O1", 26);
        addEdge("O2", "O3", 24);
        addEdge("O2", "R. 53", 9);
        addEdge("O2", "R. 70", 10);

        addEdge("O3", "O2", 24);
        addEdge("O3", "R. 64", 8);
        addEdge("O3", "R. 80", 12);

        addEdge("Pausenhalle", "F1", 25);
        addEdge("Pausenhalle", "E1", 20);
        addEdge("Pausenhalle", "Kiosk", 19);
        //addEdge("Pausenhalle", "Lehrerzimmer", -);

        addEdge("Parkplatz", "E1", 35);
        addEdge("Parkplatz", "G1", 15);
        addEdge("Parkplatz", "GTH (Jungs)", 68);

        addEdge("Sekreteriat", "R. 1", 0);
        addEdge("Sekreteriat", "R. 14", 1);
        addEdge("Sekreteriat", "R. 13", 5);

        addEdge("SLZ", "E1", 14);

        addEdge("WC90", "R. 94", 13);
        addEdge("WC90", "M1", 14);
        addEdge("WC90", "M2", 15);

        addEdge("WC100", "R. 104", 10);
        addEdge("WC100", "M2", 20);
    }
    
    private void addNode(String label, int[] layout)
    {
        n.add(new Node(label, layout));
    }
    
    private void addNode(String label)
    {
        n.add(new Node(label));
    }
    
    private void addEdge(String start, String end, int weight)
    {
        Node startNode = null;
        Node endNode = null;
        for(Node node: n)
        {
            if(node.getLabel() == start)
            {
                startNode = node;
            }
            if(node.getLabel() == end)
            {
                endNode = node;
            }
        }
        if(startNode == null || endNode == null)
        {
            System.out.println("Eine Kante konnte nicht erstellt werden:"
            + "(" + start + " -> " + end + ").");
            if(startNode == null)
            {
                System.out.println("Der Ausgangspunkt der Kante " + start + " existiert nicht.");
            }
            if(endNode == null)
            {
                System.out.println("Der Zielpunkt der Kante " + end + " existiert nicht.");
            }
            return;
        }
        e.add(new Edge(startNode, endNode, weight));
    }

    public Node[] getNodes()
    {
        return n.toArray(new Node[n.size()]);
    }

    public Edge[] getEdges()
    {
        return e.toArray(new Edge[e.size()]);
    }
}
