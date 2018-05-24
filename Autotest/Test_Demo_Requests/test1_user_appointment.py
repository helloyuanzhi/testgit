# coding=utf-8

import base_requests
from termcolor import *


def user_appiont():
    for i in range(1, 10):

        api_name = '用户约课接口'

        url = 'v1/coach/appointment'

        params = {
           # "token": "4d2412078552c177a1658abffc50ac63",
            "coachId": 149,
            "startDate": 1524834000,
            "userAvailId": 331594,
            "storeAreaId": 130
        }

        result = base_requests.post(url, params)

        if result:

            if result['code'] == 0:

                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


user_appiont()
