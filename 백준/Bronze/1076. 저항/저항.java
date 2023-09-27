import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] alphabet = new int[26];
        for(int i =0; i < word.length();i++){
            alphabet[word.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i < alphabet.length;i++){
            sb.append(alphabet[i]).append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb.toString());
        br.close();
    }
}
