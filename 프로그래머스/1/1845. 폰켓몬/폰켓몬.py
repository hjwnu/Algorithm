def solution(nums):
    set_ = set(nums)
    return len(set_) if len(nums)//2 > len(set_) else len(nums)//2