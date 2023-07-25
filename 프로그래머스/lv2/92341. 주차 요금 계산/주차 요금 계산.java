import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parkingTime = new HashMap<>();
        for(int i= 0; i < records.length;i++){
            String[] split = records[i].split(" ");
            String[] time = split[0].split(":");
            String carNum = split[1];
            int hour = Integer.parseInt(time[0])*60; int minute = Integer.parseInt(time[1]);
            
            if(split[2].equals("IN")){ // 입차시간은 모두 뺄셈하고,
                parkingTime.put(carNum,parkingTime.getOrDefault(carNum,0)-hour-minute);
            }
            if(split[2].equals("OUT")){ // 출차시간은 모두 덧셈하면, 총 주차시간을 알 수 있다.
                parkingTime.put(carNum,parkingTime.getOrDefault(carNum,0)+hour+minute);
            }
        }
        
        Map<String, Integer> sortCarNum = new TreeMap<>(parkingTime); // 차번호 작은 순서

        int[] ans = new int[sortCarNum.size()];
        int idx =0;
        for(Map.Entry<String,Integer> entry : sortCarNum.entrySet()){
            int value = entry.getValue();
            String key = entry.getKey();
            if(value<=0){ // 만약 출차X라면, 주차시간값은 언제나 음수다. 23:59에 출차한 것으로 간주한다. 
                sortCarNum.put(key, sortCarNum.getOrDefault(key,0)+23*60+59); 
                value = entry.getValue();}
            
            if(value<=fees[0]){ // 기본 주차시간 이하
                ans[idx++] = fees[1]; 
            } else{
                double tmpTime = value-fees[0];
                double tmpFee = fees[2];
                ans[idx++] = fees[1]+(int)(Math.ceil(tmpTime/tmpFee))*fees[3]; // 단위 시간으로 나눠떨어지지 않으면 올림 계산
            }
        }
        return ans;
    }    
}