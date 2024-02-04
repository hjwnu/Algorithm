def solution(n, arr1, arr2):
    def change(num):
        string = str(bin(num)[2:])
        while len(string) < n:
            string = " " + string
        string = string.replace("1","#").replace("0"," ")
        return string
    def merge(str1,str2):
        string = ''
        for i in range(n):
            if str1[i] == '#' or str2[i] == '#':
                string += '#'
            else:
                string += ' '
        return string
    
    answer = []
    for i,j in zip(arr1,arr2):
        answer.append(merge(change(i), change(j)))

    return answer
    

    