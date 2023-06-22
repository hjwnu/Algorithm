import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int ans =1;
        for(int i =1; i <=a;i++){
            ans *= i;
        }
        System.out.println(ans);
    }
}