import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word =br.readLine();
        String bomb = br.readLine();
        Stack<Character> wordStack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            wordStack.push(word.charAt(i));
            if (wordStack.size() >= bomb.length()) {
                boolean isBomb = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (wordStack.get(wordStack.size()-bomb.length()+j)!= bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                    if (isBomb) {
                        for (int j = 0; j < bomb.length(); j++) {
                            wordStack.pop();
                        }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : wordStack) {
            sb.append(ch);
        }
        String ans = sb.length()==0? "FRULA" : sb.toString();
        System.out.println(ans);
    }
}