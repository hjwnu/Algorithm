def solution(nums):
    return len(set(nums)) if len(nums)//2 > len(set(nums)) else len(nums)//2