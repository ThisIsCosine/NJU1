if len(str1) == 0 and len(str2) == 0:
    return True
s1 = list(str1)
s2 = list(str2)
s1.sort()
s2.sort()
if s1 == s2:
    return True
else:
    return False
