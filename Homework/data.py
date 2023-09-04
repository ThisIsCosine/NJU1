
import pandas as pd
import matplotlib.pyplot as plt

from statsmodels.formula.api import ols
import statsmodels.api as sm

df = pd.read_excel(r'E:\study\GradeOne2\DataSecienceBase\data.xlsx')

GAMENUM = 30

# 求出勇士队场均得分，失分，返回一个列表
def GetAndLoseScore():
    game = GAMENUM
    team = df['Team']
    score = df['Score']
    num_rows = df.shape[0]
    sumOfGetScore = 0
    sumOfLoseScore = 0
    for i in range(0, num_rows):
        if score[i] == '-':
            game -= 1
            continue
        if pd.isna(score[i]) == False:
            gameScores = str(score[i])
            warriorsScore = (gameScores.split('-'))
            if team[i] == "Warriors" or team[i] == "Warriors (bench)":
                sumOfGetScore += int(warriorsScore[0])
                sumOfLoseScore += int(warriorsScore[1])
            if team[i] != "Warriors" and team[i] != "Warriors (bench)":
                sumOfGetScore += int(warriorsScore[1])
                sumOfLoseScore += int(warriorsScore[0])
    getAndLost = [sumOfGetScore / game, sumOfLoseScore / game]
    return getAndLost

#求出某位球员场均得分，篮板和助攻数，输入球员的姓名，返回一个列表
def getAPlayerData(PlayerName):
    players = df['Players']
    points = df['Points']
    rebounds = df['Rebounds']
    assists = df['Assists']
    sumPoints = 0
    pointsNum = 0
    sumRebounds = 0
    reboundsNum = 0
    sumAssists = 0
    assistsNum = 0
    for i in range(0, df.shape[0]):
        if str(players[i]) == PlayerName:
            if points[i] != '-':
                pointsNum += 1
                sumPoints += int(points[i])
            if rebounds[i] != '-':
                reboundsNum += 1
                sumRebounds += int(rebounds[i])
            if assists[i] != '-':
                assistsNum += 1
                sumAssists += int(assists[i])
    if pointsNum == 0 or reboundsNum == 0 or assistsNum == 0:
        return None
    threeDatasOfThePalyer = [sumPoints / pointsNum, sumRebounds / reboundsNum, sumAssists / assistsNum]
    return threeDatasOfThePalyer

#分析单个球员个人数据对球队的帮助,检查球员数据与球队分差是否有线性关系
#求出球员得分，篮板，助攻分别与分差之间的Pearson r
def playerToTeam(PlayerName):
    players = df['Players']
    points = df['Points']
    rebounds = df['Rebounds']
    assists = df['Assists']
    score = df['Score']


    pointData = {'pointGap':[], 'playerPoint':[]}
    reboundData = {'pointGap':[], 'playerRebound':[]}
    assistData = {'pointGap':[], 'playerAssist':[]}

    scoreGap = 0

    for i in range(0, df.shape[0]):
        if str(players[i]) == PlayerName:
            j = i
            while(1):
                if pd.isna(score[j]) == False:
                    if score[j] == '-':
                        break
                    else:
                        list = str(score[j]).split('-')
                        scoreGap = int(list[0]) - int(list[1])
                        break
                else:
                    j -= 1
            if scoreGap != 0:
                if points[i] != '-':
                    pointData['pointGap'].append(scoreGap)
                    pointData['playerPoint'].append(points[i])
                if rebounds[i] != '-':
                    reboundData['pointGap'].append(scoreGap)
                    reboundData['playerRebound'].append(rebounds[i])
                if assists[i] != '-':
                    assistData['pointGap'].append(scoreGap)
                    assistData['playerAssist'].append(assists[i])
    r = []
    pointDataFrame = pd.DataFrame(pointData)
    reboundDataFrame = pd.DataFrame(reboundData)
    assistDataFrame = pd.DataFrame(assistData)
    pointR = pointDataFrame['pointGap'].corr(pointDataFrame['playerPoint'])
    r.append(pointR)
    reboundR = reboundDataFrame['pointGap'].corr(reboundDataFrame['playerRebound'])
    r.append(reboundR)
    assistR = assistDataFrame['pointGap'].corr(assistDataFrame['playerAssist'])
    r.append(assistR)
    return r

#用柱状图显示一个球队中各个球员的数据
def showEveryPlayerData(teamName):
    name = []

    for i in range(0, len(df['Players'])):
        if df['Team'][i] == teamName or df['Team'][i] == (teamName + '(bench)'):
            exist = False
            for j in range(0, len(name)):
                if name[j] == df['Players'][i]:
                    exist = True
            if exist == False:
                name.append(df['Players'][i])
    result = {'Name':[],'Point':[], 'Rebound':[], 'Assist':[]}
    for i in range(0, len(name)):
        a = getAPlayerData(name[i])
        if a == None:
            continue
        result['Name'].append(name[i])
        result['Point'].append(a[0])
        result['Rebound'].append(a[1])
        result['Assist'].append(a[2])
    resultDf = pd.DataFrame(result)
    resultDf.plot(x='Name', y='Point',kind='bar')
    resultDf.plot(x='Name', y='Rebound', kind='bar')
    resultDf.plot(x='Name', y='Assist', kind='bar')
    plt.show()

#接下来运用双因素方差分析，分析球队有无伤病和主客场这两个因素对分差的影响，分差正数是win，负数是lose
#得到一个表格
def injuryAndHomeImpact(teamName):
    data = {'game':[], 'healthy':[], 'home':[],'gameGap':[]}
    gameNum = 0
    for i in range(0, len(df['Team'])):
        if df['Team'][i] == teamName or df['Team'][i] == (teamName + '(bench)'):
            if pd.isna(df['Score'][i]) == True or df['Score'][i] == '-':
                continue
            gameNum += 1
            data['game'].append(gameNum)
            if pd.isna(df['Score'][i]) == False and df['Score'][i] != '-':
                list = str(df['Score'][i]).split('-')
                data['gameGap'].append(int(list[0]) - int(list[1]))
            if df['Venue'][i] == 'Home':
                data['home'].append(1)
            else:
                data['home'].append(0)
            while(df['Team'][i] == teamName):
                if df['Injury Status'][i] == 'Injured':
                    data['healthy'].append(0)
                    while(df['Team'][i] == teamName):
                        i += 1
                    break
                else:
                    i += 1
                if i >= len(df['Team']) or (df['Team'][i] != teamName and  df['Team'][i] != (teamName + '(bench)')):
                    data['healthy'].append(1)
                    break
    impactDf = pd.DataFrame(data)
    model = ols(' gameGap ~ C(home) + C(healthy) + C(home):C(healthy)', data=impactDf).fit()
    anova_table = sm.stats.anova_lm(model, typ=2)
    print(anova_table)

#最后一个函数（还没写），是判断库里和杜兰特这两位在球权方面的冲突，根据杜兰特来到勇士前后库里数据以及球队数据进行比较
#可以说是探索球权减少后，库里的数据的变化和对球队贡献的变化，可以理解为一种球权的矛盾
#此函数是探索新的球星来到球队后对原本当家球星数据的影响

def contrastBetweenTwoMainPlayers(oldPlayer, newPlayer):
    oldPlayerData = getAPlayerData(oldPlayer)
    newPlayerData = getAPlayerData(newPlayer)
    oldDataWithoutNew = {'game':[],'point':[], 'rebound':[], 'assist':[]}
    ODWONgameNum = 0
    oldDataWithNew = {'game':[], 'point':[], 'rebound':[], 'assist':[]}
    ODWNgameNum = 0
    for i in range(0, len(df['Players'])):
        if df['Players'][i] == newPlayer:
            teamName = df['Team'][i]
            while(df['Players'][i] == oldPlayer or df['Team'][i] != teamName):
                i += 1
            if df['Team'][i] != teamName:
                continue
            ODWNgameNum += 1
            oldDataWithNew['game'].append(ODWNgameNum)
            oldDataWithNew['point'].append(df['Points'][i])
            oldDataWithNew['rebound'].append(df['Rebounds'][i])
            oldDataWithNew['assist'].append(df['Assists'][i])
            while (df['Team'][i] != teamName):
                i += 1
                continue
        if df['Players'][i] == oldPlayer:
            a = i
            teamName = df['Team'][i]
            while(df['Players'][i] != newPlayer and df['Team'][i] == teamName):
                i += 1
            if df['Team'][i] != teamName:
               ODWONgameNum += 1
               oldDataWithoutNew['game'].append(ODWONgameNum)
               oldDataWithoutNew['point'].append(df['Points'][a])
               oldDataWithoutNew['rebound'].append(df['Rebounds'][a])
               oldDataWithoutNew['assist'].append(df['Assists'][a])
            if df['Players'][i] == newPlayer:
                ODWNgameNum += 1
                oldDataWithNew['game'].append(ODWNgameNum)
                oldDataWithNew['point'].append(df['Points'][i])
                oldDataWithNew['rebound'].append(df['Rebounds'][i])
                oldDataWithNew['assist'].append(df['Assists'][i])
            while (i < len(df['Team']) and df['Team'][i] == teamName ):
                i += 1
                continue
    averageOldDataWithNew = {'point': 0, 'rebound': 0, 'assist': 0}
    averageOldDataWithOutNew = {'point': 0, 'rebound': 0, 'assist': 0}
    for i in range(0, len(oldDataWithoutNew['game'])):
        A = len(oldDataWithoutNew['game'])
        B = len(oldDataWithoutNew['game'])
        C = len(oldDataWithoutNew['game'])
        if oldDataWithoutNew['point'][i] == '-':
            A -= 1
        else:
            averageOldDataWithOutNew['point'] += oldDataWithoutNew['point'][i] / A
        if oldDataWithoutNew['rebound'][i] == '-':
            B -= 1
        else:
            averageOldDataWithOutNew['rebound'] += oldDataWithoutNew['rebound'][i] / B
        if oldDataWithoutNew['assist'][i] == '-':
            B -= 1
        else:
            averageOldDataWithOutNew['assist'] += oldDataWithoutNew['assist'][i] / C
    for i in range(0, len(oldDataWithNew['game'])):
        A = len(oldDataWithNew['game'])
        B = len(oldDataWithNew['game'])
        C = len(oldDataWithNew['game'])
        if oldDataWithNew['point'][i] == '-':
            A -= 1
        else:
            averageOldDataWithNew['point'] += oldDataWithNew['point'][i] / A
        if oldDataWithNew['rebound'][i] == '-':
            B -= 1
        else:
            averageOldDataWithNew['rebound'] += oldDataWithNew['rebound'][i] / B
        if oldDataWithNew['assist'][i] == '-':
            C -= 1
        else:
            averageOldDataWithNew['assist'] += oldDataWithNew['assist'][i] / C
    print(averageOldDataWithNew)
    print(averageOldDataWithOutNew)

#main函数调用以上的函数，展现勇士队的球员球队数据，并进行可视化展现（我也在想更多的可视化方法，目前只有一支球队各个球员单项数据的柱状图
if __name__ == "__main__":
    print(GetAndLoseScore())
    print(getAPlayerData("Andre Iguodala"))
    print(getAPlayerData('Stephen Curry'))
    print(playerToTeam('Andre Iguodala'))
    showEveryPlayerData('Warriors')
    injuryAndHomeImpact('Warriors')
    contrastBetweenTwoMainPlayers('Stephen Curry', 'Kevin Durant')




