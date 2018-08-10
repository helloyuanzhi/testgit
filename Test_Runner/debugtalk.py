# coding=utf-8
import random


def get_account(num):
    account = []
    for i in range(0, num):
        account.append({"coachId": "12%s" % i})
    return account
