# coding=utf-8
from termcolor import *

import base_requests


def balance_userList():
    for i in range(1, 3):

        api_name = '获取用户列表接口'

        url = 'v1/balance/userList'

        params = {

            #"nickname": "Kerry",
            #"phone": "13575495146",
            "page": 1,
            "pageSize": 20
        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


balance_userList()


