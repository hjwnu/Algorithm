class Solution {
    public int solution(String A, String B) {
        if (A.equals(B)) return 0;

        String cur = A;
        for (int i = 1; i <= A.length(); i++) {
            cur = cur.charAt(cur.length() - 1) + cur.substring(0, cur.length() - 1);
            if (cur.equals(B)) return i;
        }
        return -1;
    }
}