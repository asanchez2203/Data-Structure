package Tarea4;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel {

    private JFrame frame;
    private JPanel panel;

    void initializeComponents() {
        frame = new JFrame();
        panel = new JPanel();
        frame.setLayout(null);
        frame.setSize(1000, 1000);
        panel.setSize(1000, 1000);
        panel.setBackground(Color.white);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Panel p = new Panel();
        p.initializeComponents();
        Drawer dibujante = new Drawer();
        dibujante.inicia(p.getPanel().getGraphics());
        dibujante.gira(3.1416);
        dibujante.traza(20.0);
        System.out.println("algo");
        p.panel.paint(dibujante.g);
        //p.getFrame().setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }

}
