# coding=utf-8
import base_requests
import random
from termcolor import *

# -- 过


def balance_getlimitlist():
    for i in range(1, 5):

        api_name = '获取额度列表接口'

        url = 'v1/balance/getLimitList'

        params = {

        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


balance_getlimitlist()


