def solution(a, b):
    day = [31,29,31,30,31,30,31,31,30,31,30,31]
    week = ['FRI','SAT','SUN','MON','TUE','WED','THU']
    return week[(sum(day[:a-1])+b-1)%7]