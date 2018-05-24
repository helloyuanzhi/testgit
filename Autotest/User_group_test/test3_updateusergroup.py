# coding=utf-8
import base_requests
from termcolor import *
import uniout
import random


# -- P 前端限制

def update_user_group():
    for i in range(0, 1):

        api_name = '修改分群类型接口'
        url = 'v1/rights/updateUserGroup'

        name = '宇豪测试修改收拾收拾收拾收拾宿舍%d' % i
        description = '宇豪测试分群描述修改收拾收拾%d' % i
        bizType = random.randint(0, 10)
        id = random.randint(130, 132)
        params = {

            "id": id,
            "name": name,
            "description": description,
            "bizType": bizType
            # 分群类型 归属业务线：
            # 0综合业务
            # 1, 私教业务;
            # 2, 会员业务;
            # 3, 场景业务;
            # 4, 精品团课业务;
            # 5, 电商业务;
            # 6, 恐龙快跑业务;
            # 7, 储物柜
        }

        result = base_requests.post2(url, params)
        if result:
            if result['status']['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i + 1), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i + 1), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


#pdate_user_group()
