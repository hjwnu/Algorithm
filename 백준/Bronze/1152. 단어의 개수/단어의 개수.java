import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String sequence = in.nextLine();
        String[] arr = sequence.trim().split(" ");
        int cnt=0;
        for(int i =0; i < arr.length;i++){
            if(arr[i].matches(".*[A-Za-z].*")){cnt++;}
        }
        System.out.println(cnt);
    }
}