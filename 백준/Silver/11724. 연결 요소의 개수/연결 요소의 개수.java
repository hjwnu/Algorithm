import java.util.*;
import java.io.*;

public class Main {
    static int[] total;
    static int[][] matrix;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = inputToArr(br.readLine());
        matrix = new int[total[0]+1][total[0]+1];
        for(int i = 0; i < total[1]; i++){
            int[] temp = inputToArr(br.readLine());
            matrix[temp[0]][temp[1]] = 1;
            matrix[temp[1]][temp[0]] = 1;
        }
        visited = new boolean[total[0]+1];
        int connected = 0;
        for(int i = 1 ; i <= total[0] ; i++) {
            if(!visited[i]) {
                connected++;
                findConnect(i);
            }
        }

        System.out.println(connected);
    }

    public static void findConnect(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for(int i = 1 ; i <= total[0];i++){
            if(matrix[node][i] == 1 && !visited[i]){
                findConnect(i);
            }
        }

    }

    public static int[] inputToArr(String str){
        String[] temp = str.split(" ");
        int[] intArr = new int[temp.length];

        for(int i = 0; i < temp.length; i++){
            intArr[i] = Integer.parseInt(temp[i]);
        }
        return intArr;
    }
}