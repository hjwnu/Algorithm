def solution(s):
    return s[int(len(s)/2)] if int(len(s)%2)==1 else s[int(len(s)/2)-1:int(len(s)/2)+1]