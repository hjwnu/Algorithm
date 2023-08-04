import java.util.*;
class Solution {
    public String solution(int n) {
        String[] otf = {"1","2","4"}; // 3진법변환과 동일함. 0,1,2 대신 1,2,4
        StringBuilder ans = new StringBuilder();
        while(n>0){
            n-= 1; // n=3이라면 "4"로 반환필요. n%3=0이므로, (n-1)%3 =2로 변환해야 함.
            ans.insert(0,otf[n%3]);
            n/=3;
        }   
        return ans.toString();
    }
}
    // String[] otf = {"4","1","2"};
//         StringBuilder ans = new StringBuilder();
//         List<Integer> qt = new ArrayList<>();
        
//         int a = n;
//         if(a%3==0){a -=3;}
//         qt = addList(a,qt);
        
//         for(int i : qt){
//             ans.insert(0,otf[i%3]);
//         }
//         ans.append(otf[n%3]);
//         return ans.toString();
//     }

//     public List<Integer> addList(int a, List<Integer> qt){
//         while( a > 3){
//                 a = a/3;
//                 qt.add(a);
//             }
//         return qt;
/*
1,2,4
11,12,14
21,22,24
41,42,44
111,112,114
121,122,124

1,2,3
4,5,6
7,8,9
10,11,12
13,14,15
16,17,18
*/