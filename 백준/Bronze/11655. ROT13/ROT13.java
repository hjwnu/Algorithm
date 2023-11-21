import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        StringBuilder ROT13 = new StringBuilder();
        
        for(int i =0 ; i < sentence.length();i++){
            char ch = sentence.charAt(i);
            if(Character.isUpperCase(ch)){
                boolean upperOver = ch+13>'Z';
                ch += 13;
                if(upperOver){ch -= 26;}
            } else if(Character.isLowerCase(ch)){
                boolean lowerOver = ch+13>'z';
                ch += 13;
                if(lowerOver){ch -= 26;}
            }
            ROT13.append(ch);
        }
        System.out.println(ROT13);
    }
}