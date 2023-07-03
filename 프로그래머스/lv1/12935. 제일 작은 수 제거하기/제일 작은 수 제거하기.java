class Solution {
    public int[] solution(int[] arr) {
        if(arr.length<=1) return new int[]{-1};
        int min= arr[0];
        int[] answer = new int[arr.length-1];
        for(int i : arr){ min = Math.min(i,min);}
        int idx = 0;
        for(int i =0; i < arr.length;i++){
            if(arr[i]==min) {continue;}
            else{answer[idx] = arr[i]; idx++;}
        }
        return answer;
}
}