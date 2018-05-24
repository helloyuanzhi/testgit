# coding=utf-8
import base_requests
from termcolor import *
import uniout
import random


# -- P 前端限制

def order_unifiedorder():
    for i in range(0, 1):

        api_name = '统一下单接口'
        url = 'v1/order/unifiedorder'

        params = {
            "token": "09ad1a5b2545bc4f700cfd7dc237bcda",
            "bizType": 1,
            # 业务线：1私教，2团操，3训练营，4 电商
            "cityId": 12597,
            # 城市ID可为空
            "coachId": 149,
            # 教练ID，服务端验证ID是否合法
            "couponId": [],
            # 优惠券ID
            "activityNo": [6],
            # 活动ID
            "goodsEntities": [
                {
                    "goodsNo": "01250",
                    # 商品编号
                    "goodsNum": 8,
                    # 商品数量,
                    "size": "one",
                    # 规格：one, two, 表示1v1, 1v2
                }],
            "sourceType": 4,
            # 订单来源类型：1 app-ios  2 app-安卓 3 m站-安卓 4 m站-ios  5 手动添加
            "storeAreaId": 130,
            # // 场地ID，服务端校验教练对应的场地ID是否存在,

            # "extra": {
            #     # // 体验课配置可为空
            #     "expectLess": "增肌",
            #     "expectSex": "男教练",
            #     # // 期望教练性别
            #     "expectTime": "9-10",
            #     # // 期望时间短
            #     "expectAreaId": 10,
            #     # // 期望场地
            #     "remark": "备注"
            # },
            "startDate": 'null',
            # "actCode": "act999"
            # "groupOrderParams": {
            #     # // 可以为空，不为空，并且type != null & & type != 0 会走小团拼团的逻辑
            #     "type": 1,
            #     # // 1表示拼团，2 表示小团课
            #     "groupId": 1,
            #     "modelId": 2
            #     # // 拼团的时候需要选择的模板
            # }

        }
        result = base_requests.post(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i + 1), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i + 1), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


order_unifiedorder()
