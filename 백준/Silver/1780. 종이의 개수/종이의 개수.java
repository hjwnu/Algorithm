import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> answer = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix= new int[n][n];
        for(int i =0 ; i < n;i++){
            matrix[i] = inputToIntArr(br.readLine());
        }
        for(int i = -1; i < 2;i++){
            answer.put(i,0);
        }
        cutPaper(matrix);

        for(int i = -1; i < 2; i++){
            System.out.println(answer.get(i));
        }

    }

    public static void cutPaper(int[][] matrix){
        int sameNumber = isSameNumber(matrix);
        if(sameNumber>-2){
            answer.put(sameNumber, answer.get(sameNumber)+1);
            return;}

        int len = matrix.length/3;
        int[][] newMatrix = new int[len][len];
        for(int i =0 ; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                for(int row = 0; row < len;row++){
                    for(int col = 0; col < len; col++){
                        newMatrix[row][col] = matrix[row+i*len][col+j*len];
                    }
                }
                cutPaper(newMatrix);
            }
        }
    }
    public static int isSameNumber(int[][] row){
        int len =row.length;
        if(len>1) {
            for (int i = 0; i < row.length-1; i++) {
                for (int j = 0; j < row.length-1; j++) {
                    if(row[i][j]!=row[i][j+1]
                      ||row[i][j]!=row[i+1][j]
                      ||row[i][j]!=row[i+1][j+1]){
                        return -2;
                    }
                }
            }
        }
        return row[0][0];
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

