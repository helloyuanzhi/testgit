# coding=utf-8
import base_requests
from termcolor import *

# -- P

def add_theoryQuestion():
    for i in range(5, 10):

        api_name = '添加理论题目'

        url = 'v1/coach_apply/addTheoryQuestion'

        params = {
            "questionTitle": "宇豪添加判断题%d"%i,
            # // 题目标题
            "questionType": 0,
            # // 题目类型（0：判断
            # 1：单选
            # 2：多选）
            "judgeCorrectAnswer": "true",
            # // 判断题是否正确
            "applyChoiceOptionBeans": [
                {
                    "chooseAnswer": "true",
                    # // 是否正确答案
                    "content": "平板支撑核心要收紧"
                    # // 选项内容
                }, {
                    "chooseAnswer": "false",
                    # // 是否正确答案
                    "content": "平板支撑核心不需要收紧"
                    # // 选项内容
                }
            ]
            # // 选项列表（非选择题则传空数组）
        }

        result = base_requests.post2(url, params)
        if result:
            if result['code'] == 0:
                print colored('%s：执行第 %d 次 用例 -- Pass' % (api_name, i), 'green'), '\n'

            else:
                print colored('%s：执行第 %d 次 用例 -- Failed' % (api_name, i), 'red'), '\n'

        else:
            print '接口异常，无法正常解析%s' % result


add_theoryQuestion()
