# coding=utf-8
from termcolor import *

import base_requests


# 处理中， 取消暂时无数据测试

def balance_getWithdrawalStatus():
    for i in range(1, 3):

        api_name = '查询提现状态接口'

        url = 'v1/balance/getWithdrawalStatus'

        params = {

            "id": "601171019799127388160002"
            # // 交易明细流水号
            # "result":  "pending"
            # // 提现状态，已申请： created ，处理中： pending ，完成： succeeded ，
            # 失败： failed ，取消： canceled
        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


balance_getWithdrawalStatus()


