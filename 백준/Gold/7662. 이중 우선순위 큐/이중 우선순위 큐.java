import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalTC = Integer.parseInt(br.readLine());
        for(int i =0; i < totalTC ; i++){
            int total = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> que = new TreeMap<>();
            for(int j = 0 ; j < total ; j++){
                String[] temp = br.readLine().split(" ");
                char command = temp[0].charAt(0);
                int num = Integer.parseInt(temp[1]);
                switch(command){
                    case 'I':
                        que.put(num, que.getOrDefault(num, 0) + 1); break;
                    case 'D':
                        if(que.isEmpty()){continue;}
                        int n = num == 1 ? que.lastKey() : que.firstKey();
                        if(que.get(n)==1){que.remove(n);}
                        else{que.put(n, que.get(n)-1);}

                }
            }
            System.out.println(que.isEmpty()?
                    "EMPTY":que.lastKey()+" "+que.firstKey());
        }
    }
}
