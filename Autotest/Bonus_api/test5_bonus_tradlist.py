# coding=utf-8
import base_requests
import random
from termcolor import *


def bonus_tradelist():

    success = 0
    failed = 0
    for i in range(1, 5):

        api_name = '[后台]获取奖励金明细列表接口'

        url = 'v1/bonus/tradeList'

        params = {
            "userId": 1490119,
            "page": 1,
            "pageSize": 20
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
    if failed > 0:
        print colored("%s 成功 %d 次 , 失败 %d 次" % (api_name, success, failed), 'red')
    else:
        print colored("%s 成功 %d 次 , 失败 %d 次" % (api_name, success, failed), 'green')

bonus_tradelist()


