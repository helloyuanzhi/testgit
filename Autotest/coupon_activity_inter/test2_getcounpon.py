# coding=utf-8
import base_requests
from termcolor import *
import uniout
import random
import Balance_api_test.main_excute
# -- P 前端限制






def get_counpon():
    for i in range(0, 1):

        api_name = '用户下单获取可用的优惠券接口'
        url = 'v1/counpon/userList'
        token = Balance_api_test.main_excute.token
        params = {

            #"token": token,
            # // 不能为空
            "goodsNo": "01241",
            # // 商品编号，可以为空，新家的参数，客户端目前不会上传上来
            "sourceType": "1",
            # // 客户端类型:iOS，android, M站..新加的参数, 可以为空
            "orderFee": 14000,
            # // 订单价格Integer类型，筛选只能小于这个价格的优惠券可以为空
            "goodsNum":8
            # // 购买数量，Integer类型，筛选合适的优惠券可以为空

        }
        print '入参:', params
        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i+1), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i+1), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


get_counpon()


#
# def get_v2_order():
#     for i in range(0, 1):
#         api_name = '订单详情'
#         url = 'v2/order/detail'
#         params = {
#
#             # "token": token,
#             # // 不能为空
#             "orderNo": "895618907669266432"
#
#
#         }
#         print '入参:', params
#         result = base_requests.post(url, params)
#         if result:
#             if result['code'] == 0:
#                 print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i + 1), 'green'), '\n'
#
#             else:
#                 print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i + 1), 'red'), '\n'
#
#         else:
#             print '接口异常，无法正常解析%s' % result
# get_v2_order()