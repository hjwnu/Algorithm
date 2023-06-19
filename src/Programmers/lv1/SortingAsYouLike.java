package Programmers.lv1;

import java.util.Arrays;

public class SortingAsYouLike {
    public static void main(String[] args) {
        String[] a = {"hcng", "ja", "wbn", "zabaa","xabaa"};
        System.out.println(Arrays.toString(solution(a,1)));
    }
    public static String[] solution(String[] strings, int n) {
        String[] temp = new String[strings.length];
        for (int i =0 ; i < strings.length;i++){
            temp[i] = strings[i].substring(n) + strings[i].substring(0,n);
        }
        Arrays.sort(temp);
        for(int i =0; i< temp.length;i++){
            temp[i] = temp[i].substring(temp[i].length()-n)+temp[i].substring(0,temp[i].length()-n);
        }
        return temp;
    }

}
