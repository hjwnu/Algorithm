import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder word = new StringBuilder(br.readLine());
        int charNum = 1;
        Set<String> partOfString = new HashSet<>();
        while(charNum<=word.length()){
            for(int i = 0; i+charNum <= word.length();i++){
                partOfString.add(word.substring(i,i+charNum));
            }
            charNum++;
        }
        System.out.println(partOfString.size());
    }
}