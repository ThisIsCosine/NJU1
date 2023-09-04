def solve():
    Num = int(input())
    TimeList = input().split()
    ATime = 0
    BTime = 0
    a = 0
    b = 0
    while True:
        if a + b == Num:
            print(a,b)
            return
        ATime += 1
        BTime += 1
        if ATime == int(TimeList[a]):
            a += 1
            ATime = 0
        if a + b != Num and BTime == int(TimeList[-1 - b]):
            b += 1
            BTime = 0

if __name__ == '__main__':
    solve()