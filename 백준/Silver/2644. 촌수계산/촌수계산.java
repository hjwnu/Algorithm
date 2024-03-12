import java.util.*;
import java.io.*;

class Main {
    static class Person {
        int num;
        Integer parent;
        List<Integer> children;

        public Person(int num){
            this.num = num;
            this.parent = null;
            children = new ArrayList<>();
        }

        public void addChildren(int num){
            this.children.add(num);
        }
    }

    static List<Person> list = new ArrayList<>();
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int[] target = new int[2];
        target[0] = Integer.parseInt(st.nextToken());
        target[1] = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= total; i++){
            list.add(new Person(i));
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            list.get(child-1).parent = parent;
            list.get(parent-1).addChildren(child);
        }

        System.out.println(bfs(list.get(target[0]-1), target[1]));
    }

    public static int bfs (Person start, int target){
        Queue<Person> q = new LinkedList<>();
        q.add(start);
        int[] distances = new int[total+1];
        Arrays.fill(distances, -1);
        distances[start.num] = 0;

        while(!q.isEmpty()){
            Person cur = q.poll();

            if( cur.num == target ){ // 일치하면 반환
                return distances[target];
            }

            if(cur.parent != null && distances[cur.parent] == -1){ // 부모 탐색
                q.add(list.get(cur.parent-1));
                distances[cur.parent] = distances[cur.num]+1;
            }

            for(int childNum : cur.children){ // 자식 탐색
                if(distances[childNum] == -1){ 
                    q.add(list.get(childNum -1));
                    distances[childNum] = distances[cur.num]+1;
                }
            }
        }

        return -1;
    }
}