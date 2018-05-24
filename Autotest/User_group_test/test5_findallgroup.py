# coding=utf-8
import base_requests
from termcolor import *
import uniout
import random


# -- P

def find_all_group():
    for i in range(0, 1):

        api_name = '查询分群列表接口'
        url = 'v1/rights/findAllGroup'
        page = random.randint(0, 10)
        pagesize = random.randint(0, 50)
        params = {

            "page": 3,
            "pageSize": 20
        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i+1), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i+1), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


#find_all_group()
