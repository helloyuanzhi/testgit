#!/usr/bin/python
# coding=utf-8


time_point=["6:00","6:30","7:00","7:30","8:00","8:30",
   "9:00","9:30","10:00","10:30","11:00","11:30",
   "12:00","12:30","13:00","13:30","14:00","14:30",
   "15:00","15:30","16:00","16:30","17:00","17:30",
   "18:00","18:30","19:00","19:30","20:00","20:30",
   "21:00","21:30","22:00","22:30","23:00","23:30"]

while True:
    str = raw_input("请输入正确的36个时间点:")
    arr = list(str)
    if str.isdigit() and len(arr)==36:
        print '输入时间点正确！'
        for i in range(0,len(arr)):
            if int(arr[i])==0:
                 for j in range(0,len(time_point)):
                     if i==j:
                        print "第%d个时间点被占用"%(i+1),time_point[j]
        break
    else:
        print 'error!输入的时间点错误请查看重新输入（规则：36个点，无其他特殊符号）'
