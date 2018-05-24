# coding=utf-8
import base_requests
import random
from termcolor import *


# --P

def payDiscount_add():
    for i in range(1, 3):

        api_name = '后台添加支付优惠接口'

        url = 'v1/payDiscount/add'

        params = {
            "beginDate": 1508432461,
            "endDate": 1508518861,
            "discountName": "宇豪测试支付5折",
            "payChannel": "alipay",
            "usedWay": 1,
            "usedValue": 5,
            "usedCondition": 2,
            "conditionArray": ["0116"],
            "userArray": [1,2,3,4],
            "shelf": 1
        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


payDiscount_add()


