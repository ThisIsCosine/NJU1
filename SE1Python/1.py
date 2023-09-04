def logo_play():
    n = int(input())
    board = []
    for i in range(0, 10):
        board.append([' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '])

    row = col = 0
    pos = ' '

    dx = {'R': 1, 'L': -1, 'U': 0, 'D': 0}
    dy = {'R': 0, 'L': 0, 'U': -1, 'D': 1}

    for i in range(0, n):
        instruction = input().split(' ')

        for j in range(0, int(instruction[1])):
            row = row + dx[instruction[0]]
            col = col + dy[instruction[0]]

            if row > 9 or col > 9 or row < 0 or col < 0:
                print("Error!")
                return
            if len(instruction) == 3:
                pos = instruction[2]

            board[col][row] = pos

    for p in range(0, 10):
        for q in range(0, 10):
            print(board[p][q], end='')
        print()
    return


if __name__ == '__main__':
    logo_play()
