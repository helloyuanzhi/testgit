# coding=utf-8
import base_requests
from termcolor import *
import main_excute

token = main_excute.token

# 入参用例设计 ， 正确，不传，传错误值

params1 = {
    "token": token
}
params2 = {}

params3 = {
    "token": 'fadfkjaklj'
}
params = [params1, params2, params3]


def last_cash():
    for i in range(0, 1):
        # -- P
        api_name = '获取最近一次使用过的提现渠道'
        url = '/v1/account/lastUsedWithdrawalChannel'
        # params = {
        #     "token": token
        # }
        if i >= len(params):
            print '入参:', params[0]
            result = base_requests.post(url, params[0])
        else:
            print '入参:', params[i]
            result = base_requests.post(url, params[i])

        if result:
            if result['code'] == 200:
                print colored('执行第 %d 次用例： %s接口 -- Pass' % (i + 1, api_name), 'green'), '\n'
            else:
                print colored('执行第 %d 次用例： %s接口  -- Failed' % (i + 1, api_name), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result

last_cash()
