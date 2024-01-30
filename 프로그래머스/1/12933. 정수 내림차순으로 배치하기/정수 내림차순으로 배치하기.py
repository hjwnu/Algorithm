def solution(n):
    answer = ''
    for i in reversed(sorted(str(n))):
      answer += i  
    return int(answer)