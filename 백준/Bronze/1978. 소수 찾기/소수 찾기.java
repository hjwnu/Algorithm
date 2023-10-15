import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int[] numArr = new int[total];
        String[] tmp = br.readLine().split(" ");
        int ans =0;
        for(int i =0 ; i < total;i++){
            numArr[i] = Integer.parseInt(tmp[i]);
            if(isPrime(numArr[i])){
                ans++;
            }
        }
        System.out.println(ans);
    }
    
    public static boolean isPrime(int num){
        if(num ==2){return true;}
        if(num <=1){return false;}
        for(int i = 2; i*i <= num; i++){
            if(num%i==0){return false;}
        }
        return true;
    }
}