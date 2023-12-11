import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            triangle[i] = toIntArr(br.readLine(),n);
        }
        for(int i =1; i < n;i++){
            triangle[i][0] += triangle[i-1][0];
            for(int j = 1; j < i;j++){
                triangle[i][j] += Math.max(triangle[i - 1][j-1], triangle[i - 1][j]);
            }
            triangle[i][i] += triangle[i-1][i-1];
        }
        int max = Integer.MIN_VALUE;
        for(int i =0 ; i < n ; i ++){
            max = Math.max(triangle[n-1][i],max);
        }
        System.out.println(max);
    }
    public static int[] toIntArr(String input, int n){
        String[] temp = input.split(" ");
        int[] arr = new int[n];
        for(int i =0; i < temp.length;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }

        return arr;
    }
}
