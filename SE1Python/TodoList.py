file_path = 'task.txt'#have changed

def AddTask(command: str):
    TasksToAdd = command.split("\"")
    f = open(file_path, 'a')
    for i in range(1, len(TasksToAdd)):
        if len(TasksToAdd[i].strip()) != 0:
            Task = TasksToAdd[i]
            f.write(f"todo:{Task}\n")
    f.close()



def DeleteTask(command: str):
    TasksTODelete = command.split("\"")
    for i in range(1, len(TasksTODelete)):
        if len(TasksTODelete[i].strip()) != 0:
            f = open(file_path, "a")
            f1 = open(file_path, "r")
            Task = TasksTODelete[i]
            index = 0
            while True:
                Line = f1.readline().strip("\n").split(":")
                if Line[1] == Task:
                    f1.seek(0,0)
                    data = f1.readlines()
                    f.truncate(0)
                    f.seek(0,0)
                    for j in range(len(data)):
                        if j != index:
                            f.write(data[j])
                    f.close()
                    f1.close()
                    break
                else:
                    index += 1
    return

def ChangeTaskSataus(command: str):
    TasksToChange = command.split("\"")
    for i in range(1,len(TasksToChange)):
        if len(TasksToChange[i].strip()) != 0:
            Task = TasksToChange[i]
            f = open(file_path, "a")
            f1 = open(file_path, "r")
            index = 0
            while True:
                Line = f1.readline().strip("\n").split(":")
                if Line[1] == Task:
                    f1.seek(0,0)
                    data = f1.readlines()
                    f.truncate(0)
                    f.seek(0,0)
                    for j in range(len(data)):
                        if j != index:
                            f.write(data[j])
                        else:
                            f.write(f"completed:{Task}\n")
                    f.close()
                    f1.close()
                    break
                else:
                    index += 1

def FindStatusTasks(command: str):
    StatusToFind = command.split()[2]
    f = open(file_path, "r")
    while True:
        data = f.readline()
        if len(data) == 0:
            f.close()
            return
        if data.startswith(StatusToFind):
            print(data,end='')

def PrintAll():
    f = open(file_path, "r")
    while True:
        data = f.readline()
        if len(data) == 0:
            break
        else:
            print(data,end='')

def to_do():
    while True:
        commmand = input()
        CommandList = commmand.split()
        if CommandList[1] == '-quit':
            break
        elif CommandList[1] == '-a':
            AddTask(commmand)
        elif CommandList[1] == '-d':
            DeleteTask(commmand)
        elif CommandList[1] == '-c':
            ChangeTaskSataus(commmand)
        elif CommandList[1] == '-f':
            FindStatusTasks(commmand)
        elif CommandList[1] == '-all':
            PrintAll()

    return

if __name__ == '__main__':
    to_do()

#bingo