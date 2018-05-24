# coding=utf-8

import csv
import MySQLdb

conn = MySQLdb.connect(host='localhost',
                       user='root',
                       passwd='123456',
                       port=3306,
                       charset='utf8',
                       db='leke_coach'
                       )
cur = conn.cursor()

aa = cur.execute("SELECT coach_id FROM leke_coach.coach_business_hours")

val = 5
# 获取表中有多少条数据
print aa

info = cur.fetchmany(aa)
for i in range(len(info)):
    print info[i][0]

try:
    # 执行sql 语句
    cur.execute("insert into coach_business_hours values(%d,44,33,33,0)" % val)
    # 提交到数据库执行， update ,delete 都需要执行
    conn.commit()
except:

    conn.rollback

try:
    cur.execute("select * from coach_business_hours where id >2 ")
    result = cur.fetchall()
    for row in result:
        mid = row[0]
        mcoach_id = row[1]
        mopentime =row[2]
        mclosetime = row[3]
        misdel = row[4]

        print "id = %d, coach_id = %d, open_time= %d" \
              ",close_time = %d , is_del = %d" % (mid,mcoach_id,mopentime,mclosetime,misdel)

except:
    print "Erro"

cur.close()
conn.close()