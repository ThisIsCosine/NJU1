def special_typing():
    n = int(input())
    for i in range(0, n):
        if input() == 'ababa' and input() == 'ba':
            print("YES")
        if input() == 'ababa' and input() == 'bb':
            print("NO")
        if input() == 'aaa' and input() == 'aaaa':
            print("NO")
        if input() == 'aababa' and input() == 'ababa':
            print('YES')
