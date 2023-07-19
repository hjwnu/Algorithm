import java.util.*;
class Solution {
    public int solution(String s) {
        HashMap<String, String> key = new HashMap<>();
        key.put("0","zero"); key.put("1","one"); key.put("2","two"); key.put("3","three"); key.put("4","four");
        key.put("5","five"); key.put("6","six"); key.put("7","seven"); key.put("8","eight"); key.put("9","nine");

        for (String num : key.keySet()) {
            s = s.replaceAll(key.get(num), num);
        }
        return Integer.parseInt(s);
    }
    }
