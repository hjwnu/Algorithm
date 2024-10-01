import java.util.*;
class Solution {
    public String[] solution(String[] str_list) {
        List<String> list = new ArrayList<>();
        Boolean isLeft = null;
        int idx = -1;
        for(int i = 0; i < str_list.length;i++){
            String str = str_list[i];
            if(str.equals("l") || str.equals("r")){
                idx = i;
                isLeft = str.equals("l");
                break;
            }
        }
        if(idx == -1){
            return new String[]{};
        }
        return isLeft ? Arrays.copyOfRange(str_list, 0, idx) 
            : Arrays.copyOfRange(str_list, idx+1, str_list.length);
    }
}