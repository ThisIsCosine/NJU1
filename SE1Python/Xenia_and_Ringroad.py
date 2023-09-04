n , m = input().split()
n = int(n)
m = int(m)
TaskPlace = input().split()

place = '1'
time = 0
for i in range(0, m):
    if int(TaskPlace[i]) >= int(place):
        time += int(TaskPlace[i]) - int(place)
        place = TaskPlace[i]
    else:
        time += int(TaskPlace[i]) + n - int(place)
        place = TaskPlace[i]

print(time, end='')


