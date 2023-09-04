## 数据科学大作业（选题二）
### 实验概述
 本次实验选取三十条关于勇士队的文本数据，先利用ChatGPT将其转换为table，然后利用python和pandas库进行数据分析并得到一些结果
 ### 函数解释
#### 1.得出勇士队的场均得分和失分
~~~
def GetAndLoseScore():
~~~
函数返回一个列表
~~~
getAndLost = [sumOfGetScore / game, sumOfLoseScore / game]
    return getAndLost
~~~
getAndLost列表第一项是场均得分，第二项是场均失分
（这里可以将函数接口优化，使其可以计算任意球队的场均得分和失分，但本次实验中计算勇士队即可）
#### 2.得到某一位球员的场均数据
~~~
def getAPlayerData(PlayerName):
    ...
    return threeDatasOfThePalyer
~~~
此函数需要传入球员的姓名，返回一个列表，列表依次是该球员的场均得分，场均篮板，场均助攻三项数据
#### 3. 线性分析：某一位球员对所属球队的线性关系
~~~
def playerToTeam(PlayerName):
    ...
    return r
~~~
函数需要传入该球员的姓名，计算各场比赛中比赛分差（勇士队赢分差为正数，反之为负数）与该球员的得分，篮板，助攻三项数据的pearson系数，得到三个r，形成一个列表，返回这个列表
#### 4.数据可视化：用柱状图显示一支球队中各个球员的场均得分，篮板，助攻
~~~
def showEveryPlayerData(teamName):
    ...
        resultDf = pd.DataFrame(result)
    resultDf.plot(x='Name', y='Point',kind='bar')
    resultDf.plot(x='Name', y='Rebound', kind='bar')
    resultDf.plot(x='Name', y='Assist', kind='bar')
    plt.show()
~~~
需要传入球队名，显示三张柱状图，分别为各个球员的场均得分，场均篮板，场均助攻
#### 5.双因素方差分析：分析球队有无伤病和主客场这两个因素对分差的影响
~~~
def injuryAndHomeImpact(teamName):
    ...
    print(anova_table)
~~~
需要传入球队名，打印出双因素方差分析的ANOVA表。ANOVA表提供了用于评估不同因素对结果的影响的统计指标，反映出球队有无伤病和主客场对分差的影响。
#### 6.分析球队主要球星之间的影响或是矛盾
~~~
def contrastBetweenTwoMainPlayers(oldPlayer, newPlayer):
    ...
    print(averageOldDataWithNew)
    print(averageOldDataWithOutNew)
~~~
需要输入oldPlayer：球队中老牌球星的姓名，newPlayer：球队中新来球星的姓名
打印出newPlayer来到之后和来到之前oldPlayer的场均得分，篮板，助攻三项数据的字典。通过比较两个字典的差距得出newPlayer来到球队对oldPlayer的影响，或是得出newPlayer与oldPlayer之间的球权矛盾

### 实验过程以及结果展示
#### 1.得出勇士场均得分和失分
~~~
   print(GetAndLoseScore())
~~~
输出
~~~
[110.35714285714286, 103.25]
~~~
结论：场均得分110.35，失分103.25
#### 2.得出勇士队球员伊戈达拉和库里的个人数据
~~~ 
    print(getAPlayerData("Andre Iguodala"))
    print(getAPlayerData('Stephen Curry'))
~~~
输出
~~~
[15.6, 5.333333333333333, 4.25]
[28.318181818181817, 5.384615384615385, 6.9375]
~~~
结论：可以看出与当家球星库里比起来，伊戈达拉的个人数据并不突出（但是这不妨碍他是FMVP
#### 3.得出伊戈达拉个人数据与球队分差的Pearson系数列表
~~~
    print(playerToTeam('Andre Iguodala'))
~~~
输出
~~~
[0.9575175804338616, 0.1428571428571429, 0.5832017006169344]
~~~
结论：伊戈达拉的得分与球队分差的Pearson系数达到了0.95，说明两者有很强的正相关的线性关系，再一次说明了伊戈达拉对球队的正面作用，可以解释其总决赛的现象级表现对球队胜利的巨大作用
#### 4.数据可视化：柱状图显示勇士队的各个球员的数据
~~~
    showEveryPlayerData('Warriors')
~~~
#### 5.双因素方差分析：分析勇士队的伤病和主客场两个因素对分差影响
~~~
    injuryAndHomeImpact('Warriors')
~~~
输出
~~~
                         sum_sq    df         F    PR(>F)
C(home)                0.233272   1.0  0.002709  0.959099
C(healthy)             8.884468   1.0  0.103167  0.751977
C(home):C(healthy)   174.924623   1.0  2.031229  0.172198
~~~
PR(>F)（p值）：对应于F值的概率值，用于判断各个源（因素）是否对结果有显著影响
结论：看出主客场和伤病两个因素对球队分差的影响不大，两者之比对分差有些影响
#### 6.得出杜兰特来到勇士前后库里的数据对比
~~~
    contrastBetweenTwoMainPlayers('Stephen Curry', 'Kevin Durant')
~~~
输出
~~~
{'point': 26.46666666666667, 'rebound': 7.800000000000001, 'assist': 4.466666666666667}
{'point': 25.5, 'rebound': 2.8333333333333335, 'assist': 5.222222222222221}
~~~
结论：杜兰特的到来对库里的得分，助攻等数据影响不大，但明显减少了库里的篮板数，可以理解出杜兰特的到来减少了库里这个后卫的篮板压力
### 实验反思
本次实验仅使用勇士队相关的30条文本数据，数据量较少，存在结论不全面的问题，请老师和助教指正