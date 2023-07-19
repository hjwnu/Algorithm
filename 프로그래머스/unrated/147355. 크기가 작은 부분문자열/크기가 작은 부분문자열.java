class Solution {
    public int solution(String t, String p) {
        if (t.length() == p.length()) { return Long.parseLong(p) >= Long.parseLong(t) ? 1 : 0; } // 길이가 같다면, 부분문자열도 하나. 있는 그대로 크기비교하면 됨.
        
        long[] arr = new long[t.length() - p.length() + 1];
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
                arr[i] = Long.parseLong(t.substring(0 + i, p.length() + i)); // 하나씩 이동해가면서, p와 동일한 길이의 부분문자열 저장
            }
        
        long ans = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] <= Long.parseLong(p)) {
                ans++;
            }
        }
        return (int)ans;
    }
}