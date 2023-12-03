
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] temp = toIntArr(br.readLine());
        int total = temp[0]; int TC = temp[1];
        int[] numArr = toIntArr(br.readLine());
        int[] cumulSum = new int[numArr.length+1];

        for(int i =1; i < total+1;i++){
            cumulSum[i] = cumulSum[i-1] + numArr[i-1];
        }
        for(int i = 0; i < TC;i++){
            int[] tmp = toIntArr(br.readLine());
            System.out.println(cumulSum[tmp[1]]-cumulSum[tmp[0]-1]);
        }

    }
    public static int[] toIntArr(String input){
        String[] temp = input.split(" ");
        int[] arr = new int[temp.length];
        for(int i =0; i < temp.length;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }

        return arr;
    }
}