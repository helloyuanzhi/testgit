#!/usr/bin/env python
# coding=utf8

import base_test


pubilcparams = dict(deviceToken='1a12b22ab5579c16498e8d0ffc8f0e9354e687c0', cityCode='330100')




#添加100条活动数据

url ='/v1/activityCenter/createActivity'

params = {
    "type": "1",
    "name": "test2",
    "usedCondition": 1000,
    "welfare": 200,
    "priority": 2,
    "startTime": 1496387085,
    "endTime": 1596387085,
    "admin_id": 123,
    "totalNum": 100,
    "singleNum": 3,
    "subName": "addas",
    "activityDescribe": "fafadsfadf",
    "couponDescribe": "fafadsfadf",
    "businessIdArray": [1,2,3,4],
    "goodsIdArray": [2,3,4,5],
    "userGroupIdArray": [1,2,3,4],
    "cityIdArray":[1,2,3,4],
    "platformType":"1",
    "merchantType": "2",
    "merchantIdArray": [1,2,3,4,5,6]
}

if base_test.post('1', url, params):
    if base_test.result['1']['status']['code'] == 0:
        print 'Ture'
    else:
        print 'False'

    # 打印所有cookie
    for item in base_test.cookie:
        print 'cookie: name:%s value:%s domain:%s' % (item.name, item.value, item.domain)

    # 添加100条活动数据

    url = '/v1/activityCenter/getActivityById'

    params = {"id": "5871e3069fb74e22af82dc2539632ea2"}

    if base_test.post('2', url, params):
        if base_test.result['2']['status']['code'] == 0:
            print 'Ture'
        else:
            print 'False'

        # 打印所有cookie
        for item in base_test.cookie:
            print 'cookie: name:%s value:%s domain:%s' % (item.name, item.value, item.domain)





# 测试用例 2
# url = '/user/v1/sendmsg'
#
# params = {
# 'cellphone': '11575495146',
# 'code_type': 2,
# "ticket": 1,
# "version": '2.1.2'}
#
# if base_test.post('2', url, params):
#     if base_test.result['2']['errCode'] == 1000:
#         print 'True'
#     else:
#         print 'False'
#
# # 打印所有cookie
# for item in base_test.cookie:
#     print 'cookie: name:%s value:%s domain:%s' % (item.name, item.value, item.domain)

# # 测试用例 2
# url = '/order/status'
# params = {'orderNum':'JYK-01-1452606858974853354', 'deviceToken':'XXXX'}
#
# if base.post('2', url, params):
#     if base.result['2']['data']['orderStatus'] == 4:
#         print 'True'
#     else:
#         print 'False'

# 测试用例 3
# url = '/order/status'
# params = {'orderNum': 'JYK-01-1459309449712376065', 'deviceToken': '1a12b22ab5579c16498e8d0ffc8f0e9354e687c0'}
#
# if base_test.post('3', url, params):
#     if base_test.result['3']['data']['orderStatus'] == 0:
#         print 'True'
#     else:
#         print 'False'

# # 测试用例 4
# url = '/order/list2'
# privateparams = dict(status='0', currentPage='1', pageSize='10')
# params = dict(privateparams, **pubilcparams)
#
# if base.post('4', url, params):
#     data = base.result['4']['data']
#     for i in data:
#         if i['cureItemId'] == 78263:
#             print str(i['cureItemId'])+'---True'
#         else:
#             print 'False'
#
#             # if base.result['4']['result']:
#             #     print 'True'
#             # else:
#             #     print 'False'
# # 测试用例 5
# url = '/banner/listenabled'
# privateparams = dict(adType='homePageEntrance', oldVersion='0')
# params = dict(privateparams, **pubilcparams)
# if base.post('5', url, params):
#     if base.result['5']['result']:
#         print 'True'
#     else:
#         print 'False'
#
# # 测试用例 6
# url = '/serving/recommend'
# privateparams = {'serviceType': '-1', 'currentPage': '1', 'pageSize': '-1'}
# params = dict(privateparams, **pubilcparams)
# if base.post('6', url, params):
#     if base.result['6']['result']:
#         print 'True'
#     else:
#         print 'False'
#
#
# # 测试用例 7
# url = '/serving/detail2'
# privateparams = dict(serviceId='58')
# params = dict(privateparams, **pubilcparams)
# if base.post('7', url, params):
#     if base.result['7']['result']:
#         print 'True'
#     else:
#         print 'False'
#
#
# # 测试用例 8
# url = '/store/list'
# privateparams = dict(serviceId='58',longitude='120.003943',latitude='30.291519')
# params = dict(privateparams, **pubilcparams)
# if base.post('8', url, params):
#     if base.result['8']['result']:
#         print 'True'
#     else:
#         print 'False'
#
# # 测试用例 9
# url = '/order/limit'
# privateparams = dict(serviceId='58')
# params = dict(privateparams, **pubilcparams)
# if base.post('9', url, params):
#     if base.result['9']['result']:
#         print 'True'
#     else:
#         print 'False'
# # 测试用例 10
# url = '/contact/list'
# privateparams = dict(providerId='')
# params = dict(privateparams, **pubilcparams)
# if base.post('10', url, params):
#     if base.result['10']['result']:
#         print 'True'
#     else:
#         print 'False'
# # 测试用例 11
# url = '/store/contact'
# privateparams = dict(sign='Android')
# params = dict(privateparams, **pubilcparams)
# if base.post('11', url, params):
#     if base.result['11']['result']:
#         print 'True'
#     else:
#         print 'False'
# # 测试用例 12
# url = '/schedule/areaServiceScheduleFromToday'
# privateparams = dict(serviceId='58',areaCode='330108001',duration='30',providerId='')
#
# params = dict(privateparams, **pubilcparams)
# if base.post('12', url, params):
#     if base.result['12']['result']:
#         print 'True'
#     else:
#         print 'False'
#
# # 测试用例 13
# url = '/provider/reportLocation'
# privateparams = dict(isOnline='false',providerName='%E8%BF%9C%E5%BF%97',location='120.00394%2C30.291518')
# params = dict(privateparams, **pubilcparams)
# if base.post('13', url, params):
#     if base.result['13']['result']:
#         print 'True'
#     else:
#         print 'False'
#
# # 测试用例 14
# url = '/provider/list'
# privateparams = dict(areaCode='330108001',dayCode='0',timeCode='18',servType='1',
#                     serviceId='58', duration='30',currentPage='1',pageSize='10')
# params = dict(privateparams, **pubilcparams)
# if base.post('14', url, params):
#     if base.result['14']['result']:
#         print 'True'
#     else:
#         print 'False'
#
#
#
# # 测试用例 15
# url = '/coupon/available'
# privateparams = dict(servType='1',serviceId='58', amount='1')
# params = dict(privateparams, **pubilcparams)
# if base.post('15', url, params):
#     if base.result['15']['result']:
#         print 'True'
#     else:
#         print 'False'






