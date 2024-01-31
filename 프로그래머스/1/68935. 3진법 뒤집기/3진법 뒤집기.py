def solution(n):
    answer = ''
    while n >= 1:
        answer += str(n%3) 
        n //= 3
    
    return int(answer,3)