import java.io.*;
import java.util.*;

public class Main{
    static List<Character> letter;
    static boolean[] visited;
    static int ansLen;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = inputToIntArr(br.readLine());
        ansLen = num[0];
        letter = new ArrayList<>();
        for(char ch : br.readLine().toCharArray()){
            if(ch!=' '){
                letter.add(ch);
            }
        }
        visited =new boolean[num[1]];
        letter.sort(null);
        comb(0,0);
    }
    public static void comb(int start, int selected){
        if(selected==ansLen){
            StringBuilder sb = new StringBuilder();
            int vow = 0; int con = 0;

            for(int i =0; i < letter.size();i++){
                char ch = letter.get(i);
                if(visited[i]){
                    sb.append(ch);
                    if(ch=='a'||ch=='e'||ch=='o'||ch=='i'||ch=='u'){
                        vow++;
                    } else {
                        con++;
                    }
                }
            }
            if(vow>=1&&con>=2){
                System.out.println(sb);
            }
        }
        for(int i =start; i < letter.size();i++){
            visited[i] = true;
            comb(i+1,selected+1);
            visited[i] = false;
        }
    }
    public static int[] inputToIntArr(String input){
        String[] temp = input.split(" ");
        int[] arr = new int[temp.length];
        for(int i =0; i < temp.length;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }

        return arr;
    }
}