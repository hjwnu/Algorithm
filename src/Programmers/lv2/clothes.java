package Programmers.lv2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;


public class clothes {
    public static void main(String[] args) {
        String[][] clothes = new String[][]{{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"blue_sunglasses", "outer"},{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
    public static int solution(String[][] clothes) {
        int answer = clothes.length;
        HashMap<String, Integer> cloth = new HashMap<>();
        for(int i =0; i < clothes.length;i++){
            String key = clothes[i][1];
            if(cloth.containsKey(key)) cloth.put(key,cloth.get(key)+1);
            else { cloth.put(key,1);}
        }
        ArrayList<Integer> arr = new ArrayList<Integer>(cloth.values());
        for(int i =0; i < arr.size();i++){
//            0+1+2 + 0*1+0*2+1*2 + 0*1*2 미완성. (조합이나 순열) arr의 부분집합의 요소를 곱한 값의 합을 구현해야 함.

        }
        return answer;
        }
 }
