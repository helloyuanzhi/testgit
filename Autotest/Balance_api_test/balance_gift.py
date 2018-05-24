# coding=utf-8
import base_requests
from termcolor import *
import uniout
import random
import main_excute

# -- D, 安全性问题


def balance_gift():
    for i in range(1, 3):

        api_name = '余额赠送接口'
        url = 'v1/account/receipts'
        token = main_excute.token
        userId = random.randint(10000, 1461859)
        amount = random.randint(1, 100000)
        # 金额类型（1：不可提现，2：可提现）非必须，默认为1
        type = random.randint(1, 2)
        params = {
            # 必要, 安全性，校验
            "userId": 2013714,
            #"token": "f75d9c24f20f320e1604f47506550ab8",
            # 必要, 金额范围
            "amount": 10000,
            # 必要 , 长度限制
            "description": "宇豪测试赠送",
            # 非必要，类型范围
            "type": 1
        }

        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result

balance_gift()
