import java.util.*;
class Solution {
    public int solution(String dirs) {
        Set<String> route = new HashSet<>(); // 중복 경로 체크를 위한 HashSet
        int x = 0; int y = 0; // 현재 좌표 x,y
        
        for(char ch : dirs.toCharArray()){
            StringBuilder beforeM = new StringBuilder(); 
            beforeM.append(x); beforeM.append(y); // 이동 전 좌표
            
            boolean isMoved = true; // 이동했는지 체크
            if(ch=='U'&&y<5){y++;}
            else if(ch=='D'&&y>-5){y--;}
            else if(ch=='R'&&x<5){x++;}
            else if(ch=='L'&&x>-5){x--;}
            else{isMoved=false;}
            
             if(isMoved){ // 이동했을 경우에만 나머지작업 처리
                 
                StringBuilder afterM = new StringBuilder(); // 이동 후 좌표
                afterM.append(x); afterM.append(y);
                
                StringBuilder temp = new StringBuilder(afterM); // 동일한 경로를 역방향으로 지났는지 체크
                temp.append(beforeM);
                 
                if(!route.contains(temp.toString())){ 
                    beforeM.append(afterM);
                    route.add(beforeM.toString());
                }
            }
        }
        return route.size();
        }
}