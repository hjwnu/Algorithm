import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        String[] color = new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        Map<String, long[]> word = new HashMap<>();
        for(int i =0; i < 10;i++){
            long[] tmp = new long[2];
            tmp[0] = i; tmp[1] = (int)Math.pow(10,i);
            word.put(color[i],tmp);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        long temp;
        while(true){
            answer.append(word.get(br.readLine())[0]);
            if(answer.length()==2){
                temp = Long.parseLong(answer.toString())*word.get(br.readLine())[1];
                break;
            }
        }
        System.out.println(temp);
    }
}
