# coding=utf-8

import base_requests
from termcolor import *


def user_appiont():
    for i in range(1, 5):

        api_name = '暂停时常权益接口'

        url = 'v1/avail/pauseUserAvail'

        params = {
            "userAvailId": 331657,
            "pauseBeginTime": 1525881600,
            "pauseEndTime": 1525968000,
            "operatorId": 123
        }

        result = base_requests.post2(url, params)

        if result:

            if result['code'] == 0:

                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


user_appiont()
