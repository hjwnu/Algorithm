from math import *
def solution(n):
    sqrt_n = sqrt(n)
    if sqrt_n-int(sqrt_n) == 0 :
        return pow(int(sqrt_n)+1,2)
    else: 
        return -1