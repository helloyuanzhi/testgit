# coding=utf-8

import configparser
import os

class CommonConfig:
    def __init__(self):
        """
        读取配置文件
        """
        # 实例化configParser对象
        self.cf = configparser.ConfigParser()
        # 获取当前文件夹的绝对路径
        self.path = os.path.dirname(os.path.dirname(__file__))
        self.file_path = os.path.join(self.path, "config", "formal_data.ini")
        self.cf.read(self.file_path,encoding="UTF-8")
