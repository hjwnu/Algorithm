import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] numCount = new int[10];

        for(int i =0; i<Y.length(); i++) {
        int num = Y.charAt(i)-48;
            numCount[num]++; // 각 숫자갯수 카운팅 과정
        }
        List<Character> ansTemp = new ArrayList<>();
        for(int i =0; i<X.length(); i++) {
            int num = X.charAt(i)-48;
            if(numCount[num]>0) {numCount[num]--; ansTemp.add(X.charAt(i));} // Y에 있는 숫자면 하나 줄이고 정답에 추가
        }
        
        Collections.sort(ansTemp);
        for(int i = ansTemp.size()-1;i >=0; i--){
            sb.append(ansTemp.get(i));
        }
    
        return sb.length() == 0 ? "-1" : sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}

/*
시간초과 됨. 정렬 or 반복문 내 리스트삭제가 원인인것으로 추측

public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        char[] xarr = X.toCharArray();
        Arrays.sort(xarr);
        
        List<Character> ylist = new ArrayList<>();
        for(int i =0 ; i < Y.length();i++){
            ylist.add(Y.charAt(i));
        }
        
        for(int i = xarr.length-1 ; i >= 0 ; i--){
            if(ylist.contains(xarr[i])){
                sb.append(xarr[i]); ylist.remove(Character.valueOf(xarr[i]));
            }
        }
        return sb.length()==0? "-1": sb.charAt(0)=='0'?"0":sb.toString() ;
    }
    
*/