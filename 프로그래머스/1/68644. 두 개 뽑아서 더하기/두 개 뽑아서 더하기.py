def solution(numbers):
    answer = []
    ranged = range(len(numbers))
    for i in ranged:
        for j in ranged:
            if i != j:
                answer.append(numbers[i]+numbers[j])
    return sorted(list(set(answer)))