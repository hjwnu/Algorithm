class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];       
        for(int i = 0; i < n; i++) {
            String bi = Integer.toBinaryString(arr1[i] | arr2[i]);
            bi = "0".repeat(n - bi.length()) + bi;
            answer[i] = bi.replaceAll("1", "#").replaceAll("0", " ");
        }
        return answer;
    }
}