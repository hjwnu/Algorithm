import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer= 0;
        int lidx = 0 ; int ridx = people.length-1;
        while(lidx<ridx){
            if(people[lidx]+people[ridx] <=limit) {
                answer++;
                lidx++;
                ridx--;
            }
            else{ridx--;}
        }
        return people.length-answer;
    }
}