import json
import re  # 通过正则表达式匹配处理相应的字符串
import os  # 判断某个路径下的某个文件
import requests  # 处理网络请求


def get_selling_time():
    url = 'https://www.12306.cn/index/script/core/common/qss_v10082.js'
    response = requests.get(url, verify=True)  # 请求并进行验证
    print(response.text)
    print(type(response.text))
    json_str = re.findall('{[^}]+}', response.text)  # 匹配括号内所有内容
    print(json_str)
    time_js = json.loads(json_str[0])  # 解析JSON数据
    print(time_js)
    write(str(time_js), 'time.text')  # 调用写入方法


def get_station():
    # 发送请求获取所有车站名称，通过输入的站名称转化查询地址的参数
    url = 'https://kyfw.12306.cn/otn/resources/js/framework/station_name.js?station_version=1.9151'
    response = requests.get(url, verify=True)  # 请求并进行验证
    # print(response.text)
    print(type(response.text))
    # [\u4e00-\u9fa5]+表示匹配给定字符中任意一个汉字
    stations = re.findall('([\u4e00-\u9fa5]+)\|([A-Z]+)', response.text)  # 获取需要的车站名称
    # print(stations)
    # print(type(stations))
    stations = dict(stations)  # 转换为字典
    # print(stations)
    stations = str(stations)  # 转换为字符串类型否则无法写入文件
    # print(stations)
    write(stations, 'stations.text')  # 调用写入方法


# 写入文件
def write(stations, file_name):
    file = open(file_name, 'w', encoding='utf_8_sig')  # 以写模式打开文件
    file.write(stations)  # 写入数据
    file.close()


# 读文件
def read(file_name):
    file = open(file_name, 'r', encoding='utf_8_sig')  # 以读模式打开文件
    data = file.readline()  # 读取文件
    file.close()
    return data


# 判断文件是否存在
def is_stations(file_name):
    is_stations = os.path.exists(file_name)
    return is_stations


if __name__ == '__main__':
    if is_stations('stations.text') is False:
        get_station()  # 下载所有车站文件
    if is_stations('time.text') is False:
        get_selling_time()  # 下载起售时间文件
