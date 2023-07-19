import java.util.*;
class Solution {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> cloth = new HashMap<>();
        for(int i =0; i < clothes.length;i++){
            String key = clothes[i][1];
            if(cloth.containsKey(key)) cloth.put(key,cloth.get(key)+1);
            else { cloth.put(key,1);}
        }
        ArrayList<Integer> arr = new ArrayList<Integer>(cloth.values());
        int temp =1;
        for(int i =0; i < arr.size();i++){
            temp *= arr.get(i)+1;

        }
        return temp-1;
    }
}
