import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //남은 작업 진도 배열로 반환
        int[] rest = new int[speeds.length+1];
        for(int i =0 ; i < speeds.length;i++){
            double a = 100-progresses[i];
            double b = speeds[i];
            rest[i] = (int)Math.ceil(a/b);
        }
        rest[rest.length-1] = 100; // 마지막에 한번에 배포될 양을 계산할 수 있도록, 변수 범위 외의 임의의 상수 지정
        
        //앞에서부터 한번에 배포될 양 계산하여 리스트에 저장
        List<Integer> ansLi = new ArrayList<>();
        for(int i =1 ; i < rest.length;i++){
            if(rest[0]<rest[i]){
                ansLi.add(i);
                rest = Arrays.copyOfRange(rest, i,rest.length);
                i=0;
            }       
        }
        //리스트를 배열로
        int[] ans = new int[ansLi.size()];
        for(int i =0; i<ansLi.size();i++){
            ans[i] = ansLi.get(i);
        }
        return ans;
    }
}