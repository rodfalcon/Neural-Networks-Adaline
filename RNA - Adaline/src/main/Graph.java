package main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
 *
 * @author xofth
 */
public class Graph extends JPanel {
    static String mx, mn;
    static double maximo, minimo, passo, a,b,c,d,e,f,g,h,i,j,l;
    double evidence;
    double[]t = new double [300];
    double[]w = new double [300];
    private double[] ff = new double[600];
    private double[] fg = new double[600];
    
    RNAAdaline xxx = new RNAAdaline();

    Graph(double[] shapes)
    {
        ff = shapes;
    }

    Graph() { }
    
    public void paintComponent(Graphics prGraph)
    {
        super.paintComponent(prGraph);
        minimo = 0; maximo =1;
        passo = (maximo - minimo)/10;
        
        a = minimo;
        b = minimo + passo;
        c = minimo + 2*passo;
        d = minimo + 3*passo;
        e = minimo + 4*passo;
        f = minimo + 5*passo;
        g = minimo + 6*passo;
        h = minimo + 7*passo;
        i = minimo + 8*passo;
        j = minimo + 9*passo;
        l = minimo + 10*passo;
        prGraph.setColor(Color.green);
        
     //horizontal lines
     int p = 70;
        do {
            for (int n = 0; n < 320; n = n + 20) 
                prGraph.drawLine(0, p, n, p);
            p = p + 22;
        } while (p <= 340);
     
     //vertical lines
     int q = 0;
        do {
            for (int o = 0; o < 10; o = o + 20) 
                prGraph.drawLine(q, 70, q, 332);
         q = q + 20;   
        } while (q < 320);
        
     prGraph.setColor(Color.RED);
     prGraph.drawString("*SIGN 1", 60, 50);
     
     prGraph.setColor(Color.BLUE);
     prGraph.drawString("*SIGN 2", 130, 50);
     
     prGraph.setColor(Color.BLACK);
     
     int z = 0, horizontalScale = 0;
        for (int r = 0; r <= 300; r = r + 20) {
            prGraph.drawString("" + z, horizontalScale, 350);
            horizontalScale = horizontalScale + 20;
            z = z + 2;
        }
        prGraph.drawString("(*10)", 340, 450);
        
    //vertical scale
    prGraph.drawString("-1.0  ", 320, 330);
    prGraph.drawString("-0.8  ", 320, 305);
    prGraph.drawString("-0.6  ", 320, 280);
    prGraph.drawString("-0.4  ", 320, 255);
    prGraph.drawString("-0.2  ", 320, 230);
    prGraph.drawString("0.0  ", 320, 205);
    prGraph.drawString("0.2  ", 320, 180);
    prGraph.drawString("0.4  ", 320, 155);
    prGraph.drawString("0.6  ", 320, 130);
    prGraph.drawString("0.9  ", 320, 105);
    prGraph.drawString("1.0  ", 320, 80);
        
    ff = xxx.getWeights();
    System.arraycopy(ff, 0, fg, 0, 600);
    
        for (int k = 0; k < 300; k++) { t[k] = ff[k];  }
        
    System.arraycopy(ff, 300, w, 0, 300);
    
    int xx = 0; double xy = 0, ny = 0;
    
        for (int k = 0; k <= 299; k++) {
            xy = +203 + (-250*t[k])*0.1;
            ny = +203 + (-250*w[k])*0.1;
            prGraph.setColor(Color.RED);
            prGraph.drawLine(xx-1, (int)xy-1, xx, (int)xy);
            prGraph.setColor(Color.BLUE);
            prGraph.drawLine(xx-1, (int)ny-1, xx, (int)ny);
            xx++;
        }
    
    }
    
}
