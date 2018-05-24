# coding=utf-8
import base_requests
import random
from termcolor import *


def payDiscount_shelf():
    success = 0
    failed = 0
    for i in range(1, 10):

        api_name = '后台支付折扣上下架接口'
        url = 'v1/payDiscount/shelf'

        id = random.randint(5, 15)
        params = {

            "id": id
        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                success += 1
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                failed += 1
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result
    print colored("用例执行情况 -- %s ：成功 %d 次 , 失败 %d 次" % (api_name, success, failed), 'red')


payDiscount_shelf()


