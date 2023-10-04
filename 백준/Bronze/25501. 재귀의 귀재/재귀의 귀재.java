import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int count =0;
        while(count < total){
            System.out.println(isPalindrome(br.readLine()));
            count++;
        }
    }
    
    public static String recursion(String s, int l, int r, int recursiveCount){
        StringBuilder sb = new StringBuilder();
        if(l >= r) {
            sb.append("1").append(" ").append(recursiveCount);
            return sb.toString();
        } else if(s.charAt(l) != s.charAt(r)) {
            sb.append("0").append(" ").append(recursiveCount);
            return sb.toString();
        } else return recursion(s, l+1, r-1,recursiveCount+1);
    }
    public static String isPalindrome(String s){
        return recursion(s, 0, s.length()-1,1);
    }
}
