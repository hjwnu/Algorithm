import java.util.Arrays;
class Solution {
    public int solution(int[] A, int[] B) {
        int maxScore = 0;
        
        Arrays.sort(A); // A 팀의 출전 순서를 오름차순으로 정렬
        Arrays.sort(B); // B 팀의 수를 오름차순으로 정렬
        
        int idxA = 0; // A 팀의 인덱스
        int idxB = 0; // B 팀의 인덱스
        
        while (idxA < A.length && idxB < B.length) {
            if (A[idxA] < B[idxB]) {
                maxScore++; // B 팀원이 이 경기에서 승점 획득
                idxA++; // 다음 A 팀의 숫자와 비교하기 위해 인덱스 증가
            }
            
            idxB++; // 다음 B 팀의 숫자와 비교하기 위해 인덱스 증가
        }
        
        return maxScore;
    }
}