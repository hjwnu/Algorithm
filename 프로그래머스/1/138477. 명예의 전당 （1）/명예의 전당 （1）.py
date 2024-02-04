def solution(k, score):
    hall_of_fame = score[:k]
    range_ = range(k) if k < len(score) else range(len(score))
    answer = [min(hall_of_fame[:i+1]) for i in range_]
    
    if k > len(score):
        return answer
    
    for i in range(k,len(score)):
        if score[i] > min(hall_of_fame):
            hall_of_fame.remove(min(hall_of_fame))
            hall_of_fame.append(score[i])
        answer.append(min(hall_of_fame))
    return answer