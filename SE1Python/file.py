#! /usr/bin/env python
# -*- coding: utf-8 -*-

import csv


def getcommand(file):
    def Insert(command):
        nonlocal file
        f = open(file, 'a')
        InsertInformation = command.split()
        NewInformation = InsertInformation[1].split(',')

        f.write("\n")
        f.write(f"{NewInformation[0]},{NewInformation[1]},{NewInformation[2]}")
        f.close()
    def ShowAll():
        nonlocal file
        f = open(file, 'r')
        LineNum = 0
        MaxNameLen = 0
        MaxTitleLen = 0
        MaxSalaryLen = 0
        sum = 0
        while True:
            line = f.readline()
            if len(line) == 0:
                break
            Information = line.strip().split(',')
            LineNum += 1
            if len(Information[0]) > MaxNameLen:
                MaxNameLen = len(Information[0])
            if len(Information[1]) > MaxTitleLen:
                MaxTitleLen = len(Information[1])
            if len(Information[2]) > MaxSalaryLen:
                MaxSalaryLen = len(Information[2])
            sum += int(Information[2])
        avarage = sum / (LineNum)
        f.close()
        f1 = open(file, 'r')
        data = f1.readlines()
        for i in range(0, LineNum - 1):
            MaxSarary = int((data[i].split(','))[2])
            MaxIndex = i
            for j in range(i, LineNum):
                line = data[j].split(',')
                if int(line[2]) < MaxSarary:
                    MaxSarary = int(line[2])
                    MaxIndex = j
                    tmp = data[MaxIndex]
                    data[MaxIndex] = data[i]
                    data[i] = tmp
        f1.close()
        print('Name'.ljust(MaxNameLen),'Title'.ljust(MaxTitleLen),'Salary')
        for i in range(0, LineNum):
            line = data[i].split(',')
            print(line[0].ljust(MaxNameLen),line[1].ljust(MaxTitleLen),"%.2f"%int(line[2]))
        print("AVG:%.2f"%avarage)







    CommandNum = int(input())
    for i in range(0, CommandNum):
        command = input()
        if command[0: 6] == "INSERT":
            Insert(command)
        if command[0: 7] == "SHOWALL":
            ShowAll()


if __name__ == '__main__':
    getcommand('a')
