import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        ArrayDeque<Character> st = new ArrayDeque<>();
        long ans = 0;
        long temp = 1;

        char prev = '\0';

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.addLast(c);
                temp *= 2;
            } else if (c == '[') {
                st.addLast(c);
                temp *= 3;
            } else if (c == ')') {
                if (st.isEmpty() || st.peekLast() != '(') {
                    System.out.println(0);
                    return;
                }
                if (prev == '(') ans += temp; // "()"가 바로 닫힘
                st.pollLast();
                temp /= 2;
            } else if (c == ']') {
                if (st.isEmpty() || st.peekLast() != '[') {
                    System.out.println(0);
                    return;
                }
                if (prev == '[') ans += temp; // "[]"가 바로 닫힘
                st.pollLast();
                temp /= 3;
            } else {
                System.out.println(0);
                return;
            }
            prev = c;
        }

        if (!st.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(ans);
    }
}
