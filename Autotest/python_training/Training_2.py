# coding=utf8




#
# 优惠券跟活动模块使用的是公共组的接口，他们开发使用mongodb数据库，
# mongo.host=121.199.5.116:3717
# mongo.username=helong
# mongo.password=helong
# mongo.dbname=activity
#
# 本轮测试没有添加新的接口，改动原来的接口：
# 下单接口：http://git.leoao.com/xiaodong/lefit-app-web-api/src/activity#请求路径postv1orderunifiedorder
# 下单页获取优惠券接口：http://git.leoao.com/xiaodong/lefit-app-web-api/src/activity#请求路径post-v1counpon
# 下单页详情接口：http://git.leoao.com/xiaodong/lefit-app-web-api/src/activity#请求路径postv1lessonlessontypes
#
# 注意：实体卡活动的逻辑