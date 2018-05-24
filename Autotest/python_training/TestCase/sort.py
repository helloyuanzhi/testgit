# coding=utf-8

import random

random_paging = random.randint(1, 10)
print random_paging
a = '/html/body/div/div[2]/section/div/div/div[3]/pagination/ul/li[%d]/a' % random_paging
print  a

class parent:
    def __init__(self):
        print "父类构造函数"
    def parentMenthod(self):
        print "父类方法"
    def setAtrr(self,attr):
        parent.parentattr = attr
    def getAtr(self):
        print "父类型属性：" ,parent.parentattr
class child(parent):
    def __init__(self):
        print "调用子类型构造方法"
    def childMethod(self):
        print "子类方法"

c = child()
c.parentMenthod()
c.childMethod()
c.setAtrr(199)
c.getAtr()
d = parent()
d.setAtrr(399)
d.getAtr()