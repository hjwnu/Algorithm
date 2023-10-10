import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();
        int[] frequency = new int[27];
        for(char ch : word.toCharArray()){
            frequency[ch-'A'+1]++;
        }
        int max = 0;
        char maxAlpha = 96;
        for(int i =0 ; i < frequency.length;i++){
            if(frequency[i]> max){
                max = frequency[i];
                maxAlpha = (char)(i-1+'A');}
            else if(frequency[i] == max){maxAlpha = '?';}
        }
        System.out.println(maxAlpha);
    }
}