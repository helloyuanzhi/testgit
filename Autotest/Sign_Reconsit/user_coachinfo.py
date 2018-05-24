# coding=utf-8

import random
import base_requests
from termcolor import *
import time
import uniout




for i in range(1, 5):

    api_name = '专属私教权益列表'

    url = 'v1/coach/queryExclusiveCoachMoreInfo'

    params = {

        "coachId": 149,
        "page": 1,
        "pageSize": 10


    }

    result = base_requests.post(url, params)

    if result:

        if result['code'] == 0:
            print colored(api_name+'接口: 执行第 %d 次 用例 -- Pass' % i, 'green'),'\n'
        else:
            print colored(api_name+'接口: 执行第 %d 次 用例 -- Failed' % i, 'red'),'\n'
    else:
        print '接口异常，无法正常解析%s' % result
