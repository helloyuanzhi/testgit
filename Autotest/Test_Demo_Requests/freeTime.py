# coding=utf-8

import random
import base_requests
from termcolor import *
import time
import uniout




for i in range(1, 100):
    coachId = random.randint(145, 150)
    api_name = '约课查询接口'

    url = 'v1/coach/freeTime'
    params = {
        "coachId": coachId,
        "date": 1528719217,
        "days": 7,
        "storeAreaId": ""
    }

    result = base_requests.post2(url, params)


    if result:

        if result['code'] == 0:
            print colored('排课接口：执行第 %d 次 用例 -- Pass' % i, 'green'),'\n'

        else:
            print colored('排课接口：执行第 %d 次 用例 -- Failed' % i, 'red'),'\n'
    else:
        print '接口异常，无法正常解析%s' % result
