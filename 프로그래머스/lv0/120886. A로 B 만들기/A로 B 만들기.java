import java.util.*;
class Solution {
    public int solution(String before, String after) {
    String[] bef = before.split("");
    String[] aft = after.split("");
    Arrays.sort(bef); Arrays.sort(aft);
           
    return String.join("",bef).equals(String.join("",aft))? 1:0;
    }
}