import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        if(x*y>0){
            if(x>0){System.out.println(1);}
            else if(x<0){System.out.println(3);}
        }
        else if(x*y<0){
            if(x>0){System.out.println(4);}
            else if(x<0){System.out.println(2);}
        }
    }
}