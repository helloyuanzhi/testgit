# coding=utf8

"""

题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去 掉不满足条件的排列。

"""






for i in range(1,5):
    for j in range(1,5):
        for k in range(1,5):
         print i,j,k


# num = raw_input("请用逗号隔开，")
#
# my_num = []
# for n in num.split():
#     my_num.append(n)
#
# print my_num


a = input("请输入第一个数：")
b = input("请输入第二个数：")
c = input("请输入第三个数：")



d = min(a,b,c)

print d

if a > b:
    if a > c:
        print a
    else:
        print c
else:
    if b > c:
        print b
    else:
        print c

