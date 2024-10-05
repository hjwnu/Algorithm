import java.util.*;
class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < picture.length;i++){
            StringBuilder newSb = new StringBuilder();
            for(int j = 0; j < picture[i].length();j++){
                newSb.append(String.valueOf(picture[i].charAt(j)).repeat(k));
            }
            String str = newSb.toString();
            for(int count = 0; count < k; count++){
                list.add(str);
            }
        }
        return list.toArray(new String[0]);
    }
}