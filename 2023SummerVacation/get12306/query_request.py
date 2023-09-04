import email.header
import json
import re  #通过正则表达式匹配处理相应的字符串
import os  #判断某个路径下的某个文件
import requests  #处理网络请求
from get_station import *


data = []  # 保存整理好的车次信息
type_data = []  # 保存分类后的车次信息（如高铁，动车等）


def query(date, get_from, from_station, get_to, to_station):
    data.clear()  # 清空数据
    type_data.clear()
    # 查询请求地址
    url = 'https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date={}&leftTicketDTO.from_station={}&leftTicketDTO.to_station={}&purpose_codes=ADULT'.format(
        date, from_station, to_station)

    response = requests.get(url, headers=header, verify=False)  # 发送查询请求
    if response.text.startswith(u'\ufeff'):
        response.text = response.text.encode('utf8')[3:].decode('utf8')
    response.encoding = 'utf-8'
    print(response.url)

    result = json.loads(response.text)
    result = result['data']['result']

    # 判断车站文件是否存在
    if is_stations('stations.text'):
        stations = eval(read('stations.text'))  # 读取所有车站并转换为字典类型
        if len(stations) != 0:  # 判断返回数据是否为空
            for i in result:
                tmp_list = i.split('|')  # 分割数据并添加到列表中
                print(tmp_list)
                # 因为查询结果中出发站和到达站为站名的缩写字母，所以需要在车站库中找到对应的车站名称
                from_station = list(stations.keys())[list(stations.values()).index(tmp_list[6])]
                to_station = list(stations.keys())[list(stations.values()).index(tmp_list[7])]
                # 创建座位数组，由于返回的作为数据中含有空值，所以将空改成“--”这样好识别
                seat = [tmp_list[3], from_station, to_station, tmp_list[8], tmp_list[9], tmp_list[10],
                        tmp_list[32], tmp_list[31], tmp_list[30], tmp_list[21], tmp_list[23],
                        tmp_list[33], tmp_list[28], tmp_list[24], tmp_list[29], tmp_list[26]]
                print(seat)
                newSeat = []
                # 循环将座位信息中的空值改成“--”
                for s in seat:
                    if s == "":
                        s = "--"
                    else:
                        s = s
                    newSeat.append(s)  # 保存新的座位信息
                data.append(newSeat)
                print(newSeat)
            return data  # 返回整理好的车次信息

