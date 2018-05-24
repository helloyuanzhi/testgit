# coding=utf-8
import base_requests
import random
from termcolor import *

# --F 不稳定，运行时异常

def payDiscount_update():
    for i in range(1, 5):

        api_name = '后台修改支付优惠接口'

        url = 'v1/payDiscount/update'

        params = {
            "id": 12,
            "beginDate": 1508691661,
            "endDate": 1508778061,
            "discountName": "宇豪测试优惠券修改85折",
            "payChannel": "alipay",
            "usedWay": 1,
            "usedValue": 85,
            "usedCondition": 2,
            # conditionArray 限制条件的值，数组类型
            "conditionArray": ["011"],
            # userArray 用户限制，数组类型
            "userArray": [1, 2, 3, 4, 5],
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


payDiscount_update()


