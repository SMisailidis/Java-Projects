import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int mg, n, tl, nice, vrStart;
        double sum=0;
        Scanner input = new Scanner(System.in);
        ArrayList<Double> ks = new ArrayList<>();

        System.out.println("Give n");
        n = input.nextInt();

        System.out.println("Give mg");
        mg = input.nextInt();

        System.out.println("Give vrStart");
        vrStart = input.nextInt();

        tl = mg * n;
        System.out.println("The value of tl is " + tl);

        for(int i = 0; i<n; i++)
        {
            System.out.println("Give NICE of the process: P" + i);
            nice = input.nextInt();

            double w = (double) Math.pow(1.25, nice) * 1024;
            System.out.println("The value of W for the process: P" + i + " is " + w);

            double vr = vrStart + (mg *  w);
            System.out.println("The Virtual run time (VR) of the process: P" + i + " is " + vr);

            double k = 1024/(double) Math.pow(1.25, nice);
            ks.add(k);
            sum += k;
            System.out.println("The value of K for the process: P" + i + " is " + k + "\n");

        }

        System.out.println("The value of M from all the processes is: " + (int) sum);

        double pos=0;
        double sumPos=0;
        for(Double d : ks)
        {
            int i=0;
            pos = (d/sum) * tl;
            System.out.println("The percentage of the process: P" + i + " is " + pos);
            sumPos += pos;
            i++;
        }

        //System.out.println("the sumPos is : " + Math.round(sumPos));
        if(Math.round(sumPos) == tl)
            System.out.println("\nCORRECT");
        else
            System.out.println("\nINCORRECT");

    }

}