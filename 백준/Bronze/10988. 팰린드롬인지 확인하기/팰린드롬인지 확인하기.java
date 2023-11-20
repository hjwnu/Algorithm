import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int answer =0;

        StringBuilder temp = new StringBuilder(word);
        String reverse = temp.reverse().toString();
        if(word.equals(reverse)){answer =1;}
        
        System.out.println(answer);
    }
}
