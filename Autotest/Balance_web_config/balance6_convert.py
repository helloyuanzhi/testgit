# coding=utf-8
from termcolor import *

import base_requests

# 异常
def balance_convert():
    for i in range(1, 2):

        api_name = '金额转移接口'

        url = 'v1/balance/convert'

        params = {

            "userId": 152334,
            "amount": 10
        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


balance_convert()


