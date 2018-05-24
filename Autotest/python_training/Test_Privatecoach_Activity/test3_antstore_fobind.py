# coding=utf-8

import base_requests

from termcolor import *

def ant_store():
    for i in range(1, 4):

        api_name = '蚂蚁场地限制'

        url = 'v1/coach_app/addServiceAreas'

        params = {
            "token": "44b8e26b91b5dc7be2eaf01891d5705f",
            "storeAreaIsSelectReqs": [
                {
                    "id": 173,
                    #  场地id
                    "isSelect": 0
                    #  是否选择（0：未选择，1：选择）
                }
                # {
                #     "id": 130,
                #     "isSelect": 1
                # },
                #
                # {
                #     "id": 10,
                #     "isSelect": 1
                # }
            ]

        }

        result = base_requests.post2(url, params)
        if result:
            if result['code'] == 22022:

                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'
            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


ant_store()
