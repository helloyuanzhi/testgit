# coding=utf-8

import Balance_api_test.main_excute
import base_requests
import random
from termcolor import *

def user_sin():
    for i in range(1, 3):

        api_name = '用户签到接口'

        url = 'v1/lesson/signByLocation'

        params = {
            # "token": "3da0ce93cf9673bba7c04ec142b24def",
            "appointmentClassId": 206767,
            "lat": "30.302256",
            "lng": "120.139702"
        }

        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:

                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


user_sin()