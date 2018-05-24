# coding=utf-8

import Balance_api_test.main_excute
import base_requests
import json
from termcolor import *

def coach_sin():
    for i in range(1, 5):

        api_name = '教练签到接口'

        url = 'v1/coach_app/coachSigIn'

        params = {
            "appointmentClassId": 206766,
            "lat": 30.29847,
            "lng": 120.129617,
            "remark": "",
            "isOutside": 0

            # 120.129617,30.29847
        }

        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


coach_sin()
