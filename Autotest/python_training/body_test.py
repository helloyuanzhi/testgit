# coding=utf8

import random

score_li = []
char_li = []
x = 0
while x < 28:
    x += 1
#   score_num = input('\n 请输入第 --  %d -- 道题的得分： = ' %x)
    score_num = random.randint(0, 2)
    if score_num == 2:
        num_a = 'A'
        char_li.append('A')
        print ('第 -- %d -- 道题得分：= %d -- 对应 %s'% (x, score_num, num_a))
    elif score_num == 1:
        num_a = 'B'
        char_li.append('B')
        print ('第 -- %d -- 道题得分：= %d -- 对应 %s'% (x, score_num, num_a))
    elif score_num == 0:
        num_a = 'C'
        char_li.append('C')
        print ('第 -- %d -- 道题得分：= %d -- 对应 %s'% (x, score_num, num_a))
    score_li.append(score_num)


print '\n'
for j in range(len(char_li)):
    print ('%d->' % (j+1)), char_li[j],

print '\n-------------各种体质单项分数明细---------\n'


yin_xu = score_li[0]+score_li[2]+score_li[7]+score_li[11]
print '阴虚体质= %d + %d + %d + %d '% (score_li[0], score_li[2], score_li[7], score_li[11])

qi_xu = score_li[1]+score_li[8]+score_li[21]+score_li[24]
print '气虚体质= %d + %d + %d + %d '% (score_li[1],score_li[8],score_li[21],score_li[24])

shi_re = score_li[3]+score_li[9]+score_li[19]+score_li[27]
print '湿热体质= %d + %d + %d + %d '% (score_li[3],score_li[9],score_li[19],score_li[27])

xue_yu = score_li[4]+score_li[12]+score_li[20]+score_li[25]
print '血瘀体质= %d + %d + %d + %d '% (score_li[4],score_li[12],score_li[20],score_li[25])

qi_yu = score_li[5]+score_li[13]+score_li[18]+score_li[22]
print '气郁体质= %d + %d + %d + %d '% (score_li[5],score_li[13],score_li[18],score_li[22])

tan_shi = score_li[6]+score_li[10]+score_li[15]+score_li[26]
print '痰湿体质= %d + %d + %d + %d '% (score_li[6],score_li[10],score_li[15],score_li[26])

yang_xu = score_li[14]+score_li[16]+score_li[17]+score_li[23]
print '阳虚体质= %d + %d + %d + %d '% (score_li[14],score_li[16],score_li[17],score_li[23])

result_list = {u'阴虚体质': yin_xu, u'气虚体质': qi_xu, u'湿热体质': shi_re,
               u'血瘀体质': xue_yu, u'气郁体质': qi_yu, u'阳虚体质': yang_xu, u'痰湿体质':tan_shi}

result_lists = sorted(result_list.iteritems(), key=lambda d: d[1], reverse=True)


print '\n-------------体质单分数排序---------\n'
for item in result_lists:

    if max(yin_xu, qi_xu, shi_re, xue_yu, qi_yu, tan_shi, yang_xu) == 0:

        print '全为0，平和体质'

    else:
        print "%s  =  %d" % (item[0], item[1])


print '\n------------分数相等，明细相等时排序如下：湿热>痰湿>气虚>阴虚>阳虚>气郁>血瘀---------\n'


