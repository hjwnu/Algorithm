import java.util.*;
class Solution {
    int solution(int[][] land) {
        for(int i=1; i <land.length;i++){
            for(int j = 0; j < 4; j++){
                land[i][j] += findMax(land[i-1],j);
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i : land[land.length-1]){
            max = Math.max(max,i);
        }
        return max;
    }
    
    public int findMax(int[] tmp, int idx){
        int max = Integer.MIN_VALUE;
        for(int i =0 ; i< tmp.length; i++){
            if(i==idx){continue;}
            else{max = Math.max(max,tmp[i]);}
        }
        return max;
    }
}    
    /*
    맨 첫행에서 최댓값을 구하고, 그 다음행의 최댓값을 구하는 그리디형식으로 구현했다.
    다만, 이러한 방식으로는 아래 케이스를 맞출 수 없다.
    
    입력값 〉	[[0, 1, 1, 10], [0, 1, 1, 100]]
    기댓값 〉	101
    실행 결과 〉	실행한 결괏값 11이 기댓값 101과 다릅니다.
    
    int solution(int[][] land) {
        int idx = 0; int ans =0; int maxIdx = -1;
        
        for(int i =0 ; i < land.length;i++){
            List<Integer> tmp = new ArrayList<>();
            for(int a : land[i]){tmp.add(a);}
            int max = FindMax(tmp,maxIdx); ans += max;
            maxIdx = tmp.indexOf((Integer)max);
          }
        return ans;
    }
    
    public int findMax(List<Integer> tmp, int maxIdx){
        int max = Integer.MIN_VALUE;
        for(int i =0 ; i< tmp.size() ;i++){
            if(i==maxIdx){continue;}
            else{max = Math.max(max,tmp.get(i));}
        }
        return max;
    }
    */