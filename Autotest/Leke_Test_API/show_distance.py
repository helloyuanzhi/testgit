# coding=utf-8

from termcolor import *

import cacul_lnglat
import mysql_connect

print '\n当前经纬度 ： lng = %f，lat =%f， 教练id = %d' % \
      (mysql_connect.inputlng, mysql_connect.inputlat, mysql_connect.coach_id), '\n'

arrlng = []
arrlat = []
arrname = []

for i in range(0, len(mysql_connect.store_lng)):
    a = list(tuple(mysql_connect.store_lng[i]))
    arrlng.extend(a)

for i in range(0, len(mysql_connect.store_lat)):
    a = list(tuple(mysql_connect.store_lat[i]))
    arrlat.extend(a)

for i in range(0, len(mysql_connect.store_name)):
    a = list(tuple(mysql_connect.store_name[i]))
    arrname.extend(a)

list1 = []
d1 = []
list2 = []
d2 = []
list3 = []
d3 = []
list4 = []
d4 = []

for i in range(0, len(mysql_connect.store_name)):

    distance = cacul_lnglat.geodistance(mysql_connect.inputlng, mysql_connect.inputlat, arrlng[i], arrlat[i])
    if distance <= 3:
        list1.append(mysql_connect.store_name[i])
        d1.append(distance)
    elif distance <= 10:
        list2.append(mysql_connect.store_name[i])
        d2.append(distance)
    elif distance <= 20:
        list3.append(mysql_connect.store_name[i])
        d3.append(distance)
    else:
        list4.append(mysql_connect.store_name[i])
        d4.append(distance)

for i in range(0, len(list1)):
    print colored('距离3km以内的门店：', "red"), colored(list1[i][0], "red"), '距离 -- %0.2f' % d1[i], 'km'

for i in range(0, len(list2)):
    print colored('距离10km以内的门店：', "green"), colored(list2[i][0], "green"), '距离 -- %0.2f' % d2[i], 'km'

for i in range(0, len(list3)):
    print colored('距离20km以内的门店：', "yellow"), colored(list3[i][0], "yellow"), '距离 -- %0.2f' % d3[i], 'km'

    # for i in range(0, len(list4)):
    #     print '距离3km以上 的门店：', list4[i][0],'距离 -- %0.2f'%d4[i],'km'
