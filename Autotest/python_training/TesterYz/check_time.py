#!/usr/bin/python
# coding=utf-8

time_point = ["6:00", "6:30", "7:00", "7:30", "8:00", "8:30",
              "9:00", "9:30", "10:00", "10:30", "11:00", "11:30",
              "12:00", "12:30", "13:00", "13:30", "14:00", "14:30",
              "15:00", "15:30", "16:00", "16:30", "17:00", "17:30",
              "18:00", "18:30", "19:00", "19:30", "20:00", "20:30",
              "21:00", "21:30", "22:00", "22:30", "23:00", "23:30"]


def get_occur(time):
    arr = map(int, time)
    occur = []
    for i, t in enumerate(arr):
        if t == 0:
            p = time_point[i]
            occur.append(p)
    return occur


def input():
    while True:
        time = raw_input("请输入正确的36个时间点:\n")
        if time.isdigit() and len(time) == len(time_point):
            break
        else:
            print "输入时间点不正确，请重新输入"
    return time


def process():
    time = input()
    occur = get_occur(time)
    if not occur:
        print '没有时间点被占用'
    else:
        print '占用时间：', ','.join(occur)


def main():
    while True:
        process()
        print '-'*30


if __name__ == '__main__':
    main()
