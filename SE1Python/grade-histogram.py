def histogram(fileName):
    f = open(fileName, 'r')
    StudentNum = int(f.readline().strip('\n'))
    line = f.readline().strip('\n')
    grade = line.split()
    NumInLevel = [0] * 10
    for i in range(StudentNum):
        if int(grade[i]) != 100:
            NumInLevel[int(grade[i]) // 10] += 1
        else:
            NumInLevel[9] += 1
    for i in range(0, 10):
        if i != 9:
            print(f"{NumInLevel[i]},",end='')
        else:
            print(f"{NumInLevel[i]}")
    for i in range(0, 9):
        print("%2d -%3d:"%(i * 10, i * 10 + 9),end='')
        print("*" * NumInLevel[i] + '\n', end='')
    print("90 -100:" + "*" * NumInLevel.pop())
    f.close()
    return

if __name__ == "__main__":
    histogram('a')