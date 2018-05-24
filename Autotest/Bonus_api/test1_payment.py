# coding=utf-8
import base_requests
import random
from termcolor import *


def order_payment():
    success = 0
    failed = 0
    for i in range(1, 2):

        api_name = '吊起支付接口'

        url = 'v2/order/payment'

        params = {
            "orderNo": "921314920123990016",
            "channel": "alipay_wap",
            "discountId": 4
            # // 添加折扣id，其他不变
        }

        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:
                success += 1
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                failed += 1
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result
    print colored("%s 成功 %d 次 , 失败 %d 次" % (api_name, success, failed), 'red')

order_payment()


