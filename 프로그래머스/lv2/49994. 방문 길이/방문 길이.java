import java.util.*;
class Solution {
    public int solution(String dirs) {
        Set<String> route = new HashSet<>();
        int x = 5; int y = 5;
        for(char ch : dirs.toCharArray()){
            StringBuilder beforeM = new StringBuilder();
            StringBuilder afterM = new StringBuilder();
            beforeM.append(x); beforeM.append(y);
            boolean isMoved = true;
            
            if(ch=='U'&&y<10){y++;}
                else if(ch=='D'&&y>0){y--;}
                else if(ch=='R'&&x<10){x++;}
                else if(ch=='L'&&x>0){x--;}
                else{isMoved=false;}
            
             if(isMoved){
                afterM.append(x); afterM.append(y);
                String temp = afterM.toString()+beforeM.toString();
                beforeM.append(afterM);
                if(!route.contains(temp.toString())){
                    route.add(beforeM.toString());
                }
            }
        }
        return route.size();
        }
}