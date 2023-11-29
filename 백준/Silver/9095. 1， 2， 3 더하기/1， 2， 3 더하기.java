import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int[] seq = new int[12];
        seq[3]= 4;
        for(int i =1 ; i < 12;i++){
            if(i <= 2){ seq[i] = i;}
            if(i > 3 ){seq[i]=seq[i-1]+seq[i-2]+seq[i-3];}
        }
        for(int i =0; i < total;i++){
            System.out.println(seq[Integer.parseInt(br.readLine())]);
        }    
    }
}

/*  
1 => 1 // 1 1개, 2 0개, 3 0개
2 => 1+1, 2 // 1 2개 // 1 0개 2 1개, 3 0개
3 => 1+1+1, 1+2, 2+1, 3 
// 1 3개 2 0개, 3 0개// 1 1개, 2 1개 3 0개// 1 0개, 2 0개, 3 1개
4 => 1+1+1+1, 1+2+1, 2+1+1, 3+1, 1+1+2, 2+2, 1+3 
// 1 4개 2 0개 3 0개 // 1 2개 2 1개 3 0개// 1 1개 2 0개 3 1개 // 1 0개 2 2개 3 0개 
5 => 1+1+1+1+1, 1+2+1+1,2+1+1+1, 3+1+1, 1+1+2+1, 2+2+1, 1+3+1, 1+1+1+2,1+2+2,2+1+2,3+2, 2+3
// 1 5개 2 0개 3 0개 1 // 1 3개 2 1개 3 0개 4// 1 2개 2 0개 3 1개 3// 1 1개 2 2개 3 0개 3
// 1 0개 2 1개 3 1개 2 -> 13개
6 => 12, 12, 8
// 1 6개 2 0개 3 0개 1// 1 4개 2 1개 3 0개 5// 1 3개 2 0개 3 1개 4// 1 2개 2 2개 3 0개 6개
// 1 1개 2 1개 3 1개 6// 1 0개 2 3개 3 0개 1// 1 0개 2 0개 3 2개 1 -> 25개
7 => 32 + 


1 - 1, 2 - 2 ,3 - 4
4 = 3, 2, 1 => 4+2+1 = 7
5 = 4, 3, 2 => 7 + 4 + 2 = 13
6 = 5, 4, 3 => 13 + 7 + 4 = 24
7 = 6, 5, 4 => 24 + 13 + 7 = 44

*/