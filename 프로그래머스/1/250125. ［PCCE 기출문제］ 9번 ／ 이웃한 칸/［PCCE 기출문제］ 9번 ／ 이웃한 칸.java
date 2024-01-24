class Solution {
    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int len = board.length;
        String target = board[h][w];
        for(int[] d : direction){
            int x = h + d[0];
            int y = w + d[1];
            if(x >= 0 && y >= 0 && x < len && y < len
                && board[h][w].equals(board[x][y])) answer++;
        }
        return answer;
    }
}