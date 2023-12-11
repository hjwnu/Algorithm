import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        int[] seq = new int[n+1];
        seq[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            seq[i] = (seq[i-1]*2)%10007;
            seq[i] += i%2==0 ? 1 : -1;
        }
        System.out.println(seq[n]);
    }
}
/*
1 -> 1
2 -> 3
3 -> 5
4 -> 11
5 -> 21
6 -> 43
7 -> 85
8 -> 171
9 -> 341
10 -> 683
11 -> 1365 
12 -> 2731
11 ㅡㅡ ㅁ
111 ㅡㅡ1 1ㅡㅡ ㅁ1 1ㅁ
1111 ㅡㅡ11 11ㅡㅡ 1ㅡㅡ1 ㅡㅡㅡㅡ ㅁㅁ ㅁ11 11ㅁ ㅡㅡㅁ ㅁㅡㅡ 1ㅁ1
11111 ㅡㅡ111 111ㅡㅡ 1ㅡㅡ11 11ㅡㅡ1 ㅡㅡㅡㅡ1 1ㅡㅡㅡㅡ ㅡㅡ1ㅡㅡ ㅁㅁ1 1ㅁㅁ ㅁ1ㅁ ㅁ111 111ㅁ 1ㅁ11 11ㅁ1 1ㅡㅡㅁ ㅁㅡㅡ1 1ㅁㅡㅡ ㅁ1ㅡㅡ ㅡㅡ1ㅁ ㅡㅡㅁ1
*/