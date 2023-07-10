import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {

//         double[] failRateArr = ; // 스테이지 별 실패율 저장.
        
        int[] answer = descSortStageNum(failureRate(stages, N),N); // 실패율 높은 순으로 스테이지 번호 정렬
        
        return answer;
    }
    
    
    
    public double[] failureRate(int[] stages, int N){
        //각 스테이지(=배열인덱스, 0번 인덱스 제외)에 머물러 있는 인원 수 세기
        int[] cnt = new int[N+1];
        for(int i =0 ; i < stages.length;i++){
           if(stages[i]!=N+1){ cnt[stages[i]]++;}
        }
        
        // 실패율 = (해당 스테이지에 머문 인원 수)/(남은 인원 수) 저장
        double[] ans = new double[N+1];
        double len = stages.length;
        for(int i =1 ; i < N+1; i++){
            len = len - cnt[i-1];
            if(len==0){ans[i]=0;}
            else{ans[i] = cnt[i]/len;}
        }
        return ans;
    }
    
    public int[] descSortStageNum(double[] failRateArr, int N){
        
        // 각 스테이지 번호와 실패율을 맵에 저장
        Map<Integer,Double> stageNum = new HashMap<>();
        for(int i =1; i < failRateArr.length;i++){
            stageNum.put(i,failRateArr[i]);
        } 
        
        // 오름차순 정렬 후, answer배열 앞에서부터 실패율 높은 순서대로 스테이지번호 저장.
        Arrays.sort(failRateArr);
        int[] answer = new int[N];
        for(int i =1; i < failRateArr.length;i++){
            int key = getKey(stageNum, failRateArr[failRateArr.length-i]);
            answer[i-1] = key;
            stageNum.remove(key); // 이미 기록된 스테이지는 제거하여 실패율이 같은 경우를 처리
        }
        
        return answer;
    }
    
    public  <K, V> K getKey(Map<K, V> map, V value) {
        // 찾을 hashmap 과 주어진 단서 value
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}