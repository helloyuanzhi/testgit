# coding=utf-8
import base_requests
import random
from termcolor import *


# 不稳定，经常会有运行时异常

def payDiscount_delete():
    success = 0
    failed = 0
    for i in range(1, 10):

        api_name = '后台删除支付优惠接口'

        url = 'v1/payDiscount/delete'
        id = random.randint(11, 12)

        params = {

            "id": 11
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

    print colored("%s 成功 %d 次 , 失败 %d 次"%(api_name, success, failed),'red')


payDiscount_delete()


