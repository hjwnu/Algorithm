def solution(num):
    count = 0
    while num > 1:
        if num%2 == 0: 
            num /= 2
            count+=1
        else: 
            num = num*3 + 1
            count+=1
        if count > 500 : return -1
    return count