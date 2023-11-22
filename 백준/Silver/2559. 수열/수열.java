import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] seq = inputToIntArr(br.readLine());
        int[] tempo = inputToIntArr(br.readLine());
        List<Integer> maxSum = new ArrayList<>();
        for(int i =0; i < seq[0]-seq[1]+1;i++){
            int max = 0;
            for(int j =i ; j < i+seq[1];j++){
                max += tempo[j];
            }
            maxSum.add(max);
        }
        Collections.sort(maxSum);
        System.out.println(maxSum.get(maxSum.size()-1));
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