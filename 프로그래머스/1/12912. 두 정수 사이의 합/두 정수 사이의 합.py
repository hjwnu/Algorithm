def solution(a, b):
    if a<b:
        return sum([int(i) for i in range(a,b+1)])
    else: return sum([int(i) for i in range(a,b-1,-1)])