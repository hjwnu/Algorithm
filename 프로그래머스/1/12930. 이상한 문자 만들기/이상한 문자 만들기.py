def solution(s):
    s = s.split(' ')
    answer = []
    for str in s:
        temp = ''
        for i in range(len(str)):
            if i%2==0:
                 temp += str[i].upper()
            else: temp += str[i].lower()
        answer.append(temp)
    return ' '.join(answer)