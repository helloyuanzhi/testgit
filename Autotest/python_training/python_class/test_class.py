# coding=utf-8

class Employee:

    empcount = 0

    def __init__(self,name,salary):
        self.name = name
        self.salary = salary
        Employee.empcount += 1

    def displaycount(self):
        print 'Total employcount %d' % Employee.empcount

    def displayemploy(self):
        print 'Name : ',self.name,",","salary",self.salary

emp1 = Employee('jinyuhao',9000)
emp2 = Employee('lijing',100000)

emp1.displaycount()
emp1.displayemploy()
emp2.displayemploy()
