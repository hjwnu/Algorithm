import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < name.length;i++){
         map.put(name[i],yearning[i]);   
        }
        int[] answer = new int[photo.length];
        for( int a = 0; a < photo.length;a++ ){
        for( int j = 0; j < photo[a].length;j++){
            if(map.get(photo[a][j])!=null){
            answer[a] += map.get(photo[a][j]);
            }
        }
        }
        return answer;
    }
}