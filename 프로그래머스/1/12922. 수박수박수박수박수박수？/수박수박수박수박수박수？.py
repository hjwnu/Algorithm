def solution(n):
    ans = "수박"*(n//2)
    return ans if n%2==0 else ans+"수"