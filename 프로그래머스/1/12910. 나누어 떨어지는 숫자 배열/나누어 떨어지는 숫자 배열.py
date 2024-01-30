def solution(arr, divisor):
    list = sorted([int(i) for i in arr if i%divisor==0])
    return list if len(list) > 0 else [-1]
        