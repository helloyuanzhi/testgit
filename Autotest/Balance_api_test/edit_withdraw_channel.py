# coding=utf-8
import base_requests
from termcolor import *
import main_excute
import random

# -- P

def edit_withdraw_channel():
    for i in range(1, 2):

        api_name = '编辑提现渠道接口'

        url = '/v1/account/withdrawalChannel/update'
        token = main_excute.token
        channellist = ["wx_pub", "alipay"]
        channel = ','.join(random.sample(channellist, 1))
        params = {
            "token": token,
            "account": "jkjkljklj",
            "channel": channel,
            "name": "yuhaocesih"
        }

        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


#edit_withdraw_channel()
