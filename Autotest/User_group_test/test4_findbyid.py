# coding=utf-8
import base_requests
from termcolor import *
import uniout
import random


# -- P 时间戳问题

def find_user_group():
    for i in range(0, 1):

        api_name = '查询分群类型接口'
        url = 'v1/rights/findByRecordId'
        id = random.randint(130, 140)
        params = {

            "id": id
            # 分群类型 id
        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i+1), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i+1), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


#find_user_group()
