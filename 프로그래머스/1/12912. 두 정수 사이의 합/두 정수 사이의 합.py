def solution(a, b):
    if b<a:
        a, b = b, a
        
    return sum(range(a,b+1))