import java.io.*;
import java.util.*;

public class Main {
    static int[][] direction = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] apart;
    static boolean[][] visited;
    static int total;
    static List<Integer> houseList = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        apart = new int[total][total];
        visited = new boolean[total][total];
        for(int i =0; i < total;i++){
            apart[i] = inputToIntArr(br.readLine());
        }
        for(int i =0;i < total;i++){
            for(int j =0; j < total;j++){
                if(apart[i][j]==1&&!visited[i][j]){
                    find(i,j);
                }
            }
        }
        System.out.println(houseList.size());
        houseList.sort(null);
        for(int i =0 ; i < houseList.size();i++){
            System.out.println(houseList.get(i));
        }
    }

    public static void find(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        int house =0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0]; int curY = cur[1];
            for(int[] d : direction){
                int moveX = cur[0]+d[0];
                int moveY = cur[1]+d[1];
                if(moveX>=0&&moveX<total&&moveY>=0&&moveY<total
                        &&apart[moveX][moveY]==1&&!visited[moveX][moveY]){
                    q.add(new int[]{moveX,moveY});
                    visited[moveX][moveY] = true;
                    ++house;
                }
            }

        }
        houseList.add(house);
    }
    public static int[] inputToIntArr(String input){
        String[] temp = input.split("");
        int[] arr = new int[temp.length];
        for(int i =0; i < temp.length;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }
        return arr;
    }
}