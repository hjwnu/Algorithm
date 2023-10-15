import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
        String[] tmp = br.readLine().split(" ");
        if(tmp[1].equals("0")){break;}
        int[] num = new int[3];
        for (int i =0; i < 3; i++){
            num[i] = Integer.parseInt(tmp[i]);
        }
        if (isRightTriangle(num)) { System.out.println("right"); } 
        else { System.out.println("wrong");}
        
        }
    }
    
    public static boolean isRightTriangle(int[] num){
        Arrays.sort(num);
        if(num[0]*num[0]+num[1]*num[1]==num[2]*num[2]){return true;}
        else return false;
    }
}