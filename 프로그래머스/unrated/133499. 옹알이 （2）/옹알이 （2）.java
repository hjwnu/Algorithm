class Solution {
    public int solution(String[] babbling) {
        String[] babble = new String[]{"aya", "ye", "woo", "ma"};
        int ans=0;
        for(String str : babbling){
            ans = str.replaceAll("ayaaya|yeye|woowoo|mama","2")
                     .replaceAll("aya|ye|woo|ma","1")
                     .replaceAll("1","").length()==0? ans+1:ans;
        }
        return ans;
    }
}