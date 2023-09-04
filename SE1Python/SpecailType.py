import logging


def special_typing():
    n = int(input())
    for i in range(0, n):
        ScrString = list(input()[::-1])
        TarString = list(input()[::-1])
        while True:
            if len(TarString) == 0:
                print("YES")
                break
            if len(ScrString) == 0:
                print("NO")
                break
            if TarString[0] == ScrString[0]:
                TarString.pop(0)
                ScrString.pop(0)
            else:
                ScrString.pop(0)
                if len(ScrString) != 0:
                    ScrString.pop(0)

if __name__ == "__main__":
    special_typing()
