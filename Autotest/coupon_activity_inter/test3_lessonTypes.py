# coding=utf-8
import base_requests
from termcolor import *
import uniout
import random
import Balance_api_test.main_excute

# -- P 前端限制

def get_lessonTypes():
    for i in range(0, 1):

        api_name = '商品编号获取所有商品规格接口'
        url = 'v1/lesson/lessonTypes'
        token = Balance_api_test.main_excute.token
        params = {

            "coachId": 1262,
            # // 教练ID
            "goodsNo": "01241",
            # // 商品编号
            "actCode": "act999"
            #  获取体验课价格增加 actCode 参数，值为 act990。
            #"token": token

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


get_lessonTypes()
