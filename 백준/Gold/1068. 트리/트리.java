import java.io.*;
import java.util.*;

public class Main {
    static int N, root, ans;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        
        stringTokenizer = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ;i++){
            int x = Integer.parseInt(stringTokenizer.nextToken());
            parent[i] = x;
            if(x == -1) root = i;
        }

        int remove = Integer.parseInt(br.readLine());

        removeNode(remove);

        ans = 0;
        visited = new boolean[N];
        countLeaf(root);
        
        System.out.println(ans);
    }

    private static void countLeaf(int idx) {
        boolean isLeaf = true;
        visited[idx] = true;
        if(parent[idx] != -2){
            for(int i = 0 ; i < N ; i++){
                if(parent[i] == idx && !visited[i]){
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if(isLeaf)
                ans++;
        }

    }

    private static void removeNode(int idx) {
        parent[idx] = -2;

        for(int i = 0 ; i < N ; i++){
            if(parent[i] == idx)
                removeNode(i);
        }
    }
}
