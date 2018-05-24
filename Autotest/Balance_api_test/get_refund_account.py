# coding=utf-8
import base_requests
from termcolor import *
import main_excute


# -- P

def get_refund_account():
    for i in range(1, 2):

        api_name = '获取绑定的退款账号'

        url = '/v1/account/withdrawalChannel'
        token = main_excute.token
        params = {
            'token': token
        }
        print '入参:', params
        result = base_requests.post(url, params)
        if result:
            if result['code'] == 200:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


# get_refund_account()
