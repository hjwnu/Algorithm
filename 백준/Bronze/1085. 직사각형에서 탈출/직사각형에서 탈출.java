import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        
        int min = Math.min(x,y);
        min = Math.min(min,w-x);
        min = Math.min(min, h-y);
        
        System.out.println(min);
    }
}