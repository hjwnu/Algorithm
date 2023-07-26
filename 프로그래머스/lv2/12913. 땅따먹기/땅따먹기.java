import java.util.*;
class Solution {
    int solution(int[][] land) {
        for(int i=1; i <land.length;i++){
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2],land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2],land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1],land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1],land[i-1][2]));
        }
        
        int max = Integer.MIN_VALUE;
        for(int i : land[land.length-1]){
            max = Math.max(max,i);
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
    
    public int FindMax(List<Integer> tmp, int maxIdx){
        int max = Integer.MIN_VALUE;
        for(int i =0 ; i< tmp.size() ;i++){
            if(i==maxIdx){continue;}
            else{max = Math.max(max,tmp.get(i));}
        }
        return max;
    }
    */