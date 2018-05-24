# coding=utf-8
import base_requests
from termcolor import *
import main_excute

# -- P 获取余额

def get_user_balance():
    for i in range(1, 2):

        api_name = '获取用户账户余额'
        url = 'v1/account/balance'
        params = {
            # "token": "e91e153a262e53fe3ea4da8dada3f305"
        }

        result = base_requests.post(url, params)
        if result:

            if result['code'] == 0:

                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '%s: 接口异常，无法正常解析%s' % (api_name, result)
get_user_balance()
