class Solution {
    static boolean[] prime = new boolean[3001];
    public int solution(int[] nums) {
        int answer = 0;
        isPrime(prime);
        for(int i =0; i < nums.length;i++){
            for(int j = i+1; j < nums.length;j++){
                for(int k = j+1; k < nums.length;k++){
                    if(!prime[nums[i]+nums[j]+nums[k]]){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    
    public void isPrime(boolean[] prime){
        for(int i = 2; i < 3001;i++){
            if(prime[i]){continue;}
            for(int j=2*i;j<=3000; j+=i) {
            prime[j] = true;
        }
        }
    }
}