from math import *
def solution(left, right):
    return sum([i if sqrt(i)%1>0 == 0 else -i for i in range(left,right+1)])