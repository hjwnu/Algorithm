import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
     int cnt = 0;  // 포장한 햄버거의 개수
        Stack<Integer> st = new Stack<>();  // 재료를 저장할 스택

        for (int i = 0; i < ingredient.length; i++) {
            st.push(ingredient[i]);
            if (st.size() >= 4
                    && st.peek() == 1
                    && st.get(st.size() - 2) == 3
                    && st.get(st.size() - 3) == 2
                    && st.get(st.size() - 4) == 1
            ) {
                st.pop();   st.pop();   st.pop();  st.pop(); cnt++;
            }
        }

        return cnt;
    }
}
