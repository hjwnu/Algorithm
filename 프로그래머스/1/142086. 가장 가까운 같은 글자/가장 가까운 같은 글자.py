def solution(s):
    answer = []
    dictionary = {}
    for i in range(len(s)):
        if s[i] not in dictionary:
            dictionary[s[i]] = i
            answer.append(-1) 
        else:
            index = dictionary[s[i]]
            answer.append(i - index)
            dictionary[s[i]] = i
    return answer
