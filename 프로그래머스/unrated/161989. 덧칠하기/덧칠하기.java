import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int solution(int n, int m, int[] section) {

        int count = 1;
        int a = section[0];
        for(int i = 0; i < section.length;i++){
        if(section[i]-a>=m){
            count++; 
            a = section[i];
        }
        }
        
        return count;
    }
}