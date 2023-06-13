package Programmers.lv1;

import javax.swing.text.SimpleAttributeSet;
import java.text.SimpleDateFormat;
import java.util.*;

public class PICollectionValidityPeriod {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }

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
// 연월일을 각각 직접 비교하기 위해 데이터를 가공하는 과정에서의 오류 발생가능성과 코드 비효율을 개선할 필요를 느꼈다.
//    public static int[] solution2 (String today, String[] terms, String[] privacies){
//        String[][] period = new String[terms.length][2];
//        int idx =0;
//        for( String a : terms){
//            period[idx] = a.split(" "); idx++;
//        }
//        String[][] sort = new String[privacies.length][2];
//        idx =0;
//        for( String b : privacies){
//            sort[idx] = b.split(" "); idx++;
//        }
//
//        for(int i =0; i <period.length;i++){
//            for(int j=0; j<sort.length;j++){
//                if(sort[j][1].equals(period[i][0])){
//                    sort[j][1] = period[i][1];
//                }
//            }
//        }
////        System.out.println(Arrays.toString(period[0]));
////        System.out.println(Arrays.toString(sort[0]));
//        String[][] DATE = new String[sort.length][3];
//
//        for(int i = 0; i < sort.length;i++ ){
//            DATE[i] = sort[i][0].split("\\.");
//        }
//        int[] year= new int[sort.length];
//        int[] month= new int[sort.length];
//        int[] day= new int[sort.length];
//        for(int i =0; i < sort.length;i++) {
//            year[i] = Integer.parseInt(DATE[i][0]);
//            month[i] =Integer.parseInt(DATE[i][1]);
//            day[i] = Integer.parseInt(DATE[i][2]);
//        }
////        System.out.println(Arrays.toString(year));
////        System.out.println(Arrays.toString(month));
//        List<Integer> result = new ArrayList<>();
//        for(int i =0; i < year.length;i++) {
//            int Today = dateToInt(today);
//            else{month[i] = month[i]+Integer.parseInt(sort[i][1]);}
//            if(Today[0]<year[i]){continue;}
//            else if(Today[0]>year[i]){result.add(i+1);}
//            else{
//                if(Today[1]<month[i]){continue;}
//                else if(Today[1]>month[i]){ result.add(i+1);}
//                else{
//                    if(Today[2]>=day[i]) {result.add(i+1);}
//                }
//            }
//        }
//        int[] Result = new int[result.size()];
//        idx =0;
//        for(int i : result){
//            Result[idx] = i; idx++;
//        }
//        return Result;
//    }