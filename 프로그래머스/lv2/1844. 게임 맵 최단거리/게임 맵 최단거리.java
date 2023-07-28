import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps[0].length; int m = maps.length;
        boolean[][] visited = new boolean[m][n];
        int[][] distanceMap = new int[m][n]; // 각 위치까지 도달하기 위한 시작점으로부터의 최단거리  

        bfs(maps, visited, distanceMap);

        return distanceMap[m - 1][n - 1] == 0 ? -1 : distanceMap[m - 1][n - 1];
    }

    public void bfs(int[][] maps, boolean[][] visited, int[][] distanceMap) {

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0, 0, 1}); visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] xy = q.poll(); int x = xy[0]; int y = xy[1];  // 각각 현재 위치의  x, y좌표 저장
            int distance = xy[2]; // 시작점부터 현재 위치까지의 거리

            distanceMap[y][x] = distance; // 해당 위치까지의 거리 저장

            int[][] ALL = {{x - 1, y}, {x + 1, y}, {x, y + 1}, {x, y - 1}}; // 기존 위치로부터 4방향 탐색

            for (int[] XY : ALL) {
                int X = XY[0]; int Y = XY[1]; // 각각 이동 후의 x,y좌표
                if ((0 <= X && X < maps[0].length) // X가 전체 맵을 넘지 않는지
                        && (0 <= Y && Y < maps.length) // Y가 전체 맵을 넘지 않는지 
                        && (maps[Y][X] == 1) // 갈 수 있는 길인지
                        && (visited[Y][X] == false)) { // 방문한적 없는지 여부 체크
                    
                    q.add(new int[]{X, Y, distance + 1}); // 거리 1 늘리고, 현재 위치에 이동 후 위치 저장
                    visited[Y][X] = true; // 방문 체크
                }
            }
        }
    }
}