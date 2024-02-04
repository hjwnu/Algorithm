def solution(a, b, n):
    answer = 0
    while a <= n :
        answer += n//a * b
        n = n%a + n//a *b        
    return answer