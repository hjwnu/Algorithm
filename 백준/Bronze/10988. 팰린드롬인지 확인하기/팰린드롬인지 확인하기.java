import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] alphabet = new int[26];
        for(char ch : word.toCharArray()){
            alphabet[ch-'a']+=1;
        }
        int odd =0;
        for(int i : alphabet){
            if(i>0){
                if(i%2==1){odd++;}
            }
        }
        int answer =0;
        if(odd>1){System.out.println(answer);}
        else {
            StringBuilder temp = new StringBuilder(word);
            String reverse = temp.reverse().toString();
            
            if(word.equals(reverse)){answer =1;}
            System.out.println(answer);
        }
    }
}