import time
print('something')
CurrentAge = int(input())
RetireAge = int(input())
if CurrentAge >= RetireAge:
    print("You have 0 years left until you can retire.")
    ThisYear = int(time.strftime("%Y", time.localtime()))
    print("It's %d, so you can retire in %d." % (ThisYear, (ThisYear + RetireAge - CurrentAge)))
else:
    print("You have %d years left until you can retire."%(RetireAge - CurrentAge))
    ThisYear = int(time.strftime("%Y", time.localtime()))
    print("It's %d, so you can retire in %d."%(ThisYear,(ThisYear + RetireAge - CurrentAge)))
