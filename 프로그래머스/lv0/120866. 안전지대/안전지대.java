class Solution {
    private static final int[][] D = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    public static int solution(int[][] board) {
        int n = board.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    boolean safe = true;

                    for (int[] d : D) {
                        int x = i + d[0];
                        int y = j + d[1];

                        if (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 1) {
                            safe = false;
                        }
                    }

                    if (safe) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}