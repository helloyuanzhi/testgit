# coding=utf-8

import random
import base_requests
from termcolor import *
import time
import uniout


appointmentBeginTime = int(time.time())+60

for i in range(1, 2):

    api_name = '排课接口'

    url = 'v1/coach_app/addSchedule'
    appointmentEndTime = appointmentBeginTime + 120

    params = {

        "appointmentBeginTime": appointmentBeginTime,
        "appointmentEndTime": appointmentEndTime,
        "userId": 152334,
        "goodsNo": "01241",
        "storeAreaId": 130,
        "subjectInfo": "宇豪添加课程内容",
        "orderNo": "订单编号11",
        "classInfoName": "测试课程名",
        "userAvailId": 331812
    }

    result = base_requests.post(url, params)

    appointmentBeginTime += 180
    if result:

        if result['code'] == 0:
            print colored('排课接口：执行第 %d 次 用例 -- Pass' % i, 'green'),'\n'
        else:
            print colored('排课接口：执行第 %d 次 用例 -- Failed' % i, 'red'),'\n'
    else:
        print '接口异常，无法正常解析%s' % result
