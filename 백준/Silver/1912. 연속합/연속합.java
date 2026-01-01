import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int cur = first;
        int best = first;
        for(int i = 1; i < N; i++){
            int x =Integer.parseInt(st.nextToken());
            cur = Math.max(x, cur + x);
            best = Math.max(cur, best);
        }
        
        System.out.println(best);
    }
        
}