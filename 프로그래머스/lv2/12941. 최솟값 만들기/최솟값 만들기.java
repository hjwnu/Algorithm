import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int len = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i =0; i < A.length;i++){
            answer += A[i]*B[len-1-i];
        }
        return answer;
    }
}