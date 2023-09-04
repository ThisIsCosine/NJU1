def special_typing():
    n = int(input())
    for i in  range(0, n):
        ScrString = input()
        DesString = input()
        if DesString == '':
            print("YES")
            break
        for j in range(2 ** (len(ScrString) - 1), 2 ** len(ScrString)):
            Operation = bin(j).replace('0b','').zfill(len(ScrString))
            PossibleStringList = []
            for k in range(0, len(Operation)):
                if Operation[k] == '1':
                    PossibleStringList.append(ScrString[k])
                else:
                    if len(PossibleStringList) != 0:
                        PossibleStringList.pop()
            PossibleString = ''.join(PossibleStringList)
            if PossibleString == DesString:
                print("YES")
                break
            if j == 2 ** len(ScrString) - 1:
                print("NO")

if __name__ == "__main__":
    special_typing()