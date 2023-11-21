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
            if(totalParkingTime[i]==1){
                totalFee += fees[0];
            } else if(totalParkingTime[i]==2){
                totalFee += fees[1]*2;
            } else if(totalParkingTime[i]==3){
                totalFee += fees[2]*3;
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
