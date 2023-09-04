
def process(param):
    a = ''
    for i in range(len(param)):
        if len(param[i]) == 1:
            continue
        a += param[i].capitalize()
        a += ','
    b = list(a)
    if len(b):
        b.pop()
    c = ''.join(b)
    return c



if __name__ == '__main__':
    List = input().split()
    print(process(List), end='')
