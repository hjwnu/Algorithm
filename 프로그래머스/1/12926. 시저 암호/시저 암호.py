def solution(s, n):
    lower = 'abcdefghijklmnopqrstuvwxyz'
    upper = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    answer = ''
    for ch in s:
        if ch.islower():
            idx = lower.index(ch)
            answer += lower[(idx+n)%26]
        elif ch.isupper():
            idx = upper.index(ch)
            answer += upper[(idx+n)%26]
        else:
            answer += ' '
    return answer