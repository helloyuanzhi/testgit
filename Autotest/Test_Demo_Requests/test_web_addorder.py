# coding=utf-8
import base_requests
from termcolor import *
import uniout
import random


# -- P 前端限制

def add_order_web():
    for i in range(0, 1):

        api_name = '后台添加订单'
        url = 'v1/order/insertOrderOffLine'

        params = {

            "bizType": 1,
            "cityId": 12597,
            "coachId": 149,
            "storeAreaId": 130,
            "coachName": "Coco",
            "factPrice": 144000,
            "goodsName": "减脂塑形",
            "goodsNo": "01250",
            "goodsNum": 10,
            "goodsType": "one",
            "operatId": 2,
            "orderPrice": 144000,
            "payNo": 8799999899299,
            "payPicture": "http://omdweogbh.bkt.clouddn.com/201703211206321490071373640",
            "payWay": 1,
            "sorceType": 1,
            "userHeadPic": "http://wx.qlogo.cn/mmopen/0LAzyOXdPqGVJM6d4rxdDvj5Ps6T582icRpkEUH3rQHicVg7p3gMgLeu587bwwef2TzJskxliaMX373M7nDhdlle6tFVlBsXSb3/0",
            "userId": 1490119,
            "userNick": "Kerry",
            "userPhone": 13575495146

        }

        result = base_requests.post2(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i+1), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i+1), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result

add_order_web()
