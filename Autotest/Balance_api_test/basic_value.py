# coding=utf-8

import balance_gift
import account_detail
import balance_recharge
import bind_channel
#import edit_withdraw_channel
import get_cash
import get_user_balance
import last_cash
import get_refund_account


if __name__ == '__main__':

    print '\n---------------余额项目接口测试用例执行-----------\n'

    for i in range(1, 2):
        balance_gift.balance_gift()
        get_cash.get_cash()
        last_cash.last_cash()
        get_user_balance.get_user_balance()
        get_refund_account.get_refund_account()
        account_detail.account_detail()
        balance_recharge.balance_recharge()
        bind_channel.bind_channel()

