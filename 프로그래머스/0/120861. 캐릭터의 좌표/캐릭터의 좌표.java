class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0, y = 0;
        int maxX = board[0] / 2;
        int maxY = board[1] / 2;

        for (String key : keyinput) {
            switch (key) {
                case "left"  -> x = Math.max(-maxX, x - 1);
                case "right" -> x = Math.min( maxX, x + 1);
                case "down"  -> y = Math.max(-maxY, y - 1);
                case "up"    -> y = Math.min( maxY, y + 1);
            }
        }
        int[] answer = new int[]{x, y};
        return answer;
    }
}