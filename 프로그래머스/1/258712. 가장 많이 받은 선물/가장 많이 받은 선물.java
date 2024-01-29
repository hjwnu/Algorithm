import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> friendIdx = new HashMap<>();
        int friendLen = friends.length;
        for(int i = 0 ; i < friendLen; i++){
            friendIdx.put(friends[i], i);
        }
        int[][] giveAndTake = new int[friendLen][friendLen];
        int[] presentIdx = new int[friendLen];
        int[] curMonthPresent = new int[friendLen];
        for(int i = 0; i < gifts.length; i++){
            String[] temp = gifts[i].split(" ");
            int giver = friendIdx.get(temp[0]);
            int taker = friendIdx.get(temp[1]);
            giveAndTake[giver][taker]++;
            presentIdx[giver]++;
            presentIdx[taker]--;
        }
        for(int i = 0 ; i < friendLen; i++){
            for(int j = i+1; j < friendLen; j ++){
                if(i==j) continue;
                
                if((giveAndTake[i][j] == 0 && giveAndTake[j][i] == 0)
                  || giveAndTake[i][j] == giveAndTake[j][i]){
                    if(presentIdx[i] > presentIdx[j]) curMonthPresent[i]++;
                    else if(presentIdx[j] > presentIdx[i]) curMonthPresent[j]++;
                } else{
                    if(giveAndTake[i][j] > giveAndTake[j][i]) curMonthPresent[i]++;
                    if(giveAndTake[j][i] > giveAndTake[i][j]) curMonthPresent[j]++;
                } 
                    
                
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < friendLen; i++){
            max = Math.max(max, curMonthPresent[i]);
        }
        return max;
    }
}