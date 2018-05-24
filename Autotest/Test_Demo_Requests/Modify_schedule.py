# coding=utf-8

import random
import base_requests
from termcolor import *
import time


for i in range(1, 3):

    api_name = '排课接口'

    url = 'v1/coach_app/modifyCoachSchedule'


    params = {

        "id": 19481,
        "beginTime": 1520071200,
        "endTime": 1520074800,
        "storeAreaIds": [46,130],
        "isForExp": 0,

    }

    result = base_requests.post(url, params)


    if result:

        if result['code'] == 0:
            print colored('排课接口：执行第 %d 次 用例 -- Pass' % i, 'green'),'\n'
        else:
            print colored('排课接口：执行第 %d 次 用例 -- Failed' % i, 'red'),'\n'
    else:
        print '接口异常，无法正常解析%s' % result
