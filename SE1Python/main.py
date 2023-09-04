board = [[' ',' ',' ',' ',' ',' ',' ',' ',' ',' '] for i in range(10)]
Row = 0
Col = 0
FillChar = ' '
PenDown = True
Error = False

def NormalMove(demand):
    global board, Row, Col, FillChar, PenDown, Error
    if demand[1] == 'U':
        if Row - int(demand[2]) < 0:
            Error = True
            return
        if len(demand) == 4 and PenDown:
            FillChar = demand[3]
        if(PenDown):
            for i in range(Row - 1, Row - 1 - int(demand[2])):
                board[i][Col] = FillChar
        Row -= int(demand[2])
    if demand[1] == 'D':
        if Row + int(demand[2]) >= 10:
            Error = True
            return
        if len(demand) == 4 and PenDown:
            FillChar = demand[3]
        if(PenDown):
            for i in range(Row + 1, Row + 1 + int(demand[2])):
                board[i][Col] = FillChar
        Row += int(demand[2])
    if demand[1] == 'L':
        if Col - int(demand[2]) < 0:
            Error = True
            return
        if len(demand) == 4 and PenDown:
            FillChar = demand[3]
        if(PenDown):
            for i in range(Col - 1, Col - 1 - int(demand[2])):
                board[Row][i] = FillChar
        Col -= int(demand[2])
    if demand[1] == 'R':
        if  Col + int(demand[2]) >= 10:
            Error = True
            return
        if len(demand) == 4 and PenDown:
            FillChar = demand[3]
        if(PenDown):
            for i in range(Col + 1, Col + 1 + int(demand[2])):
                board[Row][i] = FillChar
        Col += int(demand[2]) #检查
    return

def Rect(demand):
    global board, Row, Col, FillChar, PenDown, Error
    if Col + int(demand[1]) > 10 or Row + int(demand[2]) > 10:
        Error = True
        return
    if len(demand) == 4 and PenDown:
        FillChar = demand[3]
    if(PenDown):
        for i in range(Col, Col + int(demand[1])):
            board[Row][i] = FillChar
            board[Row + int(demand[2]) - 1][i] = FillChar
        for i in range(Row, Row + int(demand[2])):
            board[i][Col] = FillChar
            board[i][Col + int(demand[1]) - 1] = FillChar
    return

def Rect_f(demand):
    global board, Row, Col, FillChar, PenDown, Error
    if Col + int(demand[1]) > 10 or Row + int(demand[2]) > 10:
        Error = True
        return
    if len(demand) == 4 and PenDown:
        FillChar = demand[3]
    if PenDown:
        for i in range(Col, Col + int(demand[1])):
            for j in range(Row, Row + int(demand[2])):
                board[j][i] = FillChar
    return

def Cross(demand):
    global board, Row, Col, FillChar, PenDown, Error
    if Col - int(demand[1]) < 0 or Col + int(demand[1]) >= 10 or Row - int(demand[1]) < 0 or Row + int(demand[1]) >= 10:
        Error = True
        return
    if PenDown and len(demand) == 3:
        FillChar = demand[2]
    if PenDown:
        for i in range(Col - int(demand[1]), Col + int(demand[1]) + 1):
            board[Row][i] = FillChar
        for i in range(Row - int(demand[1]), Row + int(demand[1]) + 1):
            board[i][Col] = FillChar
    return

while 1:
    demand = input().split()
    if demand[0] == 'pen_up':
        PenDown = False
        continue
    if demand[0] == 'pen_down':
        PenDown = True
        continue
    if demand[0] == 'move':
        NormalMove(demand)
        if Error:
            print("Error!", end='')
            exit(0) #改为return
        continue
    if demand[0] == 'cross':
        Cross(demand)
        if Error:
            print("Error!", end='')
            exit(0) #改为return
        continue
    if demand[0] == 'rect':
        Rect(demand)
        if Error:
            print("Error!", end='')
            exit(0) #改为return
        continue
    if demand[0] == 'rect_f':
        Rect_f(demand)
        if Error:
            print("Error!", end='')
            exit(0) #改为return
        continue
    if demand[0] == 'end':
        break
for i in range(0, 10):
    for j in range(0, 10):
        print(board[i][j], end='')
    print('\n', end='')



