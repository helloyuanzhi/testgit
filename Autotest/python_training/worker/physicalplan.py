# coding=utf-8

from worker import base

from python_training.worker import getpwd

# 测试用例 2
url = '/user/passwordLogin'
passt = getpwd.getpassword()
params = {'mobile': '13575495146', 'password': passt, "deviceToken": '1a12b22ab5579c16498e8d0ffc8f0e9354e687c0'}

if base.post('2', url, params):
    if base.result['2']['result'] and base.result['2']['data']['id'] == 63046:
        print 'True'
    else:
        print 'False'


# 测试用例 2
url = '/order/userserviceplanitems'

params = {'orderNum': 'JYK-10-1464678511003714900', 'kind': 0, "deviceToken": '1a12b22ab5579c16498e8d0ffc8f0e9354e687c0'}

if base.post('3', url, params):
    if base.result['3']['result']:
        print 'True'
    else:
        print 'False'

