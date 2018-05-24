# coding=utf-8
import base_requests
import random
from termcolor import *


def bonus_updatestatus():

    success = 0
    failed = 0
    for i in range(1, 2):

        api_name = '[后台]冻结或解冻奖励金状态接口'

        url = 'v1/bonus/updateStatus'

        params = {
            "userId": 1490119,
            "status": 1
            # // 0: 冻结1：解冻
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
    print colored("%s 成功 %d 次 , 失败 %d 次" % (api_name, success, failed), 'red')

bonus_updatestatus()


