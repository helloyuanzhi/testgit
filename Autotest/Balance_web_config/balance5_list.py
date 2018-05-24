# coding=utf-8
from termcolor import *

import base_requests

# 1、添加name的模糊搜索功能


def balance_actlit():
    for i in range(1, 10):

        api_name = '后台充值活动列表接口'

        url = 'v1/balance/actList'

        params = {

           # "name": "模糊搜索",
            # // 活动名称
            #"type": 1,
            # // 赠品类型 0： 优惠券1： 商品
            #"status": 1,
            # // 状态0： 下架1：上架
            "pageSize": 20,
            "page": 1,

        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


balance_actlit()


