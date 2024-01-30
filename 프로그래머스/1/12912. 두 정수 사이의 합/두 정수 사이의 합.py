def solution(a, b):
    if b<a:
        temp = a
        a = b
        b = temp
        
    return sum([int(i) for i in range(a,b+1)])