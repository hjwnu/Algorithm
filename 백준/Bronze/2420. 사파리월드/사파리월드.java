import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        long M = in.nextLong();
        System.out.println(abssub(M,N));
    }
    public static long abssub(long N, long M){
        return Math.abs(N-M);
    }
}