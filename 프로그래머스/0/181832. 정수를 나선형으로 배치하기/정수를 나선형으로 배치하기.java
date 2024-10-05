class Solution {
    public int[][] solution(int n) {
         int[][] answer = new int[n][n];
        Boolean isLToR = true;
        Boolean isUToD = null;

        int count = 1;
        int hIdx = 0;
        int vIdx = 0;
        while(count <= n*n){
            if(answer[vIdx][hIdx] == 0){
                answer[vIdx][hIdx] = count;
                count++;
            }

            hIdx = getIndex(isLToR, hIdx);
            vIdx = getIndex(isUToD, vIdx);

            if((hIdx >= n || hIdx <0) || (vIdx >= n || vIdx < 0) || answer[vIdx][hIdx] != 0){
                hIdx = returnIndex(isLToR, hIdx);
                vIdx = returnIndex(isUToD, vIdx);

                if(isLToR == null){
                    if(isUToD){
                        isLToR = false;
                    } else {
                        isLToR = true;
                    }
                    isUToD = null;
                } else {
                    if(isLToR){
                        isUToD = true;
                    } else {
                        isUToD = false;
                    }
                    isLToR = null;
                }
                hIdx = getIndex(isLToR, hIdx);
                vIdx = getIndex(isUToD, vIdx);
            }
        }

        return answer;
    }

    public static int getIndex(Boolean direction, int index){
        return direction == null ? index : direction ? index+1 : index-1;
    }

    public static int returnIndex(Boolean direction, int index){
        return direction == null ? index : direction ? index-1 : index+1;
    }
}