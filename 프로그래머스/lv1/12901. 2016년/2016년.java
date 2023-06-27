class Solution {
    public String solution(int a, int b) {
        String[] day = new String[]{"THU","FRI","SAT","SUN","MON","TUE","WED"}; 
        int[] daysum = new int[]{31, 29, 31,30, 31, 30, 31,31, 30, 31, 30, 31};
        int cal=0;
         { for( int i =0; i <a-1;i++){cal += daysum[i];}}
         return day[(cal+b) % 7];
        
    }
}
