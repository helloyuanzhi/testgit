# coding=utf-8
import base_requests
import random
from termcolor import *


def order_paymode():
    for i in range(1, 3):

        api_name = '收银台接口'

        url = 'v3/order/paymode'

        params = {
            "orderNo": "921314920123990016"
        }

        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


order_paymode()


