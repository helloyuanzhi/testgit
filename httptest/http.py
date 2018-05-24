#!/usr/bin/env python
# coding=utf8
import base

headers = {"Content-type": "application/json"}


    
#测试用例 1
url = '/v1/couponCenter/getCouponById'
params = {"id": "809ce693fb8a4905aaec0bcdfc719f04"}


if base.post('1', url, params, headers):
    if base.result['1']['status']['code'] == 0:
        print 'True'
    else:
        print 'False'
        
#打印所有cookie
for item in base.cookie:
    print 'cookie: name:%s value:%s domain:%s' % (item.name, item.value, item.domain)
    


