import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] curL = findStart(park); // 시작 위치 찾기
        
        for(int i =0 ; i < routes.length;i++){
            String[] temp = routes[i].split(" ");
            
            // 장애물,공원크기 감안하며 지정방향으로 이동거리만큼 이동
            curL = move(park, temp[0], Integer.parseInt(temp[1]), curL); 
        }
        return curL;
    }
    
    public int[] findStart(String[] park){
        int[] curL = {0,0};
        for(int i =0; i < park.length;i++){
            for(int j =0; j < park[i].length();j++){
                if(park[i].charAt(j)=='S'){  
                    curL = new int[]{i,j};
                }
            }
        }
        return curL;
    }
    
    public int[] move(String[] park, String direction, int distance, int[] currentLocation){
        int EW = currentLocation[1]; int EWLimit = park[0].length()-1;
        int SN = currentLocation[0]; int SNLimit = park.length-1;
        
        boolean disturb = false; boolean limitOver = false;
        
        int cnt =0; 
        
        while(cnt < distance){
            switch(direction){
                case "E" : EW++; cnt++; break;
                case "W" : EW--; cnt++; break;
                case "S" : SN++; cnt++; break;
                case "N" : SN--; cnt++; break;
            }
            if(EW>EWLimit||SN>SNLimit||EW<0||SN<0){limitOver = true; break;} // 공원크기 넘었으면 체크
            else if(park[SN].charAt(EW)=='X'){disturb= true; break;} // 장애물 있었으면 체크
        }
        
        // 체크되었다면 기존위치 반환, 아니라면 이동한 위치 반환
        return (disturb||limitOver)? currentLocation : new int[]{SN,EW}; 
    }
}