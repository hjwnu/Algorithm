package Programmers.lv0;
/*
지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.

제한사항
board는 n * n 배열입니다.
1 ≤ n ≤ 100
지뢰는 1로 표시되어 있습니다.
board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
 */
public class SafeZone {

    public static void main(String[] args) {
        int[][] a = {{0, 0, 0}, {0, 0, 1}, {0, 0, 0}};
        System.out.println(solution(a));
    }
        private static final int[][] D = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
};

    public static int solution(int[][] board) {
        int n = board.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    boolean safe = true; // 8방향에 지뢰여부 있는지 확인 후 안전지대가 맞는지 체크

                    for (int[] d : D) { // 8방향 순회
                        int x = i + d[0];
                        int y = j + d[1];

                        if (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 1) { //배열 범위 내 폭탄이 있다면 안전지대X
                            safe = false;
                        }
                    }

                    if (safe) { // 안전지대로 판명난 곳만 카운트
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
