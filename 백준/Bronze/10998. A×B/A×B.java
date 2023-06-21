import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        System.out.println(pro(N,M));
    }
    public static int pro(int N, int M){
        return N*M;
    }
}