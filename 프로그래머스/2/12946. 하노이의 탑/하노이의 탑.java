import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);

        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < list.size() ; ++i){
            int[] move = list.get(i);
            answer[i][0] = move[0];
            answer[i][1] = move[1];
        }

        return answer;
    }

    private void hanoi(int n, int from, int via, int to){
        int[] move = {from, to};

        if(n == 1) {
            list.add(move);
        } else {
            hanoi(n - 1, from, to, via);
            list.add(move);
            hanoi(n - 1, via, from, to);
        }
    }
}