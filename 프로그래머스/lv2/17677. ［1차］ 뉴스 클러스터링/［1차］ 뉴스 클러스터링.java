import java.util.*;
class Solution {
    static Map<String, Integer> first = new HashMap<>();
    static Map<String, Integer> second = new HashMap<>();
    static Map<String,Integer> union = new HashMap<>();
    static Map<String,Integer> insec = new HashMap<>();
    
    public int solution(String str1, String str2) {
        saveMapPairLetter(first, str1); saveMapPairLetter(second, str2); // 각 글자쌍 맵에 저장
        
        // 합집합과 교집합 구하기. 
        unionAndIntersec(); // 합집합/교집합 각 메서드로 나누면 동일한 반복문을 여러번 중복해야 함.
        
        double unisum = valueSum(union);
        double insecsum = valueSum(insec);
        
        return unisum==0? 65536:(int)(insecsum/unisum*65536);
    }
    
    public void saveMapPairLetter(Map<String, Integer> map, String str){
        str= str.toUpperCase();
        for (int i = 0; i < str.length() - 1; i++) {
            String pair = str.substring(i, i + 2);
            if (pair.matches("[A-Z]{2}")) { // 영 대문자 2글자로만 이루어진 문자열만
                map.put(pair, map.getOrDefault(pair, 0) + 1); 
            }
        }
    }
    
    public void unionAndIntersec(){
        for(String key : first.keySet()){
            int value1 = first.get(key);
            if(second.containsKey(key)){
                //양 쪽에 모두 있는 글자라면 합집합에는 최대치를, 교집합은 최소치를 넣어야 한다.
                int value2 = second.get(key);
                union.put(key,Math.max(value1, value2)); 
                insec.put(key,Math.min(value1, value2));
            } // 한쪽에만 있다면, 따로 추가
            else {union.put(key, value1);}
        }
        
        // 중복되지 않은 두번째 문자열의 글자쌍 추가
        for(String key : second.keySet()){
            if(!union.containsKey(key)){
                union.put(key, second.get(key));
            }
        }
    }
    
    public double valueSum(Map<String, Integer> map){
        double sum = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            sum += entry.getValue();
        }
        return sum;
    }
}