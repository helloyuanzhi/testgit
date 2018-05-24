# coding=utf8


import  random
channellist = ['wx_pub', 'alipay_wap', 'jdpay_wap']
channel = ','.join(random.sample(channellist, 1))

print type(channel)
print channel