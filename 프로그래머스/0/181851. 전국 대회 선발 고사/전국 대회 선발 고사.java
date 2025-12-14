class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int a = -1, b = -1, c = -1;
        
        for (int i = 0; i < rank.length; i++) {
            if (!attendance[i]) continue;

            if (a == -1 || rank[i] < rank[a]) {
                c = b;
                b = a;
                a = i;
            } else if (b == -1 || rank[i] < rank[b]) {
                c = b;
                b = i;
            } else if (c == -1 || rank[i] < rank[c]) c = i;
        }

        return 10000 * a + 100 * b + c;
    }
}
