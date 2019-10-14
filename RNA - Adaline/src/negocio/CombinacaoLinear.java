package negocio;

/**
 *
 * @author xofth
 */
public class CombinacaoLinear {
    double[] f1 = new double[300];
    double[] f2 = new double[300];
    double[] f3 = new double[300];
    double[] t = new double[300];
    double[] f = new double[300];
    
    public double w[][] = {{-2.4013}, {0.393}, {1.902}, {0.429}};
    
    double learningRate = 0.000027;
    
    public void iteration()
    {
        for (int i = 0; i < 300; i++)
        {
            f1[i] = Math.sin(i*Math.PI/180);
            f2[i] = Math.cos(i*Math.PI/180);
            f3[i] = i*Math.PI/180;
            f[i] = -Math.PI + 0.565*f1[i] + 2.657*f2[i] + 0.674*f3[i];     
        }
        int n = 0;
        while (n < 32)
        {
            w = input1(w);
            System.out.println("WEIGHT 0 = \t" + w[0][0]);
            System.out.println("WEIGHT 1 = \t" + w[1][0]);
            System.out.println("WEIGHT 2 = \t" + w[2][0]);
            System.out.println("WEIGHT 3 = \t" + w[3][0]);
            n = n + 1;
            System.out.println("Number of practices" + n + "\n");
        }
    }

    public double[][] input1(double[][] w) {
        System.err.println("INPUT F1");
        for (int i = 0; i < 300; i++) 
        {
            t[i] = w[0][0] + w[1][0]*f1[i] + w[2][0]*f2[i] + w[3][0]*f3[i];
            w[0][0] = w[0][0] + learningRate*Math.pow((f[i] - t[i]), 2.0)*0.5;
            w[1][0] = w[1][0] + learningRate*Math.pow((f[i] - t[i]), 2.0)*0.5*f1[i];
            w[2][0] = w[2][0] + learningRate*Math.pow((f[i] - t[i]), 2.0)*0.5*f2[i];
            w[3][0] = w[3][0] + learningRate*Math.pow((f[i] - t[i]), 2.0)*0.5*f3[i];
        }
        return w;
    }
    public double[] AFTest(double[][] prweights)
    {
        System.out.println("NEURAL NETWORK TESTING");
        double[] weight1 =  new double[300];
        double[] weight2 = new double[600];
        
        System.out.println("Weights updated after training\n");
        System.out.println("WEIGHTS \t" + prweights[0][0]);
        System.out.println("WEIGHTS \t" + prweights[1][0]);
        System.out.println("WEIGHTS \t" + prweights[2][0]);
        System.out.println("WEIGHTS \t" + prweights[3][0]);
        
        for (int i = 0; i < 300; i++)
        {
            weight1[i] = prweights[0][0] + prweights[1][0]*f1[i] + 
                    prweights[2][0]*f2[i] + prweights[3][0]*f3[i];
        }
        
        int k = 0;
        
        for (int i = 0; i < 300; i++)             
        weight2[i] = f[i];
        
        for (int j = 300; j < 600; j++) 
        {
            weight2[j] = weight1[k];
            k++;
        }
        return weight2;
    }
 }

