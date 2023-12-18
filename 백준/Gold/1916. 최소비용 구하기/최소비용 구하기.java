import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> list;
    static int dist[];
    static int n;
    static class Node implements Comparable<Node> {
        int nodeNum;
        int weight;

        public Node(int nodeNum, int weight){
            this.nodeNum = nodeNum;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        dist = new int[n+1];
        Arrays.fill(dist, INF);

        for(int i = 0; i <= n; i++) list.add(new ArrayList<>());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(s).add(new Node(d,w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start,destination));
    }

    static int dijkstra(int start, int destination){
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visit = new boolean[n+1];

        dist[start] = 0;
        q.add(new Node(start, 0));

        while(!q.isEmpty()){
            Node queNode = q.poll();
            int startNodeNum = queNode.nodeNum;

            if(!visit[startNodeNum]){
                visit[startNodeNum]=true;
                for(Node n : list.get(startNodeNum)){
                    if(!visit[n.nodeNum] && dist[n.nodeNum] > (dist[startNodeNum]+n.weight)) {
                        dist[n.nodeNum]= dist[startNodeNum] + n.weight;
                        q.add(new Node(n.nodeNum, dist[n.nodeNum]));
                    }
                }
            }
        }
        return dist[destination];
    }
}