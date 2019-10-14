package main;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import negocio.CombinacaoLinear;


public class RNAAdaline extends javax.swing.JFrame {

    static double [] weights = new double[600];
    static double [] backup = new double[600];
    
    public static void main(String[] args) {
        Graph g = new Graph();
        Graph gf;
        
        CombinacaoLinear af = new CombinacaoLinear();
        
        double[][] x = {{3.09}, {0.6}, {2.233}, {0.604}};
        double[][] y = {{3.1246}, {0.6}, {2.233}, {0.604}};
        af.iteration();
        weights = af.AFTest(af.w);
        
        //setWeights(weights);
        JFrame app = new JFrame();
        app.getContentPane().setBackground(new Color (255,255,255));
        app.setTitle("Artifitial Neural Networks");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(g);
        app.setSize(600, 580);
        app.setVisible(true);
    }
    
    public double[] getWeights() { return weights; }
    
}
