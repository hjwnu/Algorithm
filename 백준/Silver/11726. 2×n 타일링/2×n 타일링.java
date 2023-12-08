import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seq = new int[n];
        if(n <=2){System.out.println(n); return;}
        
        seq[0] = 1; seq[1] = 2;
        for(int i = 2; i < n ; i++){
            seq[i] = (seq[i-1] + seq[i-2])%10007;
        }
        System.out.println(seq[n-1]);
    }
}