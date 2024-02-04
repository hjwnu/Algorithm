solution = lambda n, arr1, arr2: [format(i | j , f'0{n}b').replace('1', '#').replace('0', ' ') for i,j in zip(arr1,arr2)]
    

    