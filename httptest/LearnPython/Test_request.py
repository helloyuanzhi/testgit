# coding=utf-8


import requests
import json


url = 'http://121.199.5.116:8080/v1/couponCenter/getCouponById'

payload = {"id": "809ce693fb8a4905aaec0bcdfc719f04"}


r = requests.post(url, json=payload)
#r.cookies['test_cookies']

res_load = json.loads(r.text)

if res_load['status']['code'] == 0:
    print 'True'
else:
    print 'False'


print r.text


print r.headers



