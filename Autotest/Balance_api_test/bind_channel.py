# coding=utf-8
import base_requests
from termcolor import *
import main_excute
import random


# 绑定换帮，绑定后不能重复绑定 --D，首次绑定出现异常
# 目前只支持支付宝，支付宝的绑定和修改都用这个接口


def bind_channel():
    for i in range(1, 2):

        api_name = '编辑提现渠道接口'

        url = '/v1/account/withdrawalChannel/bind'
        token = main_excute.token
        channellist = ["wx_pub", "alipay"]
        channel = ','.join(random.sample(channellist, 1))
        params = {
            "token": token,
            "account": "yuhaozhanghao",
            "channel": channel,
            "name": "yuhao"
        }

        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


#bind_channel()
