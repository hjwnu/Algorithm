import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Long, Integer> temp;

    public int solution(int num) {
        if (num == 1) {
            return 0;
        }
        temp = new HashMap<>();
        return collatz(num)>=500? -1:collatz(num);
    }

    public int collatz(long num) {
        if (num == 1) {
            return 0;
        }
        if (temp.containsKey(num)) {
            return temp.get(num);
        }
        int cnt=0;
        switch((int)(num%2)) {
            case 0: cnt = collatz(num / 2) + 1; break;
            case 1: cnt = collatz(num * 3 + 1) + 1; break;
        }
        temp.put(num, cnt);
        return cnt;
    }
}