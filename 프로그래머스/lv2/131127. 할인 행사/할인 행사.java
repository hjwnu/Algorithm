import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantedMap = new HashMap<>();
        for(int i =0; i < want.length;i++){wantedMap.put(want[i],number[i]);} // 원하는 물건과 수량 저장
        
        for(int i = 0; i < 10; i++){
            String dc = discount[i];
            // 할인상품이 원하는 목록에 있다면, 차감 
            if(wantedMap.containsKey(dc)){wantedMap.put(dc,wantedMap.get(dc)-1);} 
        }
        int lastDCDay = 9; // 회원가입 시 할인 마지막 날.
        int AllDC= 0; // 모든상품을 할인받을 수 있는 가입일의 갯수

        while(true){
            if(allDiscount(wantedMap)){AllDC++;} // 모든상품을 할인받을 수 있는지 체크
            if(++lastDCDay == discount.length){break;} // 회원가입날을 하루씩 옮기면서 배열범위 체크 
            
            String before1st = discount[lastDCDay-10];
            String dayLast = discount[lastDCDay];
            
            // 회원가입 전날 상품 원상복귀
            if(wantedMap.containsKey(before1st)){wantedMap.put(before1st,wantedMap.get(before1st)+1);} 
            
            // 할인 마지막 날 상품 반영
            if(wantedMap.containsKey(dayLast)){ wantedMap.put(dayLast,wantedMap.get(dayLast)-1);}
        }
        
        return AllDC;
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