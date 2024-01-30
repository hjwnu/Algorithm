from math import *
def solution(n):
    answer = 0
    while n >= 1: 
        answer += int(n%10)
        n = floor(n/10)
        
    return answer