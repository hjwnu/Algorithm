import java.util.*;
class Solution {
    public long solution(long n) {
    String str = n +"";
    char[] temp = str.toCharArray();
    Arrays.sort(temp);
    str = new String(temp);
    StringBuilder SB = new StringBuilder(str);
    str = SB.reverse().toString();
    return Long.parseLong(str);
    }
}