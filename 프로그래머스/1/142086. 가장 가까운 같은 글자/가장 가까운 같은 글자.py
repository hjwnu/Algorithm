def solution(s):
    answer = []
    dictionary = {}
    for i in range(len(s)):
        if s[i] not in dictionary:
            dictionary[s[i]] = i
            answer.append(-1)  # 리스트에 값을 추가합니다.
        else:
            index = dictionary[s[i]]
            answer.append(i - index)  # 현재 인덱스와 마지막 출현 인덱스의 차이를 계산하여 추가합니다.
            dictionary[s[i]] = i  # 문자의 마지막 출현 위치를 업데이트합니다.
    return answer
