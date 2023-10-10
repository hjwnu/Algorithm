import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int count = 0;
        
        List<String> answer = new ArrayList<>();
        while(count < tc){
            String[] test = br.readLine().split(" ");
            int repeat = Integer.parseInt(test[0]);
            String word = test[1];
            
            StringBuilder sb = new StringBuilder();
            for(int i =0; i < word.length();i++){
                String[] tmp = word.split("");
                sb.append(tmp[i].repeat(repeat));
            }
            answer.add(sb.toString());
            count++;
        }
        
        for(String ans : answer){
            System.out.println(ans);
        }
    }
}