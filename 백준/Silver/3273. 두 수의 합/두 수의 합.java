import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List<Integer> seq = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++) seq.add(Integer.parseInt(st.nextToken()));
        Collections.sort(seq);
        
        int target = Integer.parseInt(br.readLine());
        
        int loIdx = 0;
        int hiIdx = seq.size()-1;
        
        int cnt = 0;
        while(loIdx < hiIdx){
            int lo = seq.get(loIdx);
            int hi = seq.get(hiIdx);
            if ( lo + hi < target) loIdx++;
            else if ( lo + hi > target) hiIdx--;
            else {
              cnt++;
              loIdx++;
            }
        }
        
        System.out.println(cnt);
    }
}
