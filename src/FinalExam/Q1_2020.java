package FinalExam;

import java.io.File;
import java.util.Scanner;

public class Q1_2020 {
    public static double[] smooth(double[] v, double beta) {
        double[] s = new double[v.length];
        double u = 0;
        for (int i = 1; i < v.length; i++) {
            u = beta * u + (1 - beta) * v[i];
            s[i] = u / (1 - Math.pow(beta, i));
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("src/Q1.txt"));
        double[] v = new double[114];
        for (int i = 0; i < 114; i++)
            v[i] = in.nextDouble();
        double[] s = smooth(v, 0.9);
        for (double d : s)
            System.out.print(d + " ");
    }
}
