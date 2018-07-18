# coding=utf-8


import base_requests
from termcolor import *


for i in range(1, 4):

    api_name = '私教服务分接口'

    url = 'v1/coach/getCoachServerScore'
    params = {

        "coachId": 16
    }

    result = base_requests.post(url, params)

    if result:
            if result['code'] == 0:
                print colored('排课接口：执行第 %d 次 用例 -- Pass' % i, 'green'),'\n'
            else:
                print colored('排课接口：执行第 %d 次 用例 -- Failed' % i, 'red'),'\n'
    else:
        print '接口异常，无法正常解析%s' % result
