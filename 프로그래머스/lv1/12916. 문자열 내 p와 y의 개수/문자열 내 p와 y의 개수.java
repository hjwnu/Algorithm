import java.util.Arrays;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s= s.toLowerCase();
        int pcount = (int)Arrays.stream(s.split("")).filter(a -> a.equals("p")).count();
        int ycount = (int)Arrays.stream(s.split("")).filter(a -> a.equals("y")).count();
       
        return pcount==ycount;
    }
}