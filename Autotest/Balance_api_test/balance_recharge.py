# coding=utf-8
import base_requests
from termcolor import *
import main_excute

import random

# -- D

def balance_recharge():
    for i in range(1, 2):

        api_name = '余额充值接口'

        url = '/v1/account/recharge'


        amount = random.randint(100, 1000)
        # 支付渠道 alipay 支付宝 APP 支付 alipay_wap 支付宝手机网页支付 wx
        #  微信 APP 支付 wx_pub 微信公众号支付 jdpay_wap 京东手机网页支付（）
        channellist = ["wx_pub", "alipay", "jdpay_wap"]
        channel = ','.join(random.sample(channellist, 1))
        # 	来源（ "sourceType": 1,//订单来源类型：1 app-ios 2 app-安卓 3 m站-安卓 4 m站-ios 5 手动添加）
        sourceTypelist = random.randint(1, 5)

        params = {
            #"token": token,
            "amount": 100,
            "channel": "alipay",
            "sourceType": 1,
            "extra": {
                "open_id": "jijijioj",
                "success_url": "jkhjkh",
                "fail_url": "jkljklkjkl"
            }
        }

        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'
            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'
        else:
            print '接口异常，无法正常解析%s' % result


balance_recharge()
