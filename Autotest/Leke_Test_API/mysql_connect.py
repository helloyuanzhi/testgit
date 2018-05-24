# coding=utf-8

import MySQLdb

conn = MySQLdb.connect(host='rm-bp19t98sq8z3fkcyho.mysql.rds.aliyuncs.com',
                       user='java_group',
                       passwd='fVI3zVDYaq3bQ3D',
                       port=3306,
                       db='leoao_coach',
                       charset='utf8')
cur = conn.cursor()


# 输入 经纬度，查询附近可用门店

inputlng = 120.058325
inputlat = 30.289318

coach_id = 809


cur.execute("SELECT sa.store_name FROM coach_store_dict as csd inner join store_area as sa\
            on csd.store_id = sa.id\
            where csd.isDel = 0 and sa.status =2 and sa.is_upper =1 and sa.isDel =0 and csd.coach_id= %d" % coach_id)

store_name = cur.fetchall()
for i in range(len(store_name)):
    name = store_name[i]


cur.execute("SELECT sa.lng FROM coach_store_dict as csd inner join store_area as sa\
            on csd.store_id = sa.id\
            where csd.isDel = 0 and sa.status =2 and sa.is_upper =1 and sa.isDel =0 and csd.coach_id= %d" % coach_id)
store_lng = cur.fetchall()
for i in range(len(store_lng)):
    lng = store_lng[i]

cur.execute("SELECT sa.lat FROM coach_store_dict as csd inner join store_area as sa\
            on csd.store_id = sa.id\
            where csd.isDel = 0 and sa.status =2 and sa.is_upper =1 and sa.isDel =0 and csd.coach_id= %d" % coach_id)
store_lat = cur.fetchall()
for i in range(len(store_lat)):
    lat = store_lat[i]

cur.close()
conn.close()
