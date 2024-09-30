class Solution {
    public int solution(int[] arr) {
        int count = 0;
        while(true){
            int changeCount = 0;
            for(int i = 0; i < arr.length; i++){
                int changedNumber = work(arr[i]);
                if(arr[i] != changedNumber){
                    changeCount++;
                }
                arr[i] = changedNumber;
            }
            if(changeCount == 0){
                break;
            }
            count++;
        }
        return count;
    }
    
    public int work(int number){
        if(number >= 50 && number%2==0){
            return number/2;
        }
        else if(number < 50 && number%2==1){
            return number*2+1;
        } else {
            return number;
        }
    }
}