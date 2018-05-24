# coding=utf-8
from termcolor import *
import random
import base_requests
import time

# 商品，优惠券是否存在做校验



def balance_add():
    success = 0
    failed = 0

    startDate = int(time.time()) + 60
    for i in range(1, 20):

        api_name = '后台新增充值活动接口'
        url = 'v1/balance/addAct'
        type = random.randint(0, 1)
        limitId = random.randint(1, 5)


        params = {

            "name": "宇豪测试充值活动商品"+ str(i),
            # 活动名称
            "description": "宇豪测试充值商品描述",
            # 活动描述
            "type": 1 ,
            # 赠品类型（0： 优惠券1：商品）
            "limitId": limitId,
            # 充值额度id
            "giftId": "0116",
            # 赠品id（优惠券id、商品id）
            "cityIdList": [1, 2, 3],
            "userGroupList": [1, 2, 3],
            "startDate": 1508211656,
            # 开始时间
            "endDate": 1508298056,
            # 结束时间
            "status": 1,
            # 0： 下架 1：上架
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


balance_add()


