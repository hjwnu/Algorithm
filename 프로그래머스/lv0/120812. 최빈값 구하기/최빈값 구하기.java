import java.util.Arrays;
class Solution {
    public int solution(int[] array) {
        int[] cnt = new int[1000];
        
        for( int i : array){
            cnt[i]++;
        }
        int max =0; int midx =0;
        
        for(int i =0 ; i < cnt.length;i++){
            if(cnt[i]>max) {max = cnt[i]; midx = i;}
        }
        
        Arrays.sort(cnt);
        return max == cnt[cnt.length-2]? -1 : midx;
    }
}