import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int wordCount = Integer.parseInt(br.readLine());
        int count = 1;
        String first = br.readLine();
        int wordLength= first.length();
        
        char[] answer = new char[wordLength];
        
        for(int i = 0 ; i < wordLength;i++){
            answer[i] = first.charAt(i);    
        }
        
        while(count < wordCount){
            String nextWord = br.readLine();
            for(int i = 0 ; i < wordLength;i++){
                if(answer[i]!=nextWord.charAt(i)){
                    answer[i] = '?';
                }    
            }
            count++;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : answer){
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}