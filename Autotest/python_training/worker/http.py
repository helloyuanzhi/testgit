#!/usr/bin/env python
# coding=utf8
from worker import base

from python_training.worker import getpwd

# headers = {"Content-type":"application/x-www-form-urlencoded", "Accept": "text/plain"}

pubilcparams = dict(deviceToken='1a12b22ab5579c16498e8d0ffc8f0e9354e687c0', cityCode='330100')

# captcha = raw_input('请输入验证码: ')
# print captcha
#
#
#
# # 测试用例 1
# url = '/user/captchaLogin'
# params = {'mobile': '13575495146', 'captcha': captcha, "deviceToken": '1a12b22ab5579c16498e8d0ffc8f0e9354e687c0'}
#
# if base.post('1', url, params):
#     print 'test' + str(base.result['1']['result'])
#     # if base.result['1']['result']:
#     #     print 'True'
#     # else:
#     #     print 'False'




# 测试用例 2
url = '/user/passwordLogin'
passt = getpwd.getpassword()
params = {'mobile': '13575495146', 'password': passt, "deviceToken": '1a12b22ab5579c16498e8d0ffc8f0e9354e687c0'}

if base.post('2', url, params):
    if base.result['2']['result']:
        print 'True'
    else:
        print 'False'

# 打印所有cookie
for item in base.cookie:
    print 'cookie: name:%s value:%s domain:%s' % (item.name, item.value, item.domain)

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
url = '/order/status'
params = {'orderNum': 'JYK-01-1459309449712376065', 'deviceToken': '1a12b22ab5579c16498e8d0ffc8f0e9354e687c0'}

if base.post('3', url, params):
    if base.result['3']['data']['orderStatus'] == 0:
        print 'True'
    else:
        print 'False'

# 测试用例 4
url = '/order/list2'
privateparams = dict(status='0', currentPage='1', pageSize='10')
params = dict(privateparams, **pubilcparams)

if base.post('4', url, params):
    data = base.result['4']['data']
    for i in data:
        if i['cureItemId'] == 78263:
            print str(i['cureItemId'])+'---True'
        else:
            print 'False'

            # if base.result['4']['result']:
            #     print 'True'
            # else:
            #     print 'False'
# 测试用例 5
url = '/banner/listenabled'
privateparams = dict(adType='homePageEntrance', oldVersion='0')
params = dict(privateparams, **pubilcparams)
if base.post('5', url, params):
    if base.result['5']['result']:
        print 'True'
    else:
        print 'False'

# 测试用例 6
url = '/serving/recommend'
privateparams = {'serviceType': '-1', 'currentPage': '1', 'pageSize': '-1'}
params = dict(privateparams, **pubilcparams)
if base.post('6', url, params):
    if base.result['6']['result']:
        print 'True'
    else:
        print 'False'


# 测试用例 7
url = '/serving/detail2'
privateparams = dict(serviceId='58')
params = dict(privateparams, **pubilcparams)
if base.post('7', url, params):
    if base.result['7']['result']:
        print 'True'
    else:
        print 'False'


# 测试用例 8
url = '/store/list'
privateparams = dict(serviceId='58',longitude='120.003943',latitude='30.291519')
params = dict(privateparams, **pubilcparams)
if base.post('8', url, params):
    if base.result['8']['result']:
        print 'True'
    else:
        print 'False'

# 测试用例 9
url = '/order/limit'
privateparams = dict(serviceId='58')
params = dict(privateparams, **pubilcparams)
if base.post('9', url, params):
    if base.result['9']['result']:
        print 'True'
    else:
        print 'False'
# 测试用例 10
url = '/contact/list'
privateparams = dict(providerId='')
params = dict(privateparams, **pubilcparams)
if base.post('10', url, params):
    if base.result['10']['result']:
        print 'True'
    else:
        print 'False'
# 测试用例 11
url = '/store/contact'
privateparams = dict(sign='Android')
params = dict(privateparams, **pubilcparams)
if base.post('11', url, params):
    if base.result['11']['result']:
        print 'True'
    else:
        print 'False'
# 测试用例 12
url = '/schedule/areaServiceScheduleFromToday'
privateparams = dict(serviceId='58',areaCode='330108001',duration='30',providerId='')

params = dict(privateparams, **pubilcparams)
if base.post('12', url, params):
    if base.result['12']['result']:
        print 'True'
    else:
        print 'False'

# 测试用例 13
url = '/provider/reportLocation'
privateparams = dict(isOnline='false',providerName='%E8%BF%9C%E5%BF%97',location='120.00394%2C30.291518')
params = dict(privateparams, **pubilcparams)
if base.post('13', url, params):
    if base.result['13']['result']:
        print 'True'
    else:
        print 'False'

# 测试用例 14
url = '/provider/list'
privateparams = dict(areaCode='330108001',dayCode='0',timeCode='18',servType='1',
                    serviceId='58', duration='30',currentPage='1',pageSize='10')
params = dict(privateparams, **pubilcparams)
if base.post('14', url, params):
    if base.result['14']['result']:
        print 'True'
    else:
        print 'False'



# 测试用例 15
url = '/coupon/available'
privateparams = dict(servType='1',serviceId='58', amount='1')
params = dict(privateparams, **pubilcparams)
if base.post('15', url, params):
    if base.result['15']['result']:
        print 'True'
    else:
        print 'False'






