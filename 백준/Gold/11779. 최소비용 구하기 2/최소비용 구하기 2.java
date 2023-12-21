import java.util.*;
import java.io.*;
public class Main{
    static List<List<Node>> list = new ArrayList<>();
    static int start;
    static int cities;
    static int[] dist, prev;
    public static class Node implements Comparable<Node>{
        private int num;
        private int cost;
        public Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node n){
            return Integer.compare(this.cost, n.cost);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        cities = Integer.parseInt(br.readLine());
        int buses = Integer.parseInt(br.readLine());
        dist = new int[cities+1];
        prev = new int[cities+1];
        for(int i = 0 ; i <= cities;i++){
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < buses; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end,cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        findMinCost(start,end);
        reverseTrace(end);
    }
    private static void reverseTrace(int end){
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while(prev[end]!=0){
            stack.push(prev[end]);
            end = prev[end];
        }
        System.out.println(stack.size());
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
    private static void findMinCost(int start, int end){
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[start] = 0;
        q.add(new Node(start,0));
        while(!q.isEmpty()){
            Node n = q.poll();
            int startNode = n.num;
            if(dist[startNode] >= n.cost){
                for(Node node : list.get(startNode)){
                    if(dist[node.num] > (dist[startNode]+node.cost)){
                        dist[node.num] = dist[startNode]+node.cost;
                        prev[node.num] = startNode;
                        q.add(new Node(node.num,dist[node.num]));
                    }
                }
            }
        }
        System.out.println(dist[end]);
    }
}
