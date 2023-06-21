import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        System.out.println(y(year));
    }
    public static int y(int year){
        return year%4==0&&year%100!=0||year%400==0?1:0;
    }
}