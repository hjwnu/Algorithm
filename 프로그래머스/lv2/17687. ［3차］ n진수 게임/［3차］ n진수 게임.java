class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb= new StringBuilder();
        for(int i =0; i < t*m; i++){
            sb.append(Integer.toString(i, n).toUpperCase());
        }
        StringBuilder ans = new StringBuilder();
        for(int i = p-1; i < t*m;i+=m){
            ans.append(sb.charAt(i));
        }
        
        return ans.toString();
    }
}