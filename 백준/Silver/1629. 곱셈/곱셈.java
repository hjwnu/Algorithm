import java.util.Scanner;
public class Main{
    static long c;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        c = sc.nextLong();
        long answer = pow(a,b);


        System.out.println(answer);
    }
    public static long pow(long  a, long  b){
        if(b==0){return 1;}
        if(b==1){return a%c;}

        long temp = pow(a, b/2);
        
        if(b%2==1){
            return (temp*temp%c) * a %c;
        }
        
        return temp * temp % c;
    }
}