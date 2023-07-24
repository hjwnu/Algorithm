import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        /* 최대 곱을 알기 위해선, 산술기하 평균을 이용하면 된다.
        최대곱에서의 각 수는 산술평균값일 때 최댓값이다.
        ex) 3, 18: 18/3 >= sqrt(5*6*7)==sqrt(210), 18/3 >= sqrt(6*6*6)==sqrt(216)
        s의 평균을 구할 수 없으면, 최대곱은 존재할 수 없다. */
        if(n>s) { return new int[]{-1};} 
        
        int[] ans = new int[n];
        int idx =0;
        while(n>0){
        /* 만약 산술평균 값이 정수가 아니라면, 소수점 이하의 수를 적절히 분배해야 한다.
        ex) 두 수를 더한 수가 9라면 9/2>=Math.sqrt(4.5 * 4.5)일 때 최대곱. (산술평균값인 4.5일 때 최대곱) 
        정수로 나누어야 하므로 4와 5로 나뉨
            
        이는 전체 수(s)에서 산술평균값(avr)을 뺀 수 = s - avr에서 다시 산술 평균을 구하는 방식으로 대체할 수 있다.
        이 때, 숫자의 개수(n, 산술평균의 분모)도 1개 줄여야 한다.
        */
            int avr = s/n; 
            ans[idx++] = avr;
            s -= avr; n--; 
        }
        
        Arrays.sort(ans);
        return ans;
    }
}