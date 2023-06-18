import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt =0;
        int zero =0;
        List<Integer> temp = new ArrayList<>();
        for(int i =0 ; i < lottos.length;i++){
            if(lottos[i]==0){zero++;}
            else{
                for(int j = 0; j<lottos.length;j++){
                    if(lottos[i]==win_nums[j]){cnt++;}
        }
            }
        }
          
        int max = zero==0&&cnt==0? 1:zero+cnt;
        int min = cnt==0? 1:cnt;
        return new int[]{7-max, 7-min};
    }
}