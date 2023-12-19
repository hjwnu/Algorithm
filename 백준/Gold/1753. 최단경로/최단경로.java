import java.util.*;
import java.io.*;
public class Main{
    static List<List<Node>> list;
    static int start;
    static int v;
    static int[] dist;
    public static class Node implements Comparable<Node>{
        private int num;
        private int len;

        public Node(int num, int len){
            this.num = num;
            this.len = len;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(this.len, n.len);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        dist = new int[v+1];

        for(int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end,weight));
        }
        findPath();
        for(int i = 1 ; i <= v; i++){
            int ans = dist[i];
            System.out.println(ans == Integer.MAX_VALUE? "INF":ans);
        }
    }

    private static void findPath(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start,0));
        dist[start] = 0;
        while(!q.isEmpty()){
            Node qNode = q.poll();
            int startNode = qNode.num;
            for(Node  n: list.get(startNode)){
                if(dist[n.num] > (dist[startNode]+n.len)){
                    dist[n.num] = dist[startNode]+n.len;
                    q.add(new Node(n.num, dist[n.num]));
                }
            }
        }
    }
}