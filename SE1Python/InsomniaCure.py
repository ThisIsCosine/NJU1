k = int(input())
l = int(input())
m = int(input())
n = int(input())
d = int(input())
EscapeDragon = d
for i in range(1, d + 1):
    if i % k and i % l and i % m and i % n:
        EscapeDragon -= 1
print(EscapeDragon, end = '')