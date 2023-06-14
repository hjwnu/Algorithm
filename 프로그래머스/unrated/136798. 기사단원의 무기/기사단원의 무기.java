class Solution {
    public int solution(int number, int limit, int power) {
        int result= 0;
        for(int i =1; i <=number; i++){
            int a = divisor(i);
            if(a>limit) {result += power;}
            else{ result += a;}
        }
        return result;
    }
    
     public int divisor(int num) {
        int cnt = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {                
                if (num / i != i) {cnt += 2;} 
                else if(num/i==i){cnt++;}
            }
        }
        return cnt;
    }
}