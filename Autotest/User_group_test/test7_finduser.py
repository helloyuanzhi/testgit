# coding=utf-8
import base_requests
from termcolor import *
import uniout
import random


# -- P 前端限制

def find_user():
    for i in range(0, 1):

        api_name = '根据指定的用户群列表，查看用户归属的群体接口'
        url = 'v1/rights/findUser'
        id = random.randint(50, 70)

        params = {

            "userId": 1490119,
            # 归属的分群类型 集合
            "groupIdArr": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                           15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]
        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i + 1), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i + 1), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


find_user()
