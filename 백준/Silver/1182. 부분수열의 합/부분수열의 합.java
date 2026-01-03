import java.io.*;
import java.util.*;

class Main {
    static int total;
    static int target;
    static int answer = 0;
    static int[] seq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        total = Integer.parseInt(temp[0]);
        target = Integer.parseInt(temp[1]);
        
        seq = new int[total];
        
        String[] seqTemp = br.readLine().split(" ");
        for(int i = 0; i < total; i++){
            seq[i] = Integer.parseInt(seqTemp[i]);
        }
        
        dfs(0, 0);
        
        if (target == 0) answer--;
        
        System.out.println(answer);
    }
    
    public static void dfs(int idx, int sum){
        if(idx == total){
            if(sum == target) answer++; 
            return;
        }
        
        dfs(idx+1, sum + seq[idx]);
        dfs(idx + 1, sum);
    }
}