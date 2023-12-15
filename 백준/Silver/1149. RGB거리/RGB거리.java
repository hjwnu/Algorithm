import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int house = Integer.parseInt(br.readLine());
        int[][] cost = new int[house][3];
        for(int i = 0 ; i < house ; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i =1 ; i< house ; i++){
            for(int j = 0; j < 3; j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0 ; k < 3; k++){
                    if(k!=j){ min = Math.min(cost[i-1][k],min); }
                }
                cost[i][j] += min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i : cost[house-1]){
            ans = Math.min(i,ans);
        }
        System.out.println(ans);
    }
}
