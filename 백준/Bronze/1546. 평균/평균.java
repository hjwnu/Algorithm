import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        double[] score = new double[len];
        double max = Integer.MIN_VALUE;
        for(int i =0 ; i < len; i++){
            score[i] = sc.nextDouble();
            max = Math.max(max,score[i]);
        }
        double sum=0;
        for (double i : score){
            sum += (i/max)*100;
        }
        double answer = sum/(double)len;
        System.out.printf("%.2f",answer);
    }
}