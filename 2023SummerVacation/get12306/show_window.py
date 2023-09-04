from get_station import *
from PyQt5.QtGui import *
from query_request import *
from PyQt5.QtWidgets import *
import time
import datetime

#主窗体的查询按钮
def on_click(self):
    get_from=self.textEdit.toPlainText()     # 获取出发地
    get_to=self.textEdit_2.toPlainText()     # 获取到达地
    get_date=self.textEdit_3.toPlainText()   # 获取出发时间

    # 判断车站文件是否存在
    if is_stations('stations.text') is True:
        stations=eval(read('stations.text'))   # 读取所有车站并转换为字典类型
        #判断所有参数是否为空
        if get_from!="" and get_to!="" and get_date!="":
            #判断输入的车站名称是否都存在，以及时间格式是否正确
            if get_from in stations and get_to in stations and is_valid_date(get_date):
                #计算时间差
                time_difference=self.time_difference(self.get_time(),get_date).days
                # 12306官方要求智能查询30天以内的车票
                if 0 <= time_difference <= 29:
                    #在所有车站文件中找到对应的参数、出发地
                    from_station=stations[get_from]
                    #print(from_station)
                    to_station=stations[get_to]
                    #print(to_station)
                    #发送查询请求，并获取返回信息
                    data=query(get_date,get_from,from_station,get_to,to_station)
                    print('正确1')
                    self.checkBox_default()
                    if len(data) !=0:
                        #将车票信息显示到表格中
                        print('正确2')
                        self.displayTable(len(data),16,data)
                    else:
                        messageDialog('警告','没有返回的网络数据！')
                else:
                    messageDialog('警告', '超出查询日期的范围！')
            else:
                messageDialog('警告', '输入的站名不存在，或日期格式不正确！')
        else:
            messageDialog('警告', '请填写车站名称！')
    else:
        messageDialog('警告', '未下载车站查询文件！')

#消息提示框，参数title为提示框标题文字，message为提示信息
def messageDialog(title,message):
    msg_box=QMessageBox(QMessageBox.Warning,title,message)
    msg_box.exec_()

#显示车次信息的表格
#train参数为共有多少趟列车，该参数为表格的行
#info参数为每趟列车的具体信息，例如有座、无座、卧铺等，该参数作为表格的列
def displayTable(self,train,info,data):
    self.model.clear()
    for row in range(train):
        for column in range(info):
            #添加表格内容
            item=QStandardItem(data[row][column])
            #向表格存储模式中添加表格具体信息
            self.model.setItem(row,column,item)
    #设置表格存储数据的模式
    self.tableView.setModel(self.model)

#判断是否是一个有效的日期字符串
def is_valid_date(str):
    try:
        time.strptime(str, "%Y-%m-%d")
        return True
    except:
        return False

# 获取系统当前时间并转换请求数据所需要的格式
def get_time(self):
    # 获得当前时间时间戳
    now = int(time.time())
    # 转换为其它日期格式,如:"%Y-%m-%d %H:%M:%S"
    timeStruct = time.localtime(now)
    strTime = time.strftime("%Y-%m-%d", timeStruct)
    return strTime

# 计算购票时间差，因为只能提前购买29天的车票
def time_difference(self, in_time, new_time):
    # 将字符串日期转换为struct_time时间对象
    in_time = time.strptime(in_time, "%Y-%m-%d")
    new_time = time.strptime(new_time, "%Y-%m-%d")
    # 将struct_time时间对象转换为datetime对象
    in_time = datetime.datetime(in_time[0], in_time[1], in_time[2])
    new_time = datetime.datetime(new_time[0], new_time[1], new_time[2])
    # 返回两个变量相差的值，就是相差天数
    return new_time - in_time

# 将所有车次分类复选框取消勾选
def checkBox_default(self):
    self.checkBox_G.setChecked(False)
    self.checkBox_D.setChecked(False)
    self.checkBox_Z.setChecked(False)
    self.checkBox_T.setChecked(False)
    self.checkBox_K.setChecked(False)
