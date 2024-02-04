def solution(name, yearning, photo):
    score_dic = dict(zip(name, yearning))
    return [sum(score_dic.get(n, 0) for n in row) for row in photo]
