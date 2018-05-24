# coding=utf-8

import random
import base_requests
from termcolor import *
import time
import uniout




for i in range(1, 5):

    api_name = '预约课程按钮'

    url = 'v1/appointSign/appointBtnAction'

    params = {

        "id": 206023,
        "coachId": 149,
        "buttonCode": 1

    # 类型：Number 必有字段 备注：按钮code（ (1, "取消课程"), (4, "我接受"), (5, "确认完课"), (6, "不接受"), (7, "取消预约"),）

    }

    result = base_requests.post(url, params)

    if result:

        if result['code'] == 0:
            print colored(api_name+'接口: 执行第 %d 次 用例 -- Pass' % i, 'green'),'\n'
        else:
            print colored(api_name+'接口: 执行第 %d 次 用例 -- Failed' % i, 'red'),'\n'
    else:
        print '接口异常，无法正常解析%s' % result
