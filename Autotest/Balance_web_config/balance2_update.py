# coding=utf-8
from termcolor import *

import base_requests


def balance_update():
    for i in range(1, 3):

        api_name = '后台修改充值活动接口'

        url = 'v1/balance/updateAct'

        params = {
            "id": 23,
            "name": "宇豪测试修改活动"+str(i),
            # 活动名称
            "description": "宇豪从测试修改活动描述",
            # 活动描述
            "type": 1,
            # 赠品类型（0： 优惠券1：商品）
            "limitId": 1,
            # 充值额度id
            "giftId": "2",
            # 赠品id（优惠券id、商品id）
            "cityIdList": [1],
            "userGroupList": [1, 2, 3],
            "startDate": 1508641871,
            # 开始时间
            "endDate": 1508728271,
            # 结束时间
            "status": 1,
            # 0： 下架 1：上架
        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


balance_update()


