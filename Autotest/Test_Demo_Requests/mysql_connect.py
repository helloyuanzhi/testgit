# coding=utf-8

import MySQLdb
from flask import json

conn = MySQLdb.connect(host='172.16.150.99',
                           user='root',
                           passwd='lefit@sit',
                           port=3306,
                           db='leoao_coach',
                           charset='utf8')
cur = conn.cursor()



aa = cur.execute("select title from ad_activities")

# 获取表中有多少条数据
print aa

info = cur.fetchmany(aa)
for i in range(len(info)):
    print info[i][0]

conn.commit
cur.close()
conn.close()