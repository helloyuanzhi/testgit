# coding=utf-8

import random
import base_requests
from termcolor import *
import time
import uniout


appointmentBeginTime = int(time.time())+60

for i in range(1, 5):

    api_name = '用户同意补签/取消'

    url = 'v1/appointSign/userConfirmCoachRequest'

    params = {

        "id": 206023,

        "coachId": 149
    }

    result = base_requests.post(url, params)

    if result:

        if result['code'] == 0:
            print colored(api_name+'接口: 执行第 %d 次 用例 -- Pass' % i, 'green'),'\n'
        else:
            print colored(api_name+'接口: 执行第 %d 次 用例 -- Failed' % i, 'red'),'\n'
    else:
        print '接口异常，无法正常解析%s' % result
