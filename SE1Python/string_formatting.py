def formatting(s, k):
    l = s.split('-')
    str = ''.join(l)
    FirstPart = len(str) % k
    NewL = []
    if FirstPart != 0:
        NewL.append(str[0:FirstPart])
        NewL.append('-')
    for i in range(FirstPart, len(str)):
        if i != FirstPart and (i - FirstPart) % k == 0:
            NewL.append('-')
        NewL.append(str[i])
    NewStr = ''.join(NewL).upper()
    return NewStr

if __name__ == "__main__":
    formatting("r",1)