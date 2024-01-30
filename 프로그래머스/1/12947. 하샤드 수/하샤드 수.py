def solution(x):
    numberSum = sum([int(i) for i in str(x)])
                    
    return x%numberSum==0