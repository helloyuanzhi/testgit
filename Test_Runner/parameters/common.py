# coding=utf-8


from common_config import CommonConfig


class Common(CommonConfig):

    def base_url(self):
        """
        base_url
        :return:
        """
        return self.cf.get("common", "base_url")

    def openId(self):
        """
        微信openId
        :return:
        """
        return self.cf.get("common", "openId")

