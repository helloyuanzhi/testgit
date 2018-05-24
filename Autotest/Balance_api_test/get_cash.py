# coding=utf-8
import base_requests
from termcolor import *
import random
import main_excute

# -- F 微信提现不行，明明账号有余额

# 注意提现接口的安全性校验

def get_cash():
    for i in range(1, 2):

        api_name = '发起提现申请接口'
        url = '/v1/account/withdrawal'
        token = main_excute.token
        amount = random.randint(1, 1000)
        channellist = ["wx_pub", "alipay"]
        channel = ','.join(random.sample(channellist, 1))
        params = {
            "token": token,
            "amount": 200,
            "channel": 'alipay'
        }

        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n-'

        else:
            print '接口异常，无法正常解析%s' % result

#get_cash()
