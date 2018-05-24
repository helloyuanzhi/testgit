# coding=utf-8
import base_requests
import main_excute
import random
from termcolor import *


def account_detail():
    for i in range(1, 2):

        # ---P
        api_name = '账户明细66'

        url = '/v1/account/transactionList'

        page = random.randint(1, 10)
        pageSize = random.randint(1, 50)

        params = {
           # "token": token,
            "page": 1
            #"pageSize": 50,
        }
        result = base_requests.post2(url, params)
        if result:
            if result['code'] == 0:

                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'
        else:
            print '接口异常，无法正常解析%s' % result

account_detail()
