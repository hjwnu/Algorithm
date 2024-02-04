def solution(cards1, cards2, goal):
    count = 0
    for str_ in goal:
        if len(cards1) > 0 and cards1[0] == str_:
            cards1.pop(0)
            count += 1
        if len(cards2) > 0 and cards2[0] == str_:
            cards2.pop(0)
            count += 1
    return "Yes" if count==len(goal) else "No"