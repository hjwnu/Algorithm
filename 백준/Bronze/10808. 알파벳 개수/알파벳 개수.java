import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] alphabet = new int[26];
        for(int i =0; i < word.length();i++){
            alphabet[word.charAt(i)-97]++;
        }
        for(int i=0 ; i < alphabet.length;i++){
            if(i!=26){System.out.print(alphabet[i]+" ");}
            else{System.out.print(alphabet[i]);}
        }
    }
}