import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.spriteManager.SpriteManager;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.swing.util.Display;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.swing.SwingGraphRenderer;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.View;

public class Visualisation {
    private static String styleSheet ="node {"
            + "stroke-mode: plain;"
            + "stroke-color: #343a40;"
            + "text-background-mode: plain;"
            + "text-padding: 2px;"
            + "size: 20px, 20px;"
            + "fill-color: #6d757d;"
            + "}"
            + "node.A {"
            + "fill-color: #3ea54d;"
            + "}"
            + "node.B {"
            + "fill-color: #fcc236;"
            + "}"
            + "node.path {"
            + "fill-color: #d63e49;"
            + "}"
            + "edge {"
            + "size: 2px;"
            + "text-background-mode: plain;"
            + "text-padding: 5px;"
            + "arrow-size: 4px, 4px;"
            + "fill-color: #6d757d;"
            + "}"
            + "edge.i {"
            + "fill-color: #3ea54d;"
            + "}"
            + "edge.ii {"
            + "fill-color: #fcc236;"
            + "}"
            + "edge.iii {"
            + "fill-color: #f0f1f2;"
            + "}"
            + "edge.path {"
            + "fill-color: #d63e49;"
            + "}";
    private static Graph graph = new MultiGraph("Mariengymnasium");
    private static SwingViewer viewer;
    private static ViewPanel viewpanel;
    private static View view;
    public Visualisation()
    {
        System.setProperty("org.graphstream.ui", "swing");
        graph.setAttribute("ui.stylesheet", styleSheet);
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
        viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();
        //viewpanel = (ViewPanel)viewer.addDefaultView(false);
        view = viewer.addDefaultView(false);
    }
    
    
    public static void displayIndependent()
    {
        graph.display();
    }
    
    public void addNode(Node node)
{
        org.graphstream.graph.Node graphNode = graph.addNode(node.getLabel());
        graphNode.setAttribute("ui.label", node.getLabel());
        //graphNode.setAttribute("layout.weight", 10);
        
        if(node.getLayout().length == 2)
        {
            graphNode.setAttribute("xyz", node.getLayout()[0], node.getLayout()[1], 0);
            graphNode.setAttribute("layout.frozen");
        }
    }
    
    public void setNodeClass(Node node, String classname)
    {
        graph.getNode(node.getLabel()).setAttribute("ui.class", classname);
         //updated
    }
    
    public void addEdge(Edge edge)
    {
        String name = edge.getStart().getLabel()+edge.getEnd().getLabel();
        org.graphstream.graph.Edge graphEdge = graph.addEdge(name, edge.getStart().getLabel(),
        edge.getEnd().getLabel(), true);
        
        graphEdge.setAttribute("ui.label", edge.getWeight());
    }
    
    public void setEdgeClass(Edge edge, String classname)
    {
        String name = edge.getStart().getLabel()+edge.getEnd().getLabel();
        graph.getEdge(name).setAttribute("ui.class", classname);
    }
    
    public View getView()
    {
        return view;
    }
}