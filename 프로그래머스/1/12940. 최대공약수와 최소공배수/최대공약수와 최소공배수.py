def solution(n, m):
    answer = []
    if n > m :
        n, m = m, n
    for i in range(n+1,0,-1):
        if n%i==0 and m%i==0:
            answer.append(i)
            break
    
    answer.append(n*m/answer[0])
    return answer