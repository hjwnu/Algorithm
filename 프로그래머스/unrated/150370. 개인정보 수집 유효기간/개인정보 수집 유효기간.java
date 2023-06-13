import java.util.*;
class Solution {
   public static int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> term = new HashMap<>();
        for (String str : terms) {
            term.put(str.substring(0,1), Integer.valueOf(str.substring(2)) * 28);
        }
        int[] period = new int[privacies.length];

        for(int i = 0; i < privacies.length;i++){
            period[i] = dateToInt(privacies[i].substring(0,10))+term.get(String.valueOf(privacies[i].charAt(11)));
        }
        for( int i : period){
//            System.out.println(i);
        }
        int Today = dateToInt(today);
        List<Integer> result = new ArrayList<>();
        for( int i =0; i < period.length;i++){
            if( period[i] <= Today) result.add(i+1);
        }
//        System.out.println(result);
        int[] ans = new int[result.size()];
        int idx= 0;
        for( int i : result){
            ans[idx] = i; idx++;
        }
        return ans;
    }

    public static int dateToInt(String date){
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        int Date = year*28*12+month*28+day;
        return Date;
    }
}