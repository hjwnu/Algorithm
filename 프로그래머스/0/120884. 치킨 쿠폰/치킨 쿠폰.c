#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int chicken) {
    int answer = 0;
    while (true){
        int coupon = chicken / 10;
        if(coupon >= 1) {
            answer += coupon;
            chicken -= coupon * 9;
        } else break;
    }
    return answer;
}