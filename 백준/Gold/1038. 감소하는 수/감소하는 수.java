import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(sol(a));
    }
    /*
    0,1,2,3,4,5,6,7,8,9 => 10개의 숫자중 임의의 숫자 n개를 골랐을 때, 감소하는 수의 형태로 정렬하는 경우의 수는 1가지.
    다시 말하면,  {0,1,2,3,4,5,6,7,8,9}의 부분집합의 개수와 동일하므로 2^10 - 1 = 1023개
    감소하는 수는 총 1023개이다. 0~1022
    */
    public static long sol(int a) {
    if (a>1022){return -1;}
    if (a <10){return a;}


        Queue<Long> q = new LinkedList<>();
        int cnt=-1; // 입력값까지만 계산하도록 계산시마다 카운트
        for(long i =0 ; i <10;i++){   // 0~9 저장
            q.add(i); cnt++;
        }
        long ans =0;
        while(cnt<a){            // 카운트가 입력값의 순서보다 아직 앞일 경우 반복.
            long n = q.poll(); // 큐 맨앞을 뽑는다.
            long temp = n%10; //  뽑힌 수의 일의자리 수를 저장한다.

            for(long i =0 ; i <temp;i++){ // 뽑힌 수의 일의자리수보다 작은 숫자까지만 더하고, 다음 큐로 넘긴다.
                q.add(n*10 + i); cnt++;
                if(cnt==a){ ans = n*10+i; break;}
            }

        }
    return ans;
    }
}
