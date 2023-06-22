import java.util.*;

class Solution {
    public static int solution(int[][] sizes) {
        int[] max = max(sizes);
        for(int i =0; i < sizes.length;i++){
                if(sizes[i][0]<sizes[i][1]){ // 모든 긴 길이를 가로로 몰빵
                    int temp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = temp;
                }
        }
        max = max(sizes);
        return max[0]*max[1];
    }

    public static int[] max(int[][] sizes){
        int[] max = new int[2];
        for(int i= 0; i < sizes.length;i++){
            if(sizes[i][0]>max[0]) {max[0] = sizes[i][0];}
            if(sizes[i][1]>max[1]) {max[1] = sizes[i][1];}
        }
        return max;
    }
}
// 가로, 세로 중 긴것 중에 가장 긴 것 * 가로,세로 중 짧은 것 중에 가장 긴 것...
// class Solution {
//     public int solution(int[][] sizes) {
//         int length = 0, height = 0;
//         for (int[] card : sizes) {
//             length = Math.max(length, Math.max(card[0], card[1]));
//             height = Math.max(height, Math.min(card[0], card[1]));
//         }
//         int answer = length * height;
//         return answer;
//     }
// }