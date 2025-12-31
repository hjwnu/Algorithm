import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        List<Integer> josep = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            josep.add(i);
        }
        
        StringBuilder sb = new StringBuilder("<");
        int start = 0;
        while(josep.size() > 0){
            int removeIdx = (start + k - 1) % josep.size(); 
            start = removeIdx;
            int removed = josep.remove(removeIdx);
            
            sb.append(removed);
            if(!josep.isEmpty()) sb.append(", ");
        }
        
        sb.append(">");
        System.out.println(sb);
    }
}