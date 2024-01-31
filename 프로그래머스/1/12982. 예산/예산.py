def solution(d, budget):
    origin = len(d)
    for i in sorted(d):
        if budget - i < 0 :
            break
        budget -= i
        d.remove(i)
    return origin - len(d)