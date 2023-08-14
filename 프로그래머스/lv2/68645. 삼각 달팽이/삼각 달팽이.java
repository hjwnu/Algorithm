import java.util.*;

class Solution {
    static List<int[]> triSnail = new ArrayList<>();
    public static int[] solution(int n) {
        if(n==1){return new int[]{1};}
        int nSum = n*(n+1) / 2;
        int[] ans = new int[nSum];
        fillFirstColumn(n);
        fillLastRow();
        fillLastColumn(n); // 외곽 채우기

        boolean column = true; // column방향으로 움직일때 true, row방향일때 false
        boolean xPlus = true; // 오른쪽 방향일땐 x좌표 plus -> true, 왼쪽 방향일땐 false
        boolean yPlus = true; // 아래 방향일땐 y좌표 plus -> true,  위 방향일땐 false
        int x = 1; int y =2;
        int start = triSnail.get(1)[1]+1;
        while(start < nSum+1){
            // if ( y >= n || y < 0 ) {
            //     column = false;
            //     if(y < 0){y++; yPlus = true;}
            //     else{y--; yPlus = false;}
            // }

            int[] tmp = triSnail.get(y);
            int len = tmp.length;


            if(column){
                if(triSnail.get(y)[x]!=0){
                    if(yPlus) {y--; x++; xPlus = true;} else {y++;  xPlus = false;}
                    column=!column; continue;
                }
                tmp[x] = start++;
                triSnail.set(y,tmp);
                if(yPlus) y++; else {y--; x--;}

            }
            else {
                if(triSnail.get(y)[x]!=0){
                    triSnail.set(y, tmp);
                    if(xPlus) {y--; x -=2; yPlus = false;} else { x++; y++; yPlus = true;}
                    column=!column; continue;
                }
                tmp[x] = start++;
                if(xPlus) x++; else x--;
            }
        }
        int idx =0;
        for(int i =0; i < triSnail.size();i++){
            for(int j = 0 ; j < triSnail.get(i).length;j++){
                ans[idx++] = triSnail.get(i)[j];
            }
        }

        return ans;
    }
    
   static void fillFirstColumn(int n){
        for(int i =0 ; i < n; i++){
            int[] tmp = new int[i+1];
            tmp[0] = i+1;
            triSnail.add(tmp);
        }
    }

    static void fillLastRow(){
        int[] last = triSnail.get(triSnail.size()-1); int idx=0;
        for(int i =last[0] ; i < last.length+last[0]; i++){
            last[idx] = i; idx++;
        }
        triSnail.remove(triSnail.size()-1);
        triSnail.add(last);
    }

    static void fillLastColumn(int n){
        int num = 2*n-1;
        for(int i = n - 2 ; i > 0 ; i--){
            int[] arr = triSnail.get(i);
            arr[arr.length-1]= ++num;
            triSnail.set(i, arr);
        }
    }
}