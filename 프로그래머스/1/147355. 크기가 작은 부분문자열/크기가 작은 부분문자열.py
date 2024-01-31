def solution(t, p):
    count = 0
    temp = ''
    for i in range(len(t)-len(p)+1):
        for j in range(i,i+len(p)):
            temp += str(t[j])
            if len(temp)==len(p):
                if int(temp) <= int(p):
                    count +=1
                temp = ''
    return count