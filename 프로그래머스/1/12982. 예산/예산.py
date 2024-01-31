def solution(d, budget):
    count = 0
    for i in sorted(d):
        if budget - i < 0 :
            break
        budget -= i
        count += 1
    return count