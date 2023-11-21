import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        StringBuilder ROT13 = new StringBuilder();
        
        for(int i =0 ; i < sentence.length();i++){
            char ch = sentence.charAt(i);
            if(Character.isLetter(ch)){ch +=13;}
            if( (Character.isLowerCase(ch-13)&&ch>'z')
               || (Character.isUpperCase(ch-13)&&ch>'Z') ){
                ch -= 26;
            }
            ROT13.append(ch);
        }
        System.out.println(ROT13);
    }
}
