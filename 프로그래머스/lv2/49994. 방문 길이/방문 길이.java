import java.util.*;
class Solution {
    int x, y = 0; // 현재 좌표 x,y
    boolean isMoved;
    
    public int solution(String dirs) {
        Set<String> route = new HashSet<>(); // 중복 경로 체크를 위한 HashSet
        for(char dir : dirs.toCharArray()){
            StringBuilder beforeM = currentXY();
            
            move(dir); 
            
            if(isMoved){ // 이동했을 경우에만 나머지작업 처리             
                StringBuilder afterM = currentXY();
                
                // 동일한 경로를 반대방향으로 지난 적 있는지 체크 후, 역방향으로도 안 지난 경우에만 해시셋에 추가
                boolean pr = passedReverse(beforeM, afterM, route); 
                if(!pr){ 
                    beforeM.append(afterM);
                    route.add(beforeM.toString());
                }
            }
        }
        return route.size();
    }
    
    void move(char dir){
        isMoved = true;
        if(dir=='U'&&y<5){y++;}
        else if(dir=='D'&&y>-5){y--;}
        else if(dir=='R'&&x<5){x++;}
        else if(dir=='L'&&x>-5){x--;}
        else{isMoved=false;}
    }
    
    StringBuilder currentXY(){
        StringBuilder M = new StringBuilder(); 
        M.append(x); M.append(y);
        return M;
    }
    
    boolean passedReverse(StringBuilder beforeM, StringBuilder afterM, Set<String> route){
        StringBuilder temp = new StringBuilder(afterM);
        temp.append(beforeM);
        return route.contains(temp.toString());
    }
}