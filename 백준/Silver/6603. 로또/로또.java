import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input = br.readLine();
            if(input.equals("0")){break;}
            int[] numArr = inputToIntArr(input);
            int[] num = Arrays.copyOfRange(numArr,1, numArr.length);
            boolean[] visited = new boolean[numArr[0]];
            comb(num,visited, 0, 6);
            System.out.println();
        }
    }

    public static void comb(int[] num, boolean[] visited, int depth, int select) {
        if (select == 0) {
            StringBuilder answer = new StringBuilder();
            for(int i = 0; i < num.length; i++) {
                if(visited[i] == true)
                    answer.append(num[i] + " ");
            }
            answer.setLength(answer.length()-1);
            System.out.println(answer);
            return;
        }
        if(depth== num.length){return;}
        visited[depth] = true;
       comb(num, visited, depth+1, select-1);
        visited[depth] = false;
        comb(num, visited, depth+1, select);
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
