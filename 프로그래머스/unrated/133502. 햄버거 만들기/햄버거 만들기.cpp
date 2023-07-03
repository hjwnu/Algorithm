#include <vector>
#include <stack>

using namespace std;

int solution(vector<int> ingredient) {
    int cnt = 0;  // 포장한 햄버거의 개수
    stack<int> st;  // 재료를 저장할 스택

    for (int i = 0; i < ingredient.size(); i++) {
        st.push(ingredient[i]);
        if (st.size() >= 4 && st.top() == 1) {
            int top1 = st.top(); st.pop();
            int top2 = st.top(); st.pop();
            int top3 = st.top(); st.pop();
            int top4 = st.top(); st.pop();
            if (top2 == 3 && top3 == 2 && top4 == 1) {
                cnt++;
            }
            else{st.push(top4); st.push(top3); st.push(top2); st.push(top1);}
        }
    }

    return cnt;
}