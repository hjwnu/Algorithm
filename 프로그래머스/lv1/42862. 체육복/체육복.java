import java.util.*;
class Solution {
     public static int solution(int n, int[] lost, int[] reserve) {
         Arrays.sort(lost);
         Arrays.sort(reserve);
         int def = n - lost.length;
         // 여벌 O 학생이 도난 당했을 경우. 인원수 카운트 후 reserve 제외. 체육 참여 O
         int selfRent =0;
             for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if (lost[i] == reserve[j]) {selfRent++; lost[i] = -2; reserve[j] = -2; break;}
                }
            }
         if(lost.length==selfRent) return n; // 도난당한 모든 학생이 여벌을 갖고있었다면 그대로 총인원 리턴. (1 <= 도난인원)
         if(reserve.length==selfRent) return n-lost.length+selfRent; // 여벌 가진 모든 학생이 도난 당했다면 총인원 - 여벌 없는 도난 당한 학생 리턴 
         
         // 여벌 X 학생이 도난 당했을 경우, 렌탈 가능 케이스 카운트 후 reserve 제외.체육 참여 O
         int rent=0;
         for(int i =0; i < lost.length;i++){
             for(int j =0; j<reserve.length;j++){
             if(reserve[j]==lost[i]+1||reserve[j]==lost[i]-1){reserve[j] = -2; rent++; break;}
         }
     }
         return def+rent+selfRent;
     }
}