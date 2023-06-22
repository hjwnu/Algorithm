import java.util.*;

class Solution {
    public static int solution(int[][] sizes) {
        int[] max = max(sizes);
        for(int i =0; i < sizes.length;i++){
            // if(max[0]>max[1]){
                if(sizes[i][0]<sizes[i][1]){
                    int temp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = temp;
                }
        //     }
        //     if(max[0]<max[1]){
        //         if(sizes[i][0]>sizes[i][1]){
        //             int temp = sizes[i][0];
        //             sizes[i][0] = sizes[i][1];
        //             sizes[i][1] = temp;
        //         }
        //     }
        }
        max = max(sizes);
        return max[0]*max[1];
    }

    //     int[] max = new int[4];
    //     while(true) { // 최소가 될때까지 반복.
    //         max = max(sizes);//바뀌기 전 size =temp
    //         if (max[0] < max[1]) { // 가로 최댓값이 세로보다 낮다면 바꾸고,
    //             if(sizes[max[2]][0]<=sizes[max[2]][1]){break;} 
    //             int temp = sizes[max[2]][0];
    //             sizes[max[2]][0] = sizes[max[2]][1];
    //             sizes[max[2]][1] = temp;
    //         } else if (max[0] > max[1]) { // 세로 최댓값이 가로보다 낮다면 바꾼다.
    //             if(sizes[max[3]][0]>=sizes[max[3]][1]){break;}
    //             int temp = sizes[max[3]][0];
    //             sizes[max[3]][0] = sizes[max[3]][1];
    //             sizes[max[3]][1] = temp;
    //         }
    //     }
    //     // 가로 세로 맥스를 곱하여 리턴.
    //     return max[0]*max[1];
    // }
    public static int[] max(int[][] sizes){
        int[] max = new int[2];
        for(int i= 0; i < sizes.length;i++){
            if(sizes[i][0]>max[0]) {max[0] = sizes[i][0];}
            if(sizes[i][1]>max[1]) {max[1] = sizes[i][1];}
        }
        return max;
    }
}