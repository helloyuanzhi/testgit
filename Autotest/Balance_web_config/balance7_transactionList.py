# coding=utf-8
from termcolor import *

import base_requests


# total 不显示
def balance_transactionList():
    for i in range(1, 3):

        api_name = '获取明细列表接口'

        url = 'v1/balance/transactionList'

        params = {

            "userId": 1490119,
            "page": 1,
            "pageSize": 10
        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


balance_transactionList()


