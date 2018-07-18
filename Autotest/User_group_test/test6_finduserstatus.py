# coding=utf-8

from termcolor import *
import sys
sys.path.append("/Users/yuhao/PycharmProjects/testgit/Autotest/Test_Demo_Requests/")
import random
import base_requests


def find_user_status():
    for i in range(0, 1):

        api_name = '查看用户归属的群体接口'
        url = 'v1/rights/findUserStatus'
        userId = random.randint(200, 300)

        params = {

            "userId": 152334
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
