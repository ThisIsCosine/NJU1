n = int(input())
TaxiNum = 0
Group1 = 0
Group2 = 0
Group3 = 0
group = input().split()
for i in range(n):
    if group[i] == '4':
        TaxiNum += 1
    if group[i] == '1':
        Group1 += 1
    if group[i] == '2':
        Group2 += 1
    if group[i] == '3':
        Group3 += 1

if Group3 < Group1:
    TaxiNum += Group3
    Group1 -= Group3
    Group3 = 0
else:
    TaxiNum += Group3
    Group1 = 0
    Group3 = 0
TaxiNum += Group2 // 2
if (Group2 % 2):
    TaxiNum += 1
    Group2 += 1
    Group1 = Group1 - 2
if Group1 > 0:
    TaxiNum += Group1 // 4
    if Group1 % 4:
        TaxiNum += 1
print(TaxiNum)


