// Shift을(를) 두 번 눌러 전체 검색 대화상자를 열고 'show whitespaces'를 입력한 다음,
// Enter를 누르세요. 그러면 코드 내에서 공백 문자를 확인할 수 있습니다.
public class Main {
    public static void main(String[] args) {
        System.out.println(divisor(100));
        }
    public static int divisor(int num) {
        int cnt = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (num / i != i) {
                    cnt += 2;
                } else if(num/i==i){
                    cnt++;
                }
            }

        }
        return cnt;
    }
    }