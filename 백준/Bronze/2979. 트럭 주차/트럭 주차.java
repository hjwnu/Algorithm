import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] totalParkingTime = new int[101];
        
        int[] fees = inputToIntArr(br.readLine());
        
        for(int i = 0; i < 3; i++){
            int[] truckParking = inputToIntArr(br.readLine());
            for(int j = truckParking[0]; j < truckParking[1];j++){
                totalParkingTime[j]+=1;
            }
        }
        
        int totalFee = 0;
        for(int i =1 ; i < totalParkingTime.length;i++){
            switch(totalParkingTime[i]){
                case 1 : totalFee += fees[0]; break;
                case 2 : totalFee += fees[1]*2; break;
                case 3 : totalFee += fees[2]*3; break;
            }
        }
        System.out.println(totalFee);
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
