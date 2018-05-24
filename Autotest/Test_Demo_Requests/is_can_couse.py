# coding=utf-8

import random
import base_requests
from termcolor import *
import time
import uniout




for i in range(1, 3):

    api_name = '排课接口'

    url = 'v1/cattiCenter/isCanCourseSchedule'

    params = {

        "coachIdList": [149],
        "classId": '538',

    }

    result = base_requests.post(url, params)


    if result:

        if result['code'] == 0:
            print colored(api_name+'执行第 %d 次 用例 -- Pass' % i, 'green'),'\n'
        else:
            print colored(api_name+'执行第 %d 次 用例 -- Failed' % i, 'red'),'\n'
    else:
        print '接口异常，无法正常解析%s' % result
