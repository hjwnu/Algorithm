import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s, String skip, int index) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String skipal = Arrays.stream(alpha.split(""))
                              .filter(a -> !skip.contains(a))
                              .collect(Collectors.joining());
        String answer = "";
        for(int i =0; i < s.length();i++){
            int idx = skipal.indexOf(s.charAt(i));
            if(index >= skipal.length()) index = index%skipal.length();
            if(idx+index>=skipal.length()) idx = idx-skipal.length();
          answer +=  skipal.charAt(idx+index);
        }
        return answer;
    }
}