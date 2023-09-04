import re

def JudgeFirstName(str):
    if len(str) == 0:
        print('The first name must be filled in.')
    if len(str) == 1:
        print('\"%s\" is not a valid first name. It is too short.'%str)


def JudgeLastName(str):
    if len(str) == 0:
        print('The last name must be filled in.')
    if len(str) == 1:
        print('\"%s\" is not a valid last name. It is too short.'%str)

def JudgeId(str):
    if len(re.findall(r'[A-Z][A-Z]-\d\d\d\d', str)) == 0:
        print('%s is not a valid ID.'%str)

def JudgeZip(str):
    if len(str) == 0:
        print('The ZIP code must be numeric.')
        return
    for i in range(0, len(str)):
        if str[i] < '0' or str[i] > '9':
            print('The ZIP code must be numeric.')
            return

print()
print()
print()
print()
FirstName = input()
JudgeFirstName(FirstName)
LastName = input()
JudgeLastName(LastName)
ZipCodeId = input()
JudgeZip(ZipCodeId)
Id = input()
JudgeId(Id)

