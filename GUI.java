import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI
{
    private JFrame frame;
    private JPanel sidebar;
    private JButton startButton, resetButton;
    private JTextField startField, endField;
    private JLabel startFieldLabel, endFieldLabel;
    
    private Visualisation visualisation = new Visualisation();
    private Dijkstra dijkstra = new Dijkstra(visualisation);

    
    public GUI()
    {
        initialise();
    }
    
    private void initaliseFrame()
    {
        frame = new JFrame("panel");
    }
    
    private void initialise()
    {
        initaliseFrame();
        
        sidebar = new JPanel();
        
        startButton = new JButton("Wegfindung starten");
        resetButton = new JButton("Graphen zurücksetzen");
        
        startField = new JTextField(10);
        startFieldLabel = new JLabel("Startknoten: ");
        sidebar.add(startFieldLabel);
        startFieldLabel.setLabelFor(startField);
        sidebar.add(startField);
        
        endField = new JTextField(10);
        endFieldLabel = new JLabel("Zielknoten: ");
        sidebar.add(endFieldLabel);
        endFieldLabel.setLabelFor(endField);
        sidebar.add(endField);
        
        sidebar.add(startButton);
        sidebar.add(resetButton);
        
        startButton.addActionListener(new StartButtonEventListener(this));        
        resetButton.addActionListener(new ResetButtonEventListener(this));
        
        frame.add(sidebar, BorderLayout.NORTH);
        initialiseGraph();
        
        frame.setTitle("Dijkstra - Mariengymnasium Bocholt");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        //frame.pack();
        frame.setVisible(true);
    }
    
    private void initialiseGraph()
    {
        if(visualisation.getView() != null) {
            frame.add((Component)visualisation.getView());
        }
    }
    
    public void startDijkstra()
    {
        SwingWorker worker = new SwingWorker() {
            protected String doInBackground()
            {
                startButton.setEnabled(false);
                dijkstra.findeDenKürzestenWeg(startField.getText(), endField.getText());
                startButton.setEnabled(true);
                return "complete";
            }
        };
        worker.execute();
    }

    public class StartButtonEventListener implements ActionListener
    {
        private GUI gui;
        
        public StartButtonEventListener(GUI gui)
        {
            this.gui = gui;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            gui.startDijkstra();
        }
    }

    public class ResetButtonEventListener implements ActionListener
    {
        private GUI gui;
        
        public ResetButtonEventListener(GUI gui)
        {
            this.gui = gui;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            gui.dijkstra.reset();
        }
    }
}
