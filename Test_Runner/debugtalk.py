# coding=utf-8
import random


def get_userid(num):
    account = []
    for i in range(0, num):
        random_userid = random.randint(100,100000)
        account.append({"user_id": random_userid})
    return account

def get_grouparry(num):
    account = []
    for i in range(0, num):
        random_userid = random.randint(100,100000)
        account.append({"coachId": random_userid})
    return account
