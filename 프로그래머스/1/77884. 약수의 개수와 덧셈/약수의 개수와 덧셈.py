from math import *
def solution(left, right):
    return sum([int(i) if sqrt(i)%1>0 == 0 else -1*int(i) for i in range(left,right+1)])