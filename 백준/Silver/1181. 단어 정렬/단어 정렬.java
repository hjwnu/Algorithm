import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalWords = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        int cnt =0;
        while(cnt < totalWords){
            cnt++;
            String input = br.readLine();
            if(!words.contains(input)) {
                words.add(input);
            }
        }
        words.sort(null);
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for(String word : words){
            System.out.println(word);
        }
    }
}