# coding=utf-8
import base_requests
import random
from termcolor import *


def balance_getRechargeLimit():
    for i in range(1, 4):

        api_name = '获取余额充值额度以及相应活动接口'

        url = 'v1/account/getRechargeLimit'

        params = {

            "cityId": 2
        }

        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


balance_getRechargeLimit()


