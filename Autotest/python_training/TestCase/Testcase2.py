# coding=utf-8
import random

def comparNum(num1,num2):
    if (num1>num2):
        return 1
    elif (num1==num2):
        return 0
    else:
        return -1
num1 = random.randrange(1,9)
num2 = random.randrange(1,9)

print "num1= ",num1
print "num2= ",num2
print comparNum(num1,num2)

class A:
    def funX(self):
        print "funY()"
    def funY(self):
        print "funX()"

if __name__ == "__main__":

    a= A()
    a.funX()
    a.funY()

def definNum(num):
    if num >=0 :
        if num >0:
            return "\nx为正数\n"
        else:
            return "\nx为０"
    else:
        return "\nx为负数\n"

print definNum(-2)


# def inputCompare(num1,num2):
#
#      if num1> num2:
#          return num1,">",num2
#      else:
#         return num1,"<",num2
# num1 = input("a= ")
# num2 = input("b= ")
#
# print inputCompare(num1,num2)


class switch(object):
    def __init__(self,value):
        self.value = value
        self.fall = False
    def __iter__(self):
        yield self.match
        raise StopIteration
    def match(self,*args):
        if self.fall or not args:
            return True
        elif self.value in args:
            self.fall = True
            return True
        else:
            return False
operator = '+'
x= 1
y =2
for case in switch(operator):
    if case("+"):
        print x+y
        break
    if case('-'):
        print x-y
        break
# numbers = raw_input("请输入几个数字，用逗号分隔: ").split(",")
# print  numbers
# x= 0
# while x< len(numbers):
#     x+=1
# print x



x = input("x = ")
y =0
for y in range(1,100):

    if x!=y:
        print "y= ",y
        continue
    else:
        print "x=y= ",x
        break









