def solution(food):
    answer = '0'
    for i in range(len(food)-1,-1,-1):
        if i > 0 :
            num = str(i)*(int(food[i])//2)
            answer = num + answer + num
    return answer