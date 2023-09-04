def solve():
    Num  = int(input())
    Magnet = input().split('\n')
    PartNum = 1
    for i in range(0, len(Magnet) - 1):
        if Magnet[i] != Magnet[i + 1]:
            PartNum += 1
    print(PartNum)
    return

if __name__ == "__main__":
    solve()