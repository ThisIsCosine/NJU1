import re

def GenderLegal(String:str, Gender:bool):
    if Gender:
        if re.fullmatch(".*lios", String) == None and re.fullmatch(".*etr", String) == None and re.fullmatch(".*initis", String) == None:
            return False
        else:
            return True
    else:
        if re.fullmatch(".*liala", String) == None and re.fullmatch(".*etra", String) == None and re.fullmatch(".*inites", String) == None:
            return  False
        else:
            return True

def CountTokenKind(PetyaList:list, Gender:bool):
    result = []
    if Gender:
        for i in range(0, len(PetyaList)):
            if re.fullmatch(".*lios", PetyaList[i]):
                result.append(1)
            elif re.fullmatch(".*etr", PetyaList[i]):
                result.append(2)
            else:
                result.append(3)
    else:
        for i in range(0, len(PetyaList)):
            if re.fullmatch(".*liala", PetyaList[i]):
                result.append(1)
            elif re.fullmatch(".*etra", PetyaList[i]):
                result.append(2)
            else:
                result.append(3)
    return result

def JudgeSequence(KindOfToken: list):
    Noun = False
    for i in range(0, len(KindOfToken) - 1):
        if KindOfToken[i] > KindOfToken[i + 1]:
            return False
        if KindOfToken[i] == 2 or KindOfToken[i + 1] == 2:
            Noun = True
        if KindOfToken[i] == 2 and KindOfToken[i + 1] == 2:
            return False
    if Noun == False:
        return False
    return True



def isPetyaLanguage():
    PetyaString = input().split()
    IsMale = True
    if re.fullmatch(".*lios", PetyaString[0]) or re.fullmatch(".*etr", PetyaString[0]) or re.fullmatch(".*initis", PetyaString[0]):
        IsMale = True
    elif re.fullmatch(".*liala", PetyaString[0]) or re.fullmatch(".*etra", PetyaString[0]) or re.fullmatch(".*inites", PetyaString[0]):
        IsMale = False
    else:
        print("NO")
        return
    if len(PetyaString) == 1:
        print("YES")
        return
    for i in range(0, len(PetyaString)):
        if GenderLegal(PetyaString[i], IsMale) == False:
            print("NO")
            return
    KindOfToken = CountTokenKind(PetyaString, IsMale)
    if JudgeSequence(KindOfToken):
        print("YES")
    else:
        print("NO")
    return

if __name__ == '__main__':
    isPetyaLanguage()