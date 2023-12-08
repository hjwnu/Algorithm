import java.io.*;
import java.util.*;

public class Main {
    static List<Long> seq = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < 3 ; i++){seq.add(1L);}
        for(int i =0; i < total;i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(getSeq(n));
        }
    }
    public static long getSeq(int n){
        for(int i = seq.size() ; i < n ; i++){
            seq.add(seq.get(i-2)+seq.get(i-3));
        }
        return seq.get(n-1);
    }
}