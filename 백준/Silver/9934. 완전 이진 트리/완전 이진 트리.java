import java.util.*;
import java.io.*;

class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static int depth;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        depth = Integer.parseInt(br.readLine());
        for(int i = 0; i < depth; i++){
            list.add(new ArrayList<>());
        }
        int len = (int) Math.pow(2,depth)-1;
        arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < len; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }        
        find(0, len, 0);
        
        for(List<Integer> l : list){
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    static void find(int start, int end, int dep){
        if(depth == dep) return;
        
        int mid = (start+end) / 2;
        
        list.get(dep).add(arr[mid]);
        
        find(start, mid-1, dep+1);
        find(mid+1, end, dep+1);
        
    }
}