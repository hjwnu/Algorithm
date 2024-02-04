def solution(k, score):
    if k > len(score):
        return [min(score[:i+1]) for i in range(len(score))]
    hall_of_fame = score[:k]
    answer = [min(hall_of_fame[:i+1]) for i in range(k)]
    for i in range(k,len(score)):
        if score[i] > min(hall_of_fame):
            hall_of_fame.remove(min(hall_of_fame))
            hall_of_fame.append(score[i])
        answer.append(min(hall_of_fame))
    return answer