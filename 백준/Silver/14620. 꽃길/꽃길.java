import java.util.*;
import java.io.*;
class Main {
    static class Flower {
        private final int[] center;
        private final List<int[]> around;

        public Flower (int[] center) {
            this.center = center;
            this.around = new ArrayList<>();
            int[] dx = {- 1, 1, 0, 0};
            int[] dy = {0, 0, 1, - 1};
            for (int i = 0; i < 4; i++) {
                int moveX = center[0] + dx[i];
                int moveY = center[1] + dy[i];
                if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n) continue;
                this.around.add(new int[]{moveX, moveY});
            }
        }

        public int[] getCenter () {
            return this.center;
        }

        public List<int[]> getAround () {
            return this.around;
        }
    }


    static int[][] matrix;
    static List<Integer> minCost = new ArrayList<>();
    static List<Flower> flowerList = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static int n;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < n-1; j++){
                Flower flower = new Flower(new int[]{i,j});
                if(flower.getAround().size() != 4) continue;
                flowerList.add(flower);
            }
        }
        visited = new boolean[flowerList.size()];
        findMin(0,0,new ArrayList<>());
        System.out.println(answer);
    }

    public static void findMin(int depth, int price, List<Flower> selectedFlowers){
        if(depth == 3){
            answer = Math.min(price, answer);
            return;
        }

        for(int i = 0; i < flowerList.size(); i++) {
            Flower flower = flowerList.get(i);
            if(!visited[i] && !isContacted(flower, selectedFlowers) ){
                visited[i] = true;
                int tempPrice = getPrice(flower);
                selectedFlowers.add(flower);
                findMin(depth + 1, price + tempPrice, new ArrayList<>(selectedFlowers));
                selectedFlowers.remove(flower);
                visited[i] = false;
            }
        }

    }

    public static boolean isContacted(Flower flower, List<Flower> selectedFlowers) {
        if (selectedFlowers.isEmpty()) return false;
    
        Set<String> around = new HashSet<>();
        for (int[] ar : flower.getAround()) {
            around.add(ar[0] + "," + ar[1]);
        }
        around.add(flower.getCenter()[0] + "," + flower.getCenter()[1]);
    
        for (Flower selected : selectedFlowers) {
            List<int[]> around2 = selected.getAround();
            for (int[] ar : around2) {
                String pos = ar[0] + "," + ar[1];
                if (around.contains(pos)) return true;
            }

            String centerPos = selected.getCenter()[0] + "," + selected.getCenter()[1];
            if (around.contains(centerPos)) return true;
        }
        return false;
}


    public static int getPrice (Flower flower){
        int price = 0;
        int[] center = flower.getCenter();
        List<int[]> around = flower.getAround();

        price += matrix[center[0]][center[1]];
        for(int i = 0; i < 4; i++){
            price += matrix[around.get(i)[0]][around.get(i)[1]];
        }
        return price;
    }



}