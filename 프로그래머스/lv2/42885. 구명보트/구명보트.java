import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        
        // 최대 2명이므로, 보트는 혼자 타는 그룹과 둘이 타는 그룹으로만 이루어진다. 따라서 둘이 타는 그룹만 카운트하면 된다.
        Arrays.sort(people);
        int two= 0;
        int lIdx = 0 ; int rIdx = people.length-1;
        
        
        // 제일 무거운사람과 제일 가벼운사람이 함께 탈 수없다면, 제일 무거운사람은 무조건 혼자 타야한다. 이 친구는 혼자 태워 보내고, 그 다음 무거운 사람과의 검증을 진행한다.
        while(lIdx<rIdx){
            if(people[lIdx]+people[rIdx] >limit) {rIdx--;}  
            else{two++;lIdx++;rIdx--;} // 같이 탈 수 있는 그룹의 수 체크
        }
        return people.length-two; // 전체 수에서 2인보트의 수만큼 빼주면 1인보트+2인보트의 수가 된다.
    }
}