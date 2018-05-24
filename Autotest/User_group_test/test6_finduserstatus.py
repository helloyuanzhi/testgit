# coding=utf-8
import base_requests
from termcolor import *
import uniout
import random


# -- P 前端限制

def find_user_status():
    for i in range(0, 1):

        api_name = '查看用户归属的群体接口'
        url = 'v1/rights/findUserStatus'
        userId = random.randint(200, 300)

        params = {

            "userId": 1490119
            # "userId": 1624774
        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0 and result['result']['isRegisted'] == 1:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i+1), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i+1), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


find_user_status()
