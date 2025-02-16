class Solution {
    public int solution(int n, int w, int num) {
           int totalRow = n % w == 0 ? n / w : n / w + 1;
            int targetRow = (num - 1) / w;
            if (totalRow - 1 == targetRow) {
                return 1;
            }

            int column = 0;
            if (targetRow % 2 == 0) {
                column = (num - 1) % w;
            } else {
                column = w - 1 - ((num - 1) % w);
            }

            int count = 0;
            int fullRows = n % w == 0 ? totalRow : totalRow - 1;
            if (targetRow < fullRows) {
                count += fullRows - 1 - targetRow;
            }

            if (n % w != 0 && targetRow < totalRow - 1) {
                int remainder = n % w;
                if ((totalRow - 1) % 2 == 0) {
                    if (column < remainder) count++;
                } else {
                    if (column >= w - remainder) count++;
                }
            }
            return count+1;        
    }
}
