class Solution{
    public int solution(int n, int a, int b){
        int maxpow = 0; int mid = n; 
        
        while(n>1){n /=2; maxpow++;} // 2의 지수 구하기
        
        if(a>b){ int tmp = a; a= b; b=tmp;} // 항상 b가 큰 수
        
        int answer = maxpow; 
        
        for(int i =0 ; i < maxpow; i++){
            mid /= 2;
            if(a<=mid&&b>mid){break;} //mid값 기준으로 나눠져있다면 반환 해당 지수 반환
            if(b<=mid){ answer--;} // n/2 기점으로 왼쪽이라면, 오른쪽 블럭을 지우고 탐색
            if(a>mid) {answer --; a -= mid; b -= mid;} // mid 값 기준 오른쪽이면, 왼쪽 블럭을 지우고 탐색
        }
        return answer;
    }
}
// 다른 블럭이면, 형성된 모든 단계 거쳐야 함.
// 같은 블럭에 있다면, 다른 블럭은 배제하고 계산해도 동일함.