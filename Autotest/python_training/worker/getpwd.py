# coding=utf-8

import MySQLdb

def getpassword():
    conn = MySQLdb.connect(host='rdsnfrmzrvfybueo.mysql.rds.aliyuncs.com',
                           user='jyktest',
                           passwd='jyk123',
                           port=3306,
                           db='jyk_1kf')
    cur = conn.cursor()
    cur.execute("select password from um_identity where cell_num =13575495146")
    for p in cur.fetchall():
        a = p[0]
    return a
    conn.commit
    cur.close()
    conn.close()