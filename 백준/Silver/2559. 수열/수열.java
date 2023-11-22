import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] seq = inputToIntArr(br.readLine());
        int[] tempo = inputToIntArr(br.readLine());
        int max = 0;
        for(int i =0; i < seq[1];i++){
            max += tempo[i];
        }
        int next = max;
        for(int i =0 ; i < seq[0]-seq[1];i++){
            next += tempo[i+seq[1]] - tempo[i];
            max = Math.max(next,max);
        }
        
        System.out.println(max);
    }
    
    public static int[] inputToIntArr(String input){
        String[] temp = input.split(" ");
        int[] arr = new int[temp.length];
        for(int i =0; i < temp.length;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }
        return arr;
    }
}