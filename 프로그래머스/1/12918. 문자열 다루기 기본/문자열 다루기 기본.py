def solution(s):
    try:
        temp = int(s)
        return True if len(s) == 4 or len(s) == 6 else False
    except: 
        return False