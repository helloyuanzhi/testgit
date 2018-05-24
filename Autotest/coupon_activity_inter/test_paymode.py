# coding=utf-8
import base_requests
from termcolor import *
import uniout
import random
import Balance_api_test.main_excute

# -- P 前端限制

def get_paymode():
    for i in range(0, 1):

        api_name = '支付方式接口'
        url = 'v2/order/paymode'

        params = {
            "orderNo": '123'

        }
        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i+1), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i+1), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


get_paymode()
