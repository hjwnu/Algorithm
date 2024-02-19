import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if( n == 1) {
            System.out.println(0);
            return;
        }
        int[] seq = new int[n+1];
        seq[2] = 3;
        for(int i = 4; i <= n; i+=2){
            seq[i] = seq[i-2]*3;
            for(int j = i-4; j >= 0; j -=2){
                seq[i] += seq[j]*2;
            }
            seq[i] += 2;
        }
        System.out.println(seq[n]);
    }
}