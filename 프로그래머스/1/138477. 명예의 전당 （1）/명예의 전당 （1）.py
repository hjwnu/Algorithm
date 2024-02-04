def solution(k, score):
    answer = []
    a=[]
    for i in score:
        a.append(i)
        a.sort(reverse=True)
        if len(a)>k:
            del a [-1]
        answer.append(min(a))
    return answer