class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey != 0) {
			int one = storey % 10; //  1의 자리
			int ten = (storey / 10) % 10; // 10의 자리

			if (one > 5) { //  올림
				answer += (10 - one);
				storey += 10;
			} else if (one == 5) { // 10의 자리가 5이상이면 올림, 5미만이면 내림
				answer += one;
				storey += (ten < 5 ? 0 : 10);
			} else { //  내림
				answer += one;
			}

			storey /= 10;
		}
        
        return answer;
    }
}