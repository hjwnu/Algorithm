import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int[] alphabet = new int[26];
        for (char ch : name.toCharArray()) {
            alphabet[ch - 'A'] += 1;
        }
        int odd =0;
        boolean isPalindrom = true;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            if (isOdd(alphabet[i])) {
                odd++;
                answer.append((char)(i+'A'));
                alphabet[i]--;
            }

            if(odd >1) {isPalindrom = false; break;}
        }

        if (!isPalindrom) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            for (int i = alphabet.length-1; i >= 0; i--) {
                String st = String.valueOf((char) (i + 'A'));
                while (alphabet[i] > 0) {
                    answer.append(st);
                    answer.insert(0, st);
                    alphabet[i] -=2;
                }
            }
            System.out.println(answer);
        }
    }
    public static boolean isOdd(int i){
        if(i%2==0) return false;
        else return true;
    }
}