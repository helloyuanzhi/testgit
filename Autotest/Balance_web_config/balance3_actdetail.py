# coding=utf-8
from termcolor import *
import random
import base_requests


def balance_detail():
    for i in range(1, 10):

        api_name = '后台充值详情接口'

        url = 'v1/balance/actDetail'
        id = random.randint(70, 80)
        params = {

            "id": 80
            # // 活动id
        }

        result = base_requests.post2(url, params)
        if result:
            if not result['status']== 404 and result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


balance_detail()


