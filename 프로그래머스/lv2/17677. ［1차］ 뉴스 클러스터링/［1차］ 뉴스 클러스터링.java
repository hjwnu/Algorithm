import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> first = new HashMap<>();
        Map<String, Integer> second = new HashMap<>();

        savePairLetter(first, str1); savePairLetter(second, str2);
        
        return (int)(unionAndIntersection(first,second)*65536);
    }
    
    public Map<String, Integer> savePairLetter(Map<String, Integer> first, 
                                                      String str){
        str= str.toUpperCase();
        for (int i = 0; i < str.length() - 1; i++) {
            String pair = str.substring(i, i + 2);
            if (pair.matches("[A-Z]{2}")) {
                first.put(pair, first.getOrDefault(pair, 0) + 1);
            }
        }
        return first;
    }
    
    public double unionAndIntersection(Map<String, Integer> first, Map<String, Integer> second){
        Map<String,Integer> union = new HashMap<>();
        Map<String,Integer> insec = new HashMap<>();
        for(String key : first.keySet()){
            if(second.containsKey(key)){
                union.put(key,Math.max(first.get(key),second.get(key)));
                insec.put(key,Math.min(first.get(key),second.get(key)));
            }
            else {union.put(key, first.get(key));}
        }
        for(String key : second.keySet()){
            if(!union.containsKey(key)){
                union.put(key, second.get(key));
            }
        }
        
        double unisum = valueSum(union);
        double insecsum = valueSum(insec);
        
        return unisum == 0? 1:insecsum/unisum;
    }
    
    public double valueSum(Map<String, Integer> map){
        double sum = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            sum += entry.getValue();
        }
        return sum;
    }
}