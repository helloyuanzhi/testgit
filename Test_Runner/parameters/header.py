# coding=utf-8


"""
header参数文件
:author: author <author@126.com>
"""

from common_config import CommonConfig


class Header(CommonConfig):

    def Accept_Encoding(self):
        """
        Accept_Encoding
        :return:
        """
        return self.cf.get("header", "Accept-Encoding")

    def User_Agent(self):
        """
        User_Agent
        :return:
        """
        return self.cf.get("header", "User-Agent")

    def content_type(self):
        """
        content_type
        :return:
        """
        return self.cf.get("header", "content-type")

    def content_type_two(self):
        """
        content_type_two
        :return:
        """
        return self.cf.get("header", "content-type-two")

    def Connection(self):
        """
        Connection
        :return:
        """
        return self.cf.get("header", "Connection")

    def mobile_type(self):
        """
        mobile_type
        :return:
        """
        return self.cf.get("header", "mobile_type")

