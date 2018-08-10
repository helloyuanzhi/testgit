# coding=utf-8

import requests
import json

# 解决post中文解析乱码的问题
import sys

reload(sys)





# 定义服务器域名头
config = {

    # 测试站域名
    #"domain": "http://t.leoao.com/",
    # 线上域名
    "domain": "https://tp.leoao.com/",
    #UAT
    #"domain": "https://uat-tp.leoao.com/",
    # 预发布域名
    "pdomain":"http://uat-h5-app.leoao.com/lens/conduct/pt/api/dubbo/",
    # 私教测试后台地址
    "domain2": "http://172.16.150.62:8082/",
    # 大平台后台域名

    #"domain": "http://tlapis-iot-inc.leoao.com",
    #"domain2": "http://172.16.150.61:8082/"
    # 用户分群测试
    #"domain2": "http://pub-gw.tjapis.leoao-inc.com/"
    #"domain": "https://tp.leoao.com/"
    # "domain": "http://ptest.leoao.com/account"
    "domain3": "http://172.16.150.61:8083/"
}


# 定义请求头
header = {

     #"lk-ssotoken": "62879fb547aa61e29e49ed922cbfb345"
     #"lk-ssotoken": "0589966032fad52abbdb39facb0debbd"
     "lk-ssotoken": "2CE353F3CEEB609965C74D079CCF36CF"
}

# 定义requests统一的解析json方法 post
def post(url, params):
    try:
        url = '%s%s' % (config["domain"], url)
        print '请求地址:', url
        print '入参', json.dumps(params, ensure_ascii=False)
        request = requests.post(url, json=params, headers=header)
        jsonStr = json.loads(request.text)
        print '出参:', request.text
        # 查看请求头，
        # print request.request.headers
        # 查看返回响应头
        # print request.headers
        response_time = float(request.elapsed.microseconds / 1000)
        print '接口响应时间：%d ms' % response_time
        return jsonStr
    except Exception, e:
        print e
        return False


def post2(url, params):
    try:
        url = '%s%s' % (config['domain3'], url)
        print '请求地址:', url
        print '入参', json.dumps(params, ensure_ascii=False)
        request = requests.post(url, json=params)
        jsonStr = json.loads(request.text)
        print '出参:', request.text
        # 查看请求头，
        # print request.request.headers
        # 查看返回响应头
        # print request.headers
        response_time = float(request.elapsed.microseconds / 1000)
        print '接口响应时间：%d ms' % response_time
        return jsonStr
    except Exception, e:
        print e
        return False


# 定义requests统一的解析方法get,带参数不带参数均可

def get(url, params={}):

    try:
        url = '%s%s' % (config["domain"], url)
        print '请求地址:', url
        print '入参', params
        request = requests.get(url, json=params)
        jsonStr = json.loads(request.text)
        print '出参:', request.content
        response_time = float(request.elapsed.microseconds / 1000)
        print '接口响应时间：%d ms' % response_time
        return jsonStr
    except Exception, e:
        print e
        return False

# 定义requests其他类型的解析方法
r = requests.put("http://httpbin.org/put")
r = requests.delete("http://httpbin.org/delete")
r = requests.head("http://httpbin.org/get")
r = requests.options("http://httpbin.org/get")
