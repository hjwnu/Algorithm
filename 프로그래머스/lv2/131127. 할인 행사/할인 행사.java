import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantedMap = new HashMap<>();
        for(int i =0; i < want.length;i++){wantedMap.put(want[i],number[i]);}
        
        for(int i = 0; i < 10; i++){
            String dc = discount[i];
            if(wantedMap.containsKey(dc)){wantedMap.put(dc,wantedMap.get(dc)-1);}
        }
        int day= 0;
        if(allDiscount(wantedMap)){day++;}
        int idx = 10; 
        while(idx < discount.length){
            String day1st = discount[idx-10];
            String dayLast = discount[idx];
            
            if(wantedMap.containsKey(day1st)){wantedMap.put(day1st,wantedMap.get(day1st)+1);}
            if(wantedMap.containsKey(dayLast)){wantedMap.put(dayLast,wantedMap.get(dayLast)-1);}
            idx++; 
            if(allDiscount(wantedMap)){day++;}
        }
        
        return day;
    }
    public boolean allDiscount(Map<String, Integer> map){
        boolean zero = true;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue()==0){zero =true;}
            else {zero = false; break;}
        }
        return zero;
    }
}